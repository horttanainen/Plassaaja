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
    private List<Sitsaaja> ryhmitettyLista;
    private List<Integer> kaveriporukoidenPaikatRyhmitetyssaListassa;
    private SitsaajienPisteyttaja pisteyttaja;
    private List<Sitsaaja> mahdollisetAvecit;

    public SitsaajienRyhmittaja(SitsaajienPisteyttaja pisteyttaja) {
        kaveriporukoidenPaikatRyhmitetyssaListassa = new ArrayList<>();
        this.pisteyttaja = pisteyttaja;
        ryhmitettyLista = new ArrayList<>();
        mahdollisetAvecit = new ArrayList<>();
    }

    /**
     * Ryhmittaa sitsaajat suosion ja kaveritoiveiden perusteella.
     */
    public void ryhmitaSitsaajat() {
        SetListat();
        for (Sitsaaja sitsaaja : sitsaajatPisteytettyna) {
            if (this.ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }
            ensimmaiseksiSuosituinSitsaaja(sitsaaja);

        }
    }

    /**
     * Asettaa ensimmaiseksi suosituimman sitsaajan jokaiseen ryhmaan.
     *
     * @param suosituin Sitsaaja jota on toivottu eniten.
     */
    protected void ensimmaiseksiSuosituinSitsaaja(Sitsaaja suosituin) {
        ryhmitettyLista.add(suosituin);
        toiseksiSuosituimmanAvecjosLoytyy(suosituin);
    }

    /**
     * Asettaa toiseksi Suosituimman avecin jos tälläinen löytyy.
     *
     * @param suosituin Sitsaaja jota on toivottu eniten.
     */
    protected void toiseksiSuosituimmanAvecjosLoytyy(Sitsaaja suosituin) {
        if (suosituin.getAvec() != null && !ryhmitettyLista.contains(suosituin.getAvec())) {
            ryhmitettyLista.add(suosituin.getAvec());
            suosituimmanJaAvecinKaveritoiveet(suosituin, suosituin.getAvec());
        } else {
            josAvecEiLoydy(suosituin, false, true, false);
        }
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
    protected void josAvecEiLoydy(Sitsaaja sitsaaja, boolean onkoVikaKierros, boolean loytyykoPisteytetyista, boolean sukupuolenVaihdos) {
        List<Sitsaaja> tmp = sitsaajatPisteytettyna;
        if (loytyykoPisteytetyista == false) {
            tmp = sitsaajatIlmanpisteita;
        }
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i) == null || ryhmitettyLista.contains(tmp.get(i)) || tmp.get(i).getSukupuoli() == sitsaaja.getSukupuoli() || tmp.get(i).getAvec() != null) {
                if (i == tmp.size() - 1 && loytyykoPisteytetyista == true) {
                    josAvecEiLoydy(sitsaaja, onkoVikaKierros, false, sukupuolenVaihdos);
                    break;
                } else if (i == tmp.size() - 1 && loytyykoPisteytetyista == false && sukupuolenVaihdos == false) {
                    sitsaaja.vaihdaSukupuolta();
                    josAvecEiLoydy(sitsaaja, onkoVikaKierros, true, true);
                    break;
                }
                continue;
            }
            Sitsaaja mahdollinenAvec = tmp.get(i);
            sitsaaja.setAvec(mahdollinenAvec);
            mahdollinenAvec.setAvec(sitsaaja);
            ryhmitettyLista.add(mahdollinenAvec);
            if (onkoVikaKierros == false) {
                suosituimmanJaAvecinKaveritoiveet(sitsaaja, mahdollinenAvec);
            }
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
        Sitsaaja viimeinenRyhmassa = this.ryhmitettyLista.get(ryhmitettyLista.size() - 1);
        merkkaaKaveriporukanPaikkaRyhmitettyynListaan(viimeinenRyhmassa);
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
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }
            if (sitsaaja.kaverit.contains(suosituin) && sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja, suosituin, avec);

            }
        }

        for (Sitsaaja sitsaaja : this.sitsaajatIlmanpisteita) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }
            if (sitsaaja.kaverit.contains(suosituin) && sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja, suosituin, avec);

            }
        }

        for (Sitsaaja sitsaaja : this.sitsaajatPisteytettyna) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }

            if (sitsaaja.kaverit.contains(suosituin)) {
                asetaKaveri(sitsaaja, suosituin, avec);
            }
        }

        for (Sitsaaja sitsaaja : this.sitsaajatIlmanpisteita) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }

            if (sitsaaja.kaverit.contains(suosituin)) {
                asetaKaveri(sitsaaja, suosituin, avec);
            }
        }

        for (Sitsaaja sitsaaja : this.sitsaajatPisteytettyna) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }

            if (sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja, suosituin, avec);
            }
        }

        for (Sitsaaja sitsaaja : this.sitsaajatIlmanpisteita) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }

            if (sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja, suosituin, avec);
            }
        }
        

       if(!loytyikoKavereita(suosituin,avec)){
           for (Sitsaaja sitsaaja : this.sitsaajatIlmanpisteita) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }
            asetaKaveri(sitsaaja, suosituin, avec);
            return;
               
        }
           
           for (Sitsaaja sitsaaja : this.sitsaajatPisteytettyna) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }
            asetaKaveri(sitsaaja, suosituin, avec);
            return;
               
        }
       }
        

    }
    
    private boolean loytyikoKavereita(Sitsaaja suosituin, Sitsaaja avec){
        for(Sitsaaja sitsaaja:this.ryhmitettyLista){
            if(sitsaaja.kaverit.contains(avec)||sitsaaja.kaverit.contains(suosituin)){
                return true;
            }
        }
        
        return false;
    }

    /**
     * Asettaa ryhmään sitsaajat, jotka ovat toivoneet suosituinta ja aveccia
     * kaveriksi seuraavassa järjestyksessä.
     *
     * @param sitsaajat lista avecin ja suosituimman TAI sitsaajan TAI avecin
     * kavereista.
     * @param suosituin Suosituin sitsaaja ryhmässä
     * @param avec Suosituimman avec
     */
    protected void asetaSitsaajalleJaAvecilleKaveri(List<Sitsaaja> sitsaajat, Sitsaaja suosituin, Sitsaaja avec) {
        for (Sitsaaja sitsaaja : sitsaajat) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }
            if (sitsaaja.kaverit.contains(suosituin) && sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja, suosituin, avec);

            }
        }
        for (Sitsaaja sitsaaja : sitsaajat) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }

            if (sitsaaja.kaverit.contains(suosituin)) {
                asetaKaveri(sitsaaja, suosituin, avec);

            }
        }
        for (Sitsaaja sitsaaja : sitsaajat) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }

            if (sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja, suosituin, avec);

            }
        }

        for (Sitsaaja sitsaaja : sitsaajat) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }
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
        ryhmitettyLista.add(sitsaaja);
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
        if (sitsaaja.getAvec() == null) {
            kaverilleMahdollisetAvecitPisteyttamattomista(sitsaaja, false);
            kaverilleMahdollisetAvecitPisteytetyista(sitsaaja, false);
            asetaMahdollisetAvecit(sitsaaja, suosituin, avec, false);
            this.mahdollisetAvecit.clear();
        } else {
            ryhmitettyLista.add(sitsaaja.getAvec());
        }
    }

    /**
     * Asettaa kaverukselle avecin ahdollisten aveccien listaan.
     *
     * @param kaveri Sitsaaja jolle avec haettiin.
     * @param sitsaaja Sitsaajalle sopiva avec.
     */
    private void asetaKaverijaAvec(Sitsaaja kaveri, Sitsaaja sitsaaja) {
        kaveri.setAvec(sitsaaja);
        sitsaaja.setAvec(kaveri);
        ryhmitettyLista.add(kaveri.getAvec());
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
        for (Sitsaaja sitsaaja : this.mahdollisetAvecit) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }
            if (vikaKierros == true) {
                if (sitsaaja.kaverit.contains(suosituin) && sitsaaja.kaverit.contains(avec)) {
                    asetaKaverijaAvec(kaveri, sitsaaja);
                    return;
                }
            }

            if (sitsaaja.kaverit.contains(suosituin) && sitsaaja.kaverit.contains(avec) && sitsaaja.getSukupuoli() != kaveri.getSukupuoli()) {
                asetaKaverijaAvec(kaveri, sitsaaja);
                return;
            }
        }

        for (Sitsaaja sitsaaja : this.mahdollisetAvecit) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }
            if (vikaKierros == true) {
                if (sitsaaja.kaverit.contains(suosituin)) {
                    asetaKaverijaAvec(kaveri, sitsaaja);
                    return;

                }
            }

            if (sitsaaja.kaverit.contains(suosituin) && sitsaaja.getSukupuoli() != kaveri.getSukupuoli()) {
                asetaKaverijaAvec(kaveri, sitsaaja);
                return;

            }
        }
        for (Sitsaaja sitsaaja : this.mahdollisetAvecit) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }
            if (vikaKierros == true) {
                if (sitsaaja.kaverit.contains(avec)) {
                    asetaKaverijaAvec(kaveri, sitsaaja);
                    return;

                }
            }

            if (sitsaaja.kaverit.contains(avec) && sitsaaja.getSukupuoli() != kaveri.getSukupuoli()) {
                asetaKaverijaAvec(kaveri, sitsaaja);
                return;

            }
        }

        for (Sitsaaja sitsaaja : this.mahdollisetAvecit) {
            if (vikaKierros == true && !ryhmitettyLista.contains(sitsaaja)) {
                asetaKaverijaAvec(kaveri, sitsaaja);
                return;
            }
            if (ryhmitettyLista.contains(sitsaaja) || sitsaaja.getSukupuoli() == kaveri.getSukupuoli()) {
                continue;
            }

            asetaKaverijaAvec(kaveri, sitsaaja);
            return;
        }

        if (vikaKierros == false) {
            asetaMahdollisetAvecit(kaveri, suosituin, avec, true);
        }
    }

    private void kaverilleMahdollisetAvecitPisteytetyista(Sitsaaja sitsaaja, boolean onkoSukupuoliVaihdettu) {
        List<Sitsaaja> tmp = sitsaajatPisteytettyna;
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i) == null || ryhmitettyLista.contains(tmp.get(i)) || tmp.get(i).getSukupuoli() == sitsaaja.getSukupuoli() || tmp.get(i).getAvec() != null) {
                if (i == tmp.size() - 1 && onkoSukupuoliVaihdettu == false) {
                    sitsaaja.vaihdaSukupuolta();
                    kaverilleMahdollisetAvecitPisteytetyista(sitsaaja, true);
                    return;
                }
                continue;
            }

            Sitsaaja mahdollinenAvec = tmp.get(i);
            mahdollisetAvecit.add(mahdollinenAvec);
        }
        if (onkoSukupuoliVaihdettu == true) {
            sitsaaja.vaihdaSukupuolta();
        }
    }

    private void kaverilleMahdollisetAvecitPisteyttamattomista(Sitsaaja sitsaaja, boolean onkoSukupuoliVaihdettu) {
        List<Sitsaaja> tmp = sitsaajatIlmanpisteita;

        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i) == null || ryhmitettyLista.contains(tmp.get(i)) || tmp.get(i).getSukupuoli() == sitsaaja.getSukupuoli() || tmp.get(i).getAvec() != null) {
                if (i == tmp.size() - 1 && onkoSukupuoliVaihdettu == false) {
                    sitsaaja.vaihdaSukupuolta();
                    kaverilleMahdollisetAvecitPisteyttamattomista(sitsaaja, true);
                    return;
                }
                continue;
            }

            Sitsaaja mahdollinenAvec = tmp.get(i);
            mahdollisetAvecit.add(mahdollinenAvec);
        }
        if (onkoSukupuoliVaihdettu == true) {
            sitsaaja.vaihdaSukupuolta();
        }
    }

    public List<Sitsaaja> getRyhmitettyLista() {
        return this.ryhmitettyLista;
    }

    public List<Sitsaaja> getSitsaajatIlmanKaveriporukkaa() {
        List<Sitsaaja> tmp = new ArrayList<>();
        if(sitsaajatIlmanpisteita.isEmpty()){
           return tmp;
        }
        for (Sitsaaja a : this.sitsaajatIlmanpisteita) {
            if (this.ryhmitettyLista.contains(a)) {
                continue;
            }
            tmp.add(a);
        }
        return tmp;
    }

    public List<Integer> getKaveririporukoidenPaikatListassa() {
        return this.kaveriporukoidenPaikatRyhmitetyssaListassa;
    }

    private void SetListat() {
        this.sitsaajatPisteytettyna = pisteyttaja.getPisteytettyLista();
        this.sitsaajatIlmanpisteita = pisteyttaja.getSitsaajatJoillaEiOlePisteita();
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

    public void merkkaaKaveriporukanPaikkaRyhmitettyynListaan(Sitsaaja avec) {
        int paikka = this.ryhmitettyLista.indexOf(avec);
        this.kaveriporukoidenPaikatRyhmitetyssaListassa.add(paikka);
    }
}
