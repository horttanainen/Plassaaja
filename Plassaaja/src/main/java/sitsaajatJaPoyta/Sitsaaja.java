/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sitsaajatJaPoyta;


/**
 *
 * @author Santeri
 */
public class Sitsaaja {
    private String avecToive;
    private String nimi;

    
    
    public Sitsaaja(String nimi, String avecToive){
        
        this.nimi=nimi;
        this.avecToive=avecToive;
    }
    
    //getterit
    public String getNimi(){
        return nimi;
    }
    
    public String getAvecToive(){
        return avecToive;
    }
    
    //setterit
    
}
