/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.*;
import sovelluslogiikka.sitsaajat.Sitsaaja;

/**
 * SitsaajienRyhmittaja ryhmittaa sitsaajat suosion perusteella
 * kaveriporukoihin. Eniten toiveita kerännyt ja hänen aveccinsa kaveritoiveet
 * toteutetaan ensimmäiseksi ja kaveritoiveille haetaan avecit. Ryhmittaja
 * jatkaa tätä kunnes kaikki toiveta saaneet on koottu kaveriporukoihin.
 *
 * @author Santeri
 */
public class SitsaajienRyhmittaja {

    private List<Sitsaaja> sitsaajatPisteytettyna;
    private List<Sitsaaja> sitsaajatIlmanpisteita;
    private List<Sitsaaja> joLisatytSitsaajat;
    private List<Integer> kaveriporukoidenPaikatRyhmitetyssaListassa;
    private SitsaajienPisteyttaja pisteyttaja;
    private List<Sitsaaja> mahdollisetAvecitKaverille;
    private List<List<Sitsaaja>> kaveriporukat;
    private List<Sitsaaja> porukkaKyseisellaIteraatiolla;
    private int poydanKoko;

    public SitsaajienRyhmittaja(SitsaajienPisteyttaja pisteyttaja) {
        kaveriporukoidenPaikatRyhmitetyssaListassa = new ArrayList<>();
        this.pisteyttaja = pisteyttaja;
        joLisatytSitsaajat = new ArrayList<>();
        kaveriporukat=new ArrayList<>();
    }

    /**
     * Ryhmittaa sitsaajat suosion ja kaveritoiveiden perusteella.
     */
    public void ryhmitaSitsaajat() {
        SetListat();
        for (Sitsaaja sitsaaja : sitsaajatPisteytettyna) {
            if (onkoSitsaajaJoPlassattu(sitsaaja)) continue;
            RyhmanSuosituinSitsaaja(sitsaaja);

        }
    }
    
    private boolean onkoSitsaajaJoPlassattu(Sitsaaja sitsaaja){
        if (this.joLisatytSitsaajat.contains(sitsaaja)) {
                return true;
            }
        return false;
    }

    /**
     * Asettaa ensimmaiseksi suosituimman sitsaajan jokaiseen ryhmaan.
     *
     * @param suosituin Sitsaaja jota on toivottu eniten.
     */
    protected void RyhmanSuosituinSitsaaja(Sitsaaja suosituin) {
        porukkaKyseisellaIteraatiolla=new ArrayList<>();
        porukkaKyseisellaIteraatiolla.add(suosituin);
        joLisatytSitsaajat.add(suosituin);
        suosituimmanAvecjosLoytyy(suosituin);
        kaveriporukat.add(porukkaKyseisellaIteraatiolla);
    }
    
    private boolean onkoKyseisenPorukkaJoLiianIso(){
        if(porukkaKyseisellaIteraatiolla.size()>10){
            return true;
        }
        return false;
    }

    /**
     * Asettaa toiseksi Suosituimman avecin jos tälläinen löytyy.
     *
     * @param suosituin Sitsaaja jota on toivottu eniten.
     */
    protected void suosituimmanAvecjosLoytyy(Sitsaaja suosituin) {
        if (suosituin.getAvec() != null) {
            porukkaKyseisellaIteraatiolla.add(suosituin.getAvec());
            joLisatytSitsaajat.add(suosituin.getAvec());
            suosituimmanJaAvecinKaveritoiveet(suosituin, suosituin.getAvec());
        } else {
            josAvecEiLoydy(suosituin, true, false);
        }
    }
    
    private boolean ovatkoSitsaajatSamaaSukupuolta(Sitsaaja sitsaaja, Sitsaaja avec){
        if( avec.getSukupuoli() == sitsaaja.getSukupuoli()){
            return true;
        }
        return false;
    }
    
    private void asetaAveceiksi (Sitsaaja sitsaaja, Sitsaaja avec){
        sitsaaja.setAvec(avec);
            avec.setAvec(sitsaaja);
    }

    /**
     * Jos ryhmän suosituimmalla sitsaajalla ei ole aveccia hänelle haetaan
     * sellainen.
     *
     * @param sitsaaja Sitsaaja jota on toivottu eniten.
     * @param onkoVikaKierros True jos etsitään suosituimman sitsaajan kaverin
     * aveccia.
     * @param loytyykoPisteytetyista True jos aveccia ei ole haettu
     * pisteytettyjen sitsaajien joukosta.
     */
    protected void josAvecEiLoydy(Sitsaaja sitsaaja, boolean loytyykoPisteytetyista, boolean sukupuolenVaihdos) {
        List<Sitsaaja> tmp = sitsaajatPisteytettyna;
        if (loytyykoPisteytetyista == false) {
            tmp = sitsaajatIlmanpisteita;
        }
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i) == null || onkoSitsaajaJoPlassattu(tmp.get(i)) || ovatkoSitsaajatSamaaSukupuolta(sitsaaja, tmp.get(i))|| tmp.get(i).getAvec() != null) {
                if (i == tmp.size() - 1 && loytyykoPisteytetyista == true) {
                    josAvecEiLoydy(sitsaaja, false, sukupuolenVaihdos);
                    break;
                } else if (i == tmp.size() - 1 && loytyykoPisteytetyista == false && sukupuolenVaihdos == false) {
                    sitsaaja.vaihdaSukupuolta();
                    josAvecEiLoydy(sitsaaja, true, true);
                    break;
                }
                continue;
            }
            Sitsaaja avec = tmp.get(i);
            asetaAveceiksi(sitsaaja, avec);
            porukkaKyseisellaIteraatiolla.add(avec);
            joLisatytSitsaajat.add(avec);
            suosituimmanJaAvecinKaveritoiveet(sitsaaja, avec);
            break;
        }
        if (sukupuolenVaihdos == true) {
            sitsaaja.vaihdaSukupuolta();
        }
    }

    /**
     * Käy läpi kaikki ryhmän suosituimman ja hänen aveccinsa kaveritoiveet.
     * Aluksi etsitään yhteisiä kaverieta ja sitten siirrytään sitsaajan ja
     * avecin yksilöllisiin kaveritoiveisiin.
     *
     * @param sitsaaja Ryhmän suosituin sitsaaja.
     * @param avec Suosituimman sitsaajan avec.
     */
    protected void suosituimmanJaAvecinKaveritoiveet(Sitsaaja sitsaaja, Sitsaaja avec) {
        List<Sitsaaja> yhteisetkaverit = leikkaus(sitsaaja, avec);
        if (!yhteisetkaverit.isEmpty()) {
            asetaSitsaajalleJaAvecilleKaveri(yhteisetkaverit, sitsaaja, avec);
        }
        if (!sitsaaja.kaverit.isEmpty()) {
            asetaSitsaajalleJaAvecilleKaveri(sitsaaja.kaverit, sitsaaja, avec);
        }
        if (!avec.kaverit.isEmpty()) {
            asetaSitsaajalleJaAvecilleKaveri(avec.kaverit, sitsaaja, avec);
        }

        asetaKaveriListastaJosSitsaajallaJaAvecillaEiToiveita(sitsaaja, avec);
        
        laitaMerkkiTestaustaVarten();
        
    }

    /**
     * Jos avecilla ja sitsaajalla ei ole toiveita haetaan heille kuitenkin
     * heitä toivoneet sitsaajat listasta.
     *
     * @param suosituin Ryhmän suosituin sitsaaja.
     * @param avec Suosituimman avec.
     */
    protected void asetaKaveriListastaJosSitsaajallaJaAvecillaEiToiveita(Sitsaaja suosituin, Sitsaaja avec) {
        for (Sitsaaja sitsaaja : this.sitsaajatPisteytettyna) {
            if (onkoSitsaajaJoPlassattu(sitsaaja)) continue;
            if(onkoKyseisenPorukkaJoLiianIso()) return;
            if (sitsaaja.kaverit.contains(suosituin) && sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja, suosituin, avec);
            }
        }

        for (Sitsaaja sitsaaja : this.sitsaajatIlmanpisteita) {
            if (onkoSitsaajaJoPlassattu(sitsaaja)) continue;
            if(onkoKyseisenPorukkaJoLiianIso()) return;
            if (sitsaaja.kaverit.contains(suosituin) && sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja, suosituin, avec);

            }
        }

        for (Sitsaaja sitsaaja : this.sitsaajatPisteytettyna) {
            if (onkoSitsaajaJoPlassattu(sitsaaja)) continue;
            if(onkoKyseisenPorukkaJoLiianIso()) return;
            if (sitsaaja.kaverit.contains(suosituin)) {
                asetaKaveri(sitsaaja, suosituin, avec);
            }
        }

        for (Sitsaaja sitsaaja : this.sitsaajatIlmanpisteita) {
            if (onkoSitsaajaJoPlassattu(sitsaaja)) continue;
            if(onkoKyseisenPorukkaJoLiianIso()) return;
            if (sitsaaja.kaverit.contains(suosituin)) {
                asetaKaveri(sitsaaja, suosituin, avec);
            }
        }

        for (Sitsaaja sitsaaja : this.sitsaajatPisteytettyna) {
            if (onkoSitsaajaJoPlassattu(sitsaaja)) continue;
            if(onkoKyseisenPorukkaJoLiianIso()) return;
            if (sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja, suosituin, avec);
            }
        }

        for (Sitsaaja sitsaaja : this.sitsaajatIlmanpisteita) {
            if (onkoSitsaajaJoPlassattu(sitsaaja)) continue;
            if(onkoKyseisenPorukkaJoLiianIso()) return;
            if (sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja, suosituin, avec);
            }
        }
       if(!loytyikoKavereita(suosituin,avec)){
           for (Sitsaaja sitsaaja : this.sitsaajatIlmanpisteita) {
            if (onkoSitsaajaJoPlassattu(sitsaaja)) continue;
            if(onkoKyseisenPorukkaJoLiianIso()) return;
            asetaKaveri(sitsaaja, suosituin, avec);
            return;
        }
           
           for (Sitsaaja sitsaaja : this.sitsaajatPisteytettyna) {
            if (onkoSitsaajaJoPlassattu(sitsaaja)) continue;
            if(onkoKyseisenPorukkaJoLiianIso()) return;
            asetaKaveri(sitsaaja, suosituin, avec);
            return;    
        }
       }
    }
    
    private boolean loytyikoKavereita(Sitsaaja suosituin, Sitsaaja avec){
        for(Sitsaaja sitsaaja:this.porukkaKyseisellaIteraatiolla){
            if(sitsaaja.kaverit.contains(avec)||sitsaaja.kaverit.contains(suosituin)){
                return true;
            }
        }
        return false;
    }

    /**
     * Asettaa ryhmään sitsaajat, jotka ovat toivoneet suosituinta ja aveccia
     * kaveriksi seuraavassa järjestyksessä.
     * @param sitsaajat lista avecin ja suosituimman TAI sitsaajan TAI avecin
     * kavereista.
     * @param suosituin Suosituin sitsaaja ryhmässä
     * @param avec Suosituimman avec
     */
    protected void asetaSitsaajalleJaAvecilleKaveri(List<Sitsaaja> sitsaajat, Sitsaaja suosituin, Sitsaaja avec) {
        for (Sitsaaja sitsaaja : sitsaajat) {
            if (onkoSitsaajaJoPlassattu(sitsaaja)) continue;
            if(onkoKyseisenPorukkaJoLiianIso()) return;
            if (sitsaaja.kaverit.contains(suosituin) && sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja, suosituin, avec);
            }
        }
        for (Sitsaaja sitsaaja : sitsaajat) {
            if (onkoSitsaajaJoPlassattu(sitsaaja)) continue;
            if(onkoKyseisenPorukkaJoLiianIso()) return;
            if (sitsaaja.kaverit.contains(suosituin)) {
                asetaKaveri(sitsaaja, suosituin, avec);
            }
        }
        for (Sitsaaja sitsaaja : sitsaajat) {
            if (onkoSitsaajaJoPlassattu(sitsaaja)) continue;
            if(onkoKyseisenPorukkaJoLiianIso()) return;
            if (sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja, suosituin, avec);
            }
        }
        for (Sitsaaja sitsaaja : sitsaajat) {
            if (onkoSitsaajaJoPlassattu(sitsaaja)) continue;
            if(onkoKyseisenPorukkaJoLiianIso()) return;
            asetaKaveri(sitsaaja, suosituin, avec);
        }
    }

    /**
     * Asettaa sitsaajan kaveriporukkaan ja lähtee etsimään tälle aveccia
     * kutsumalla loytyykoKaverilleAvec() kutsua.
     *
     * @param sitsaaja Sitsaaja joka asetetaan kaveriksi
     */
    private void asetaKaveri(Sitsaaja sitsaaja, Sitsaaja suosituin, Sitsaaja avec) {
        porukkaKyseisellaIteraatiolla.add(sitsaaja);
        joLisatytSitsaajat.add(sitsaaja);
        loytyykoKaverilleAvec(sitsaaja, suosituin, avec);
    }

    /**
     * Tarkistaa onko ryhmaan liiteytylle kaverille olemassa aveccia. Jos
     * aveccia ei loydy, sopiva avec etsitaan.
     *
     * @param sitsaaja kaveri, jolle avec etsitaan.
     * @param suosituin Ryhman suosituin sitsaaja.
     * @param avec Ryhman suosituimman avec.
     */
    public void loytyykoKaverilleAvec(Sitsaaja sitsaaja, Sitsaaja suosituin, Sitsaaja avec) {
        mahdollisetAvecitKaverille=new ArrayList<>();
        if (sitsaaja.getAvec() == null) {
            kaverilleMahdollisetAvecitPisteyttamattomista(sitsaaja, false);
            kaverilleMahdollisetAvecitPisteytetyista(sitsaaja, false);
            asetaMahdollisetAvecit(sitsaaja, suosituin, avec, false);
            mahdollisetAvecitKaverille=new ArrayList<>();
        } else {
            porukkaKyseisellaIteraatiolla.add(sitsaaja.getAvec());
            joLisatytSitsaajat.add(sitsaaja.getAvec());
        }
    }

    /**
     * Asettaa kaverukselle avecin ahdollisten aveccien listaan.
     *
     * @param kaveri Sitsaaja jolle avec haettiin.
     * @param avec Sitsaajalle sopiva avec.
     */
    private void asetaKaverijaAvec(Sitsaaja kaveri, Sitsaaja avec) {
        asetaAveceiksi(avec, kaveri);
        porukkaKyseisellaIteraatiolla.add(avec);
        joLisatytSitsaajat.add(avec);
    }

    /**
     * Hakee mahdolliset avecit kaverille pisteyttamattomien joukosta. Sopivin
     * avec on joko toivonut ryhman suosituinta aveciksi tai tämän aveccia.
     * Kaveri ja avec asetetaan aveceiksi, kun ryhmaan sopivin on loydetty.
     *
     * @param kaveri Sitsaaja jolle haetaan aveccia.
     * @param suosituin Ryhman suosituin.
     * @param avec Ryhman suosituimman avec.
     * @param vikaKierros false kun haetaan aveciksi vastakkaisen sukupuolen
     * edustajaa.
     */
    private void asetaMahdollisetAvecit(Sitsaaja kaveri, Sitsaaja suosituin, Sitsaaja avec, boolean vikaKierros) {
        for (Sitsaaja kAvec : this.mahdollisetAvecitKaverille) {
            if(onkoSitsaajaJoPlassattu(kAvec)) continue;
            if (vikaKierros == true) {
                if (kAvec.kaverit.contains(suosituin) && kAvec.kaverit.contains(kAvec)) {
                    asetaKaverijaAvec(kaveri, kAvec);
                    return;
                }
            }

            if (kAvec.kaverit.contains(suosituin) && kAvec.kaverit.contains(kAvec) && !ovatkoSitsaajatSamaaSukupuolta(kAvec, kaveri)) {
                asetaKaverijaAvec(kaveri, kAvec);
                return;
            }
        }

        for (Sitsaaja kAvec : this.mahdollisetAvecitKaverille) {
            if(onkoSitsaajaJoPlassattu(kAvec)) continue;
            if (vikaKierros == true) {
                if (kAvec.kaverit.contains(suosituin)) {
                    asetaKaverijaAvec(kaveri, kAvec);
                    return;
                }
            }

            if (kAvec.kaverit.contains(suosituin) && !ovatkoSitsaajatSamaaSukupuolta(kAvec, kaveri)) {
                asetaKaverijaAvec(kaveri, kAvec);
                return;
            }
        }
        for (Sitsaaja kAvec : this.mahdollisetAvecitKaverille) {
            if(onkoSitsaajaJoPlassattu(kAvec)) continue;
            if (vikaKierros == true) {
                if (kAvec.kaverit.contains(kAvec)) {
                    asetaKaverijaAvec(kaveri, kAvec);
                    return;
                }
            }

            if (kAvec.kaverit.contains(kAvec) && !ovatkoSitsaajatSamaaSukupuolta(kAvec, kaveri)) {
                asetaKaverijaAvec(kaveri, kAvec);
                return;

            }
        }

        for (Sitsaaja kAvec : this.mahdollisetAvecitKaverille) {
            if (vikaKierros == true && !onkoSitsaajaJoPlassattu(kAvec)) {
                asetaKaverijaAvec(kaveri, kAvec);
                return;
            }
            if (onkoSitsaajaJoPlassattu(kAvec) || ovatkoSitsaajatSamaaSukupuolta(kaveri, kAvec)) continue;
            asetaKaverijaAvec(kaveri, kAvec);
            return;
        }

        if (vikaKierros == false) {
            asetaMahdollisetAvecit(kaveri, suosituin, avec, true);
        }
    }

    private void kaverilleMahdollisetAvecitPisteytetyista(Sitsaaja sitsaaja, boolean onkoSukupuoliVaihdettu) {
        List<Sitsaaja> tmp = sitsaajatPisteytettyna;
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i) == null || onkoSitsaajaJoPlassattu(tmp.get(i)) || ovatkoSitsaajatSamaaSukupuolta(sitsaaja, tmp.get(i)) || tmp.get(i).getAvec() != null) {
                if (i == tmp.size() - 1 && onkoSukupuoliVaihdettu == false) {
                    sitsaaja.vaihdaSukupuolta();
                    kaverilleMahdollisetAvecitPisteytetyista(sitsaaja, true);
                    return;
                }
                continue;
            }

            Sitsaaja mahdollinenAvec = tmp.get(i);
            mahdollisetAvecitKaverille.add(mahdollinenAvec);
        }
        if (onkoSukupuoliVaihdettu == true) {
            sitsaaja.vaihdaSukupuolta();
        }
    }

    private void kaverilleMahdollisetAvecitPisteyttamattomista(Sitsaaja sitsaaja, boolean onkoSukupuoliVaihdettu) {
        List<Sitsaaja> tmp = sitsaajatIlmanpisteita;

        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i) == null || onkoSitsaajaJoPlassattu(tmp.get(i)) || ovatkoSitsaajatSamaaSukupuolta(sitsaaja, tmp.get(i)) || tmp.get(i).getAvec() != null) {
                if (i == tmp.size() - 1 && onkoSukupuoliVaihdettu == false) {
                    sitsaaja.vaihdaSukupuolta();
                    kaverilleMahdollisetAvecitPisteyttamattomista(sitsaaja, true);
                    return;
                }
                continue;
            }

            Sitsaaja mahdollinenAvec = tmp.get(i);
            mahdollisetAvecitKaverille.add(mahdollinenAvec);
        }
        if (onkoSukupuoliVaihdettu == true) {
            sitsaaja.vaihdaSukupuolta();
        }
    }

    public List<Sitsaaja> getJoLisatytSitsaajat() {
        return this.joLisatytSitsaajat;
    }
    
    public List<List<Sitsaaja>> getKaveriporukat(){
        return this.kaveriporukat;
    }

    public List<Sitsaaja> getSitsaajatIlmanKaveriporukkaa() {
        List<Sitsaaja> tmp = new ArrayList<>();
        if(sitsaajatIlmanpisteita.isEmpty()){
           return tmp;
        }
        for (Sitsaaja a : this.sitsaajatIlmanpisteita) {
            if (onkoSitsaajaJoPlassattu(a)) {
                continue;
            }
            tmp.add(a);
        }
        return tmp;
    }

    protected List<Integer> getKaveririporukoidenPaikatListassaTestejaVarten() {
        return this.kaveriporukoidenPaikatRyhmitetyssaListassa;
    }

    private void SetListat() {
        this.sitsaajatPisteytettyna = pisteyttaja.getPisteytettyLista();
        this.sitsaajatIlmanpisteita = pisteyttaja.getSitsaajatJoillaEiOlePisteita();
        poydanKoko=sitsaajatIlmanpisteita.size()+sitsaajatPisteytettyna.size();
    }

    private List<Sitsaaja> leikkaus(Sitsaaja sitsaaja1, Sitsaaja sitsaaja2) {
        List<Sitsaaja> list = new ArrayList<>();
        int j = 0;
        for (Sitsaaja t : sitsaaja1.kaverit) {
            if (sitsaaja2.kaverit.contains(t)) {
                list.add(t);
            }
        }
        Collections.sort(list);
        return list;
    }
    
    public int getPoydanKoko(){
        return this.poydanKoko;
    }

    private void merkkaaKaveriporukanPaikkaRyhmitettyynListaan(Sitsaaja avec) {
        int paikka = this.joLisatytSitsaajat.indexOf(avec);
        this.kaveriporukoidenPaikatRyhmitetyssaListassa.add(paikka);
    }
    
    private void laitaMerkkiTestaustaVarten(){
        Sitsaaja viimeinenRyhmassa = this.joLisatytSitsaajat.get(joLisatytSitsaajat.size() - 1);
        merkkaaKaveriporukanPaikkaRyhmitettyynListaan(viimeinenRyhmassa);
    }
}
