/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka.sitsaajatJaPoyta;

import java.util.*;
import java.util.Objects;

/**
 *
 * @author Santeri
 */
//Sitsaajaan tallentuu kaikki sitsaajaa koskevat tiedot:nimi,avec,kaverit,
//ruoka... jne.
public class Sitsaaja implements Comparable<Sitsaaja> {

    private String avecToive;
    private String nimi;
    private Sitsaaja avec;
    private String[] kaveriToiveet;
    private List<Sitsaaja> kaverit;
    private int suosio;

    public Sitsaaja(String nimi, String avecToive) {
        if (!nimi.matches("[a-zA-Z a-zA-Z]+") && nimi != null) {
            throw new IllegalArgumentException("Nimen pitaa olla muotoa: Matti "
                    + "Meikalainen");
        }
        if (nimi == null) {
            throw new NullPointerException("Nimi ei saa olla Null");
        }
        if (avecToive != null && !avecToive.matches("[a-zA-Z a-zA-Z]+")) {
            throw new IllegalArgumentException("Avecin nimi on joko jatettava"
                    + " tyhjaksi tai sen oltava muotoa: Matti Meikalainen");
        }
        if (nimi.equals(avecToive)) {
            avecToive = null;
        }
        this.nimi = nimi;
        this.avecToive = avecToive;
        this.kaverit = new ArrayList<>();
        this.suosio = 0;
    }

    //getterit
    public String getNimi() {
        return nimi;
    }

    public String getAvecToive() {
        return avecToive;
    }

    public String[] getKaveriToive() {
        return kaveriToiveet;
    }

    public Sitsaaja getAvec() {
        return avec;
    }

    public Sitsaaja[] getKaverit() {
        Sitsaaja[] tmp = new Sitsaaja[this.kaverit.size()];
        tmp = this.kaverit.toArray(tmp);
        return tmp;
    }

    public int getSuosio() {
        return this.suosio;
    }

    //setterit

    public void setAvec(Sitsaaja avec) {
        this.avec = avec;
    }

    public void setKaveriToive(String... kaverit) {

        this.kaveriToiveet = kaverit;
    }

    public void setKaveri(Sitsaaja sitsaaja) {
        this.kaverit.add(sitsaaja);
    }

    public void setSuosio(int tykkays) {
        this.suosio = tykkays;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.nimi);
        return hash;
    }

    //Päätin vertailla sitsaajia nimen perusteella. Plassaaja ei tällä hetkellä 
    //hyväksy kahden saman nimisen henkilön lisäystä, koska se sotkee liikaa.
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
}

