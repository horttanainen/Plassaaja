/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.*;
import sovelluslogiikka.SitsiIlmo;
import sovelluslogiikka.sitsaajat.Sitsaaja;

/**
 *Poyta on luokka, jossa on sitsaajien paikat poydassa. Poyta pitaa kasitella 
 *metodeilla vastaamaan todelista poytaa. 
 *Poyta on List jossa ensimmainen paikka [0] on poydan vasemmassa
 *ylakulmassa sijaitseva paikka. Seuraava paikka [1] on paikkaa [0] vastapaata.
 *0   2   4   6   8   10  ...     i-2    i       i+2    i+4     i+6
 *1   3   5   7   9   11  ...     i-1    i+1     i+3    i+5     i+7
 *
 * Naiset istuvat paikoilla 0,3,4,7,8,11,12,15
 * Miehet paikoilla 1,2,5,6,9,10,13,14,17
 * Avecit istuvat aina vieressä eli jos sitsaajan paikka on i, avecin paikka on
 * i+2
 * @author Santeri
 */

public class Poyta {
    /**
     * ArrayList johon sitsaajat plassataan. 
     */
    private List<Sitsaaja> poyta;
/**
 * Luo poytaolion.
 */
    public Poyta(){
        this.poyta= new ArrayList<>();
}
    
    public List<Sitsaaja> getPoyta(){
        return this.poyta;
    }
    
    /**
     * Lisaa sitsaajan poytaan.
     * @param sitsaaja Lisattava sitsaaja.
     */
    public void lisaaSitsaaja(Sitsaaja sitsaaja){
        this.poyta.add(sitsaaja);
    }
}
