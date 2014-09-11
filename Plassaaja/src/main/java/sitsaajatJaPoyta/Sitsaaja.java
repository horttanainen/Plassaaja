/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sitsaajatJaPoyta;

import java.util.Objects;


/**
 *
 * @author Santeri
 */
public class Sitsaaja {
    private String avecToive;
    private String nimi;
    private Sitsaaja avec;
    private String sposti;
    public Sitsaaja(String nimi, String avecToive){
        if (!nimi.matches("[a-zA-Z a-zA-Z]+")){
            throw new IllegalArgumentException("Nimen pitaa olla muotoa: Matti Meikalainen.");
        }
        this.nimi=nimi;
        this.avecToive=avecToive;
    }
    
    //getterit
    public String getNimi(){
        return nimi;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.nimi);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sitsaaja other = (Sitsaaja) obj;
        if (!Objects.equals(this.nimi, other.nimi)) {
            return false;
        }
        return true;
    }

    public String getAvecToive(){
        return avecToive;
    }
    
    public Sitsaaja getAvec(){
        return avec;
    }
    
    //setterit
    
    public void setAvec(Sitsaaja avec){
        this.avec=avec;
    }
    
    public void setSahkoposti(String sposti){
        this.sposti=sposti;
    }

}
