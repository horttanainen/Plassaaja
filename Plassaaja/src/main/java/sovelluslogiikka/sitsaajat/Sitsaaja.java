/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka.sitsaajat;

import java.util.*;
import java.util.Objects;

/**
 *Sitsaajaan tallentuu kaikki sitsaajaa koskevat tiedot:nimi,avec,kaverit,
 *ruoka... jne.
 * @author Santeri
 */

public class Sitsaaja implements Comparable<Sitsaaja> {

    private String avecToive;
    private String nimi;
    private Sitsaaja avec;
    private List<String> kaveriToiveet;
    public List<Sitsaaja> kaverit;
    private int suosio;
    private Sukupuoli sukupuoli;
/**
 * Luo sitsaajan. 
 * @param nimi Sitsaajan nimi
 * @param avecToive Sitsaajan avec toive (ei välttämättä toteudu, jos ei molempien hyväksyntää)
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
        this.kaveriToiveet=new ArrayList<>();
    }
    
    public void vaihdaSukupuolta(){
        if(this.sukupuoli!=null){
            if(this.sukupuoli==Sukupuoli.Mies){
                this.sukupuoli=Sukupuoli.Nainen;
            } else{
                this.sukupuoli=Sukupuoli.Mies;
            }
        }
    }

    //getterit
    public String getNimi() {
        return nimi;
    }

    public String getAvecToive() {
        return avecToive;
    }

    public String[] getKaveriToive() {
        String[] tmp = new String[this.kaveriToiveet.size()];
        tmp = this.kaveriToiveet.toArray(tmp);
        return tmp;
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
    
    public Sukupuoli getSukupuoli(){
        return this.sukupuoli;
    }

    //setterit

    public void setAvec(Sitsaaja avec) {
        this.avec = avec;
    }

    public void setKaveriToive(String... kaverit) {
            for (String a : kaverit) {
                if(!kaveriToiveet.contains(a)){
                this.kaveriToiveet.add(a);
                }
            }
        }
   
    
    public void setSukupuoli(Sukupuoli sukupuoli){
        this.sukupuoli=sukupuoli;
    }

    public void setKaveri(Sitsaaja... sitsaaja) {
        for (Sitsaaja a : sitsaaja) {
           this.kaverit.add(a); 
        }
        Collections.sort(kaverit);
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

   /**
    * Sitsaajia verrataan nimen perusteella.
    * @param obj Sitsaajan ilmentymä johon verrataan tätä sitsaajaa.
    * @return 
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
 * @param sitsaaja Sitsaajan ilmentymä johon tätä sitsaajaa verrataan.
 * @return 
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
    public String toString(){
        return this.nimi;
    }
}

