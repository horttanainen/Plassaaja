/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.*;
import sovelluslogiikka.sitsaajatJaPoyta.Sitsaaja;

/**
 *SitsaajienRyhmittaja ryhmittaa sitsaajat suosion perusteella kaveriporukoihin.
 * Eniten toiveita kerännyt ja hänen aveccinsa kaveritoiveet toteutetaan
 * ensimmäiseksi ja kaveritoiveille haetaan avecit. Ryhmittaja jatkaa tätä
 * kunnes kaikki toiveta saaneet on koottu kaveriporukoihin.
 * @author Santeri
 */
public class SitsaajienRyhmittaja {

    private List<Sitsaaja> sitsaajatPisteytettyna;
    private List<Sitsaaja> ryhmitettyLista;
    private SitsaajienPisteyttaja pisteyttaja;

    public SitsaajienRyhmittaja(SitsaajienPisteyttaja pisteyttaja) {
        this.pisteyttaja = pisteyttaja;
    }

    public void ryhmitaSitsaajat() {
        SetPisteytettyLista();
        while(!sitsaajatPisteytettyna.isEmpty()){
            ensimmaiseksiSuosituinSitsaaja();
        }
    }

    public void ensimmaiseksiSuosituinSitsaaja() {
        Sitsaaja suosituin;
        for (Sitsaaja a : sitsaajatPisteytettyna) {
            if (a == null) {
                continue;
            }
            suosituin = a;
            ryhmitettyLista.add(suosituin);
            sitsaajatPisteytettyna.remove(suosituin);
            toiseksiSuosituimmanAvecjosLoytyy(suosituin);
            break;
        }

    }

    public void toiseksiSuosituimmanAvecjosLoytyy(Sitsaaja suosituin) {
        if (suosituin.getAvec() != null) {
            ryhmitettyLista.add(suosituin.getAvec());
            sitsaajatPisteytettyna.remove(suosituin.getAvec());
            suosituimmanJaAvecinKaveritoiveet(suosituin, suosituin.getAvec());
        } else {
            josAvecEiLoydy(suosituin);
        }
    }
//avecin ryosto ongelma joka pitaa korjata jos tyttöä ei löydy niin haetaan joku tyttö ilman pisteitä
    public void josAvecEiLoydy(Sitsaaja sitsaaja) {
        for (int i = 0; i < sitsaajatPisteytettyna.size(); i++) {
            if (sitsaajatPisteytettyna.get(i) == null) {
                continue;
            }
            Sitsaaja mahdollinenAvec = sitsaajatPisteytettyna.get(i);
            if (mahdollinenAvec.getSukupuoli() == sitsaaja.getSukupuoli()) {
                continue;
            }
            sitsaaja.setAvec(mahdollinenAvec);
            ryhmitettyLista.add(mahdollinenAvec);
            sitsaajatPisteytettyna.remove(mahdollinenAvec);
            suosituimmanJaAvecinKaveritoiveet(sitsaaja, mahdollinenAvec);
            break;
        }
    }

    //Lahdetaan hakemaan kolmatta sitsaajaa (tasta tulee pitka projekti...)

    public void suosituimmanJaAvecinKaveritoiveet(Sitsaaja sitsaaja, Sitsaaja avec) {
        List<Sitsaaja> yhteisetkaverit = leikkaus(sitsaaja, avec);
        //jos sitsaajalla ja avecilla on yhteisiä toiveita
        if (!yhteisetkaverit.isEmpty()) {
            asetaSitsaajalleJaAvecilleKaveri(yhteisetkaverit, sitsaaja, avec);
        } //jos sitsaajalla on toiveita:
        else if (!sitsaaja.kaverit.isEmpty()) {
            asetaSitsaajalleJaAvecilleKaveri(sitsaaja.kaverit, sitsaaja, avec);
        } //jos sitsaajalla ei ollut toiveita:
        else if (!avec.kaverit.isEmpty()) {
            asetaSitsaajalleJaAvecilleKaveri(avec.kaverit, sitsaaja, avec);
        } //jos kaveritoiveita ei loydy:
        else {
            asetaSitsaajalleJaAvecilleKaveri(sitsaajatPisteytettyna, sitsaaja, avec);
        }
    }
//pitäisi kutsua kunnes suosituimman ja avecin pyynnöt käyty ja kaikki ihmiset jotka ovat pyytäneet näitä kahta kaveriksi. Täällä pitäisi myös tapahtua katkaisu
    public void asetaSitsaajalleJaAvecilleKaveri(List<Sitsaaja> sitsaajat, Sitsaaja suosituin, Sitsaaja avec) {
        Collections.sort(sitsaajat);
        for (Sitsaaja sitsaaja : sitsaajat) {
            if (sitsaaja.kaverit.contains(suosituin) && sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja);
                break;
            } else if (sitsaaja.kaverit.contains(suosituin)) {
                asetaKaveri(sitsaaja);;
                break;
            } else if (sitsaaja.kaverit.contains(avec)) {
                asetaKaveri(sitsaaja);
                break;
            } else {
                asetaKaveri(sitsaaja);
                break;
            }
        }
    }

    private void asetaKaveri(Sitsaaja sitsaaja) {
        ryhmitettyLista.add(sitsaaja);
        sitsaajatPisteytettyna.remove(sitsaaja);
        loytyykoKaverilleAvec(sitsaaja);
    }
//ryöstöongelma täälläkin
    public void loytyykoKaverilleAvec(Sitsaaja sitsaaja) {
        if(sitsaaja.getAvec()==null) {
        for (int i = 0; i < sitsaajatPisteytettyna.size(); i++) {
            if (sitsaajatPisteytettyna.get(i) == null) {
                continue;
            }
            Sitsaaja mahdollinenAvec = sitsaajatPisteytettyna.get(i);
            if (mahdollinenAvec.getSukupuoli() == sitsaaja.getSukupuoli()) {
                continue;
            }
            sitsaaja.setAvec(mahdollinenAvec);
            ryhmitettyLista.add(mahdollinenAvec);
            sitsaajatPisteytettyna.remove(mahdollinenAvec);
            break;
        }
        } else {
            ryhmitettyLista.add(sitsaaja.getAvec());
            sitsaajatPisteytettyna.remove(sitsaaja.getAvec());
        }
         }

    public List<Sitsaaja> getRyhmitettyLista() {
        return this.sitsaajatPisteytettyna;
    }

    private void SetPisteytettyLista() {
        this.sitsaajatPisteytettyna = pisteyttaja.getPisteytettyLista();
    }

    private List<Sitsaaja> leikkaus(Sitsaaja sitsaaja1, Sitsaaja sitsaaja2) {
        List<Sitsaaja> list = new ArrayList<Sitsaaja>();
        int j = 0;
        for (Sitsaaja t : sitsaaja1.kaverit) {
            if (sitsaaja2.kaverit.contains(t)) {
                list.add(t);
            }
        }
        return list;
    }
}
