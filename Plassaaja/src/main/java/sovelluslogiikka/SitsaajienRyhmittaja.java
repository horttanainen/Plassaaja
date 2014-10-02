/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.*;
import sovelluslogiikka.sitsaajatJaPoyta.Sitsaaja;

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

    public SitsaajienRyhmittaja(SitsaajienPisteyttaja pisteyttaja) {
        kaveriporukoidenPaikatRyhmitetyssaListassa = new ArrayList<>();
        this.pisteyttaja = pisteyttaja;
        ryhmitettyLista = new ArrayList<>();
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
 * @param suosituin Sitsaaja jota on toivottu eniten.
 */
    protected void ensimmaiseksiSuosituinSitsaaja(Sitsaaja suosituin) {
        ryhmitettyLista.add(suosituin);
        toiseksiSuosituimmanAvecjosLoytyy(suosituin);
    }
/**
 * Asettaa toiseksi Suosituimman avecin jos tälläinen löytyy.
 * @param suosituin Sitsaaja jota on toivottu eniten.
 */
    protected void toiseksiSuosituimmanAvecjosLoytyy(Sitsaaja suosituin) {
        if (suosituin.getAvec() != null && !ryhmitettyLista.contains(suosituin.getAvec())) {
            ryhmitettyLista.add(suosituin.getAvec());
            suosituimmanJaAvecinKaveritoiveet(suosituin, suosituin.getAvec());
        } else {
            josAvecEiLoydy(suosituin, false, true);
        }
    }
/**
 * Jos ryhmän suosituimmalla sitsaajalla ei ole aveccia hänelle haetaan sellainen.
 * @param sitsaaja Sitsaaja jota on toivottu eniten.
 * @param onkoVikaKierros True jos etsitään suosituimman sitsaajan kaverin aveccia.
 * @param loytyykoPisteytetyista True jos aveccia ei ole haettu pisteytettyjen sitsaajien joukosta.
 */
    protected void josAvecEiLoydy(Sitsaaja sitsaaja, boolean onkoVikaKierros, boolean loytyykoPisteytetyista) {
        List<Sitsaaja> tmp = sitsaajatPisteytettyna;
        if (loytyykoPisteytetyista == false) {
            tmp = sitsaajatIlmanpisteita;
        }
        for (int i = 0; i < tmp.size(); i++) {
            if (tmp.get(i) == null || ryhmitettyLista.contains(tmp.get(i)) || tmp.get(i).getSukupuoli() == sitsaaja.getSukupuoli() || tmp.get(i).getAvec() != null) {
                if (i == tmp.size() - 1 && loytyykoPisteytetyista == true) {
                    josAvecEiLoydy(sitsaaja, onkoVikaKierros, false);
                    break;
                } else if (i == tmp.size() - 1 && loytyykoPisteytetyista == false) {
                    sitsaaja.vaihdaSukupuolta();
                    josAvecEiLoydy(sitsaaja, onkoVikaKierros, true);
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
    }
/**
 * Käy läpi kaikki ryhmän suosituimman ja hänen aveccinsa kaveritoiveet.
 * Aluksi etsitään yhteisiä kaverieta ja sitten siirrytään sitsaajan ja avecin 
 * yksilöllisiin kaveritoiveisiin.
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
 * Jos avecilla ja sitsaajalla ei ole toiveita haetaan heille kuitenkin heitä toivoneet
 * sitsaajat listasta.
 * @param suosituin Ryhmän suosituin sitsaaja.
 * @param avec Suosituimman avec.
 */
    protected void asetaKaveriListastaJosSitsaajallaJaAvecillaEiToiveita(Sitsaaja suosituin, Sitsaaja avec) {
        for (Sitsaaja sitsaaja : this.sitsaajatPisteytettyna) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }
            if (sitsaaja.kaverit.contains(suosituin) && sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja);

            }
        }

        for (Sitsaaja sitsaaja : this.sitsaajatIlmanpisteita) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }
            if (sitsaaja.kaverit.contains(suosituin) && sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja);

            }
        }

        for (Sitsaaja sitsaaja : this.sitsaajatPisteytettyna) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }

            if (sitsaaja.kaverit.contains(suosituin)) {
                asetaKaveri(sitsaaja);
            }
        }

        for (Sitsaaja sitsaaja : this.sitsaajatIlmanpisteita) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }

            if (sitsaaja.kaverit.contains(suosituin)) {
                asetaKaveri(sitsaaja);
            }
        }

        for (Sitsaaja sitsaaja : this.sitsaajatPisteytettyna) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }

            if (sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja);
            }
        }

        for (Sitsaaja sitsaaja : this.sitsaajatIlmanpisteita) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }

            if (sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja);
            }
        }

    }
/**
 * Asettaa ryhmään sitsaajat, jotka ovat toivoneet suosituinta ja aveccia kaveriksi
 * seuraavassa järjestyksessä.
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
                asetaKaveri(sitsaaja);

            }
        }
        for (Sitsaaja sitsaaja : sitsaajat) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }

            if (sitsaaja.kaverit.contains(suosituin)) {
                asetaKaveri(sitsaaja);

            }
        }
        for (Sitsaaja sitsaaja : sitsaajat) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }

            if (sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja);

            }
        }
        
        for (Sitsaaja sitsaaja : sitsaajat) {
            if (ryhmitettyLista.contains(sitsaaja)) {
                continue;
            }

            if (!sitsaaja.kaverit.contains(suosituin)||!sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja);
            }
        }
        
    }
/**
 * Asettaa sitsaajan kaveriporukkaan ja lähtee etsimään tälle aveccia kutsumalla
 * loytyykoKaverilleAvec() kutsua.
 * @param sitsaaja Sitsaaja joka asetetaan kaveriksi
 */
    private void asetaKaveri(Sitsaaja sitsaaja) {
        ryhmitettyLista.add(sitsaaja);
        loytyykoKaverilleAvec(sitsaaja);
    }

    public void loytyykoKaverilleAvec(Sitsaaja sitsaaja) {
        if (sitsaaja.getAvec() == null) {
            josAvecEiLoydy(sitsaaja, true, true);
        } else {
            ryhmitettyLista.add(sitsaaja.getAvec());
        }
    }

    public List<Sitsaaja> getRyhmitettyLista() {
        return this.ryhmitettyLista;
    }

    public List<Sitsaaja> getSitsaajatIlmanKaveriporukkaa() {
        List<Sitsaaja> tmp = new ArrayList<>();
        for (Sitsaaja a : this.sitsaajatIlmanpisteita) {
            if (this.ryhmitettyLista.contains(a)) {
                continue;
            }
            tmp.add(a);
        }
        return tmp;
    }
    
    public List<Integer> getKaveririporukoidenPaikatListassa(){
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
