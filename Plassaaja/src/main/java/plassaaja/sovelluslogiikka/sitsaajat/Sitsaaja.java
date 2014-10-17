/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plassaaja.sovelluslogiikka.sitsaajat;

import java.util.*;
import java.util.Objects;

/**
 * Sitsaaja on luokka johon asetetetaan lisättävän sitsaajan kaikki plassausta
 * varten tarvittavat tiedot.
 *
 * @author Santeri
 */
public class Sitsaaja implements Comparable<Sitsaaja> {
/**
 * Avecci toivomus jonka sitsaaja on esittänyt.
 */
    private String avecToive;
    /**
     * Sitsaajan nimi.
     */
    private String nimi;
    /**
     * Aveccien parituksen jälkeen asetettu lopullinen avec.
     */
    private Sitsaaja avec;
    /**
     * Sitsaajan esittämät kaveritoivomukset.
     */
    public List<String> kaveriToiveet;
    /**
     * Kaverien parituksen jälkeen asetetut sitseiltä löytyneet kaveritoiveet.
     */
    public List<Sitsaaja> kaverit;
    /**
     * SitsaajienPisteyttäjän asettama suosio sitsaajan saamien kaveritoiveiden
     * perusteella.
     */
    private int suosio;
    /**
     * Sitsaajan sukupuoli. Sitsaaja voi olla, joko mies tai nainen.
     */
    private Sukupuoli sukupuoli;

    /**
     * Luo sitsaajan.
     *
     * @param nimi Sitsaajan nimi
     * @param avecToive Sitsaajan avec toive (ei välttämättä toteudu, jos ei
     * molempien hyväksyntää)
     */
    public Sitsaaja(String nimi, String avecToive) {
        if (nimi == null) {
            throw new NullPointerException("Nimi ei saa olla Null");
        }
        if (nimi.equals(avecToive)) {
            avecToive = null;
        }
        this.nimi = nimi;
        this.avecToive = avecToive;
        this.kaverit = new ArrayList<>();
        this.suosio = 0;
        this.kaveriToiveet = new ArrayList<>();
    }
/**
 * Vaihtaa sitsaajan sukupuolen vastakkaiseen.
 */
    public void vaihdaSukupuolta() {
        if (this.sukupuoli != null) {
            if (this.sukupuoli == Sukupuoli.Mies) {
                this.sukupuoli = Sukupuoli.Nainen;
            } else {
                this.sukupuoli = Sukupuoli.Mies;
            }
        }
    }

    /**
     * Palauttaa sitsaajan nimen,
     * @return Sitsaajan nimi.
     */
    public String getNimi() {
        return nimi;
    }
    /**
     * Palauttaa sitsaajan avectoiveen.
     * @return Sitsaajan avectoive.
     */
    public String getAvecToive() {
        return avecToive;
    }
    /**
     * Palauttaa sitsaajan kaveritoiveet.
     * @return Sitsaajan kaveritoiveet,
     */
    public String[] getKaveriToive() {
        String[] tmp = new String[this.kaveriToiveet.size()];
        tmp = this.kaveriToiveet.toArray(tmp);
        return tmp;
    }
    /**
     * Palauttaa sitsaajalle asetetun avecin.
     * @return Sitsaajalle asetettu avec. 
     */
    public Sitsaaja getAvec() {
        return avec;
    }
    /**
     * Palauttaa sitsaajalle asetetut avecit.
     * @return Sitsaajalle asetetut avecit.
     */
    public Sitsaaja[] getKaverit() {
        Sitsaaja[] tmp = new Sitsaaja[this.kaverit.size()];
        tmp = this.kaverit.toArray(tmp);
        return tmp;
    }
    /**
     * Palauttaa sitsaajan saaman suosion.
     * @return Sitsaajan suosio.
     */
    public int getSuosio() {
        return this.suosio;
    }
/**
 * Palauttaa sitsaajan suosion.
 * @return Sitsaajan suosio.
 */
    public Sukupuoli getSukupuoli() {
        return this.sukupuoli;
    }

   /**
    * Asettaa sitsaajalle avecin.
    * @param avec Sitsaajalle asetettava avec.
    */
    public void setAvec(Sitsaaja avec) {
        this.avec = avec;
    }
    /**
     * Vaihtaa sitsaajan nimen.
     * @param uusiNimi uusi nimi sitsaajalle.
     */
    public void vaihdaNimi(String uusiNimi){
        this.nimi=uusiNimi;
    }
/**
 * Poistaa sitsaajan nykyisen avectoiveen.
 */
    public void poistaAvectoive() {
        if (this.avecToive != null) {
            this.avecToive = null;
        }
    }
/**
 * Vaihtaa avec toiveen syötteen mukaiseksi.
 * @param nimi Uuden avectoiveen nimi.
 */
    public void vaihdaAvectoivetta(String nimi) {
        this.avecToive=nimi;

    }
    /**
     * Poistaa kaveritoiveista syötetyt kaverit.
     * @param nimet Poistettavat kaveritoiveet.
     */
    public void poistaKaveritoiveita(String... nimet){
        for (String nimet1 : nimet) {
            if(this.kaveriToiveet.contains(nimet1)){
                this.kaveriToiveet.remove(nimet1);
            }
        }
    }
    /**
     * Tyhjentaa sitsaajan kaveritoiveet.
     */
    public void tyhjennaKaveritoiveet(){
        this.kaveriToiveet.clear();
        
    }
    /**
     * Asettaa sitsaajalle käyttäjän syöttämät kaveritoiveet.
     * @param kaverit pilkulla erotellut kaveritoiveet.
     */
    public void setKaveriToive(String... kaverit) {
        for (String a : kaverit) {
            if (!kaveriToiveet.contains(a)) {
                this.kaveriToiveet.add(a);
            }
        }
    }
    /**
     * Asettaa sitsaajalle sukupuolen.
     * @param sukupuoli Sukupuoli voi olla joko mies tai nainen.
     */
    public void setSukupuoli(Sukupuoli sukupuoli) {
        this.sukupuoli = sukupuoli;
    }
    /**
     * Asettaa sitsaajalle sitseiltä löydetyn kaveritoiveen.
     * @param sitsaaja Löydetty kaveritoive.
     */
    public void setKaveri(Sitsaaja... sitsaaja) {
        for (Sitsaaja a : sitsaaja) {
            this.kaverit.add(a);
        }
        Collections.sort(kaverit);
    }
    /**
     * Asettaa sitsaajalle suosion.
     * @param tykkays Sitsaajan saamien kaveritoiveiden määrä.
     */
    public void setSuosio(int tykkays) {
        this.suosio = tykkays;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.nimi);
        return hash;
    }

    /**
     * Sitsaajia verrataan nimen perusteella.
     *
     * @param obj Sitsaajan ilmentymä johon verrataan tätä sitsaajaa.
     * @return palauttaa 1,0,-1 iippuen verrattavien sitsaajien nimistä.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sitsaaja other = (Sitsaaja) obj;
        if (!Objects.equals(this.nimi.toUpperCase(), other.nimi.toUpperCase())) {
            return false;
        }
        return true;
    }

    /**
     * Plassaamista varten Sitsaajat on järsjetettävä suosion perusteella.
     *
     * @param sitsaaja Sitsaajan ilmentymä johon tätä sitsaajaa verrataan.
     * @return palauttaa 1,-1,0 riippuen verrattavien sitsaajien suosioista.
     * Suoistuimpi järjsetetään listassa edemmäs.
     */
    @Override
    public int compareTo(Sitsaaja sitsaaja) {
        if (this.suosio == sitsaaja.getSuosio()) {
            return 0;
        } else if (this.suosio > sitsaaja.getSuosio()) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return this.nimi;
    }
}
