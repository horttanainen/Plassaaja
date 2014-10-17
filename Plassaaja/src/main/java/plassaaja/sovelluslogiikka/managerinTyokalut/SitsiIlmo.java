/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plassaaja.sovelluslogiikka.managerinTyokalut;

import java.util.*;
import plassaaja.sovelluslogiikka.sitsaajat.Sitsaaja;

/**
 *SitsiIlmo toimii sitsien ilmona ja sen kautta sitsaajat lisätään ja poistetaan
 * sitseiltä. Samalla se myös säilyttää listan kaikista ilmoittautuneista
 * sitsaajista.
 * @author Santeri
 */

public class SitsiIlmo {
    /**
     * Lista sitseille ilmoitetuista sitsaajista.
     */
    private List<Sitsaaja> sitsaajat;
    /**
     * Luo sitsi-ilmon ja sen yhteydessä alustaa listan ilmoitettaville sitsaajille.
     */
    public SitsiIlmo(){
        sitsaajat= new ArrayList<Sitsaaja>();
    }
    
    /**
     * Lisää käyttäjän syöttämät sitsaajat sitseille. Kahta samannimistä
     * sitsaajaa ei tosin voi ilmoittaa sitseille.
     * @param sitsaajat Käyttäjän syöttämät sitsaajat muodossa:
     * sitsaaja1, sitsaaja2, jne..
     */
    public void lisaaSitsaaja(Sitsaaja... sitsaajat){
        for(Sitsaaja a: sitsaajat){
        if(!this.sitsaajat.contains(a)){
            this.sitsaajat.add(a);
        }
        }
    }
    /**
     * Poistaa sitsaajan sitseiltä, jos sitsaaja löytyy sitsaajien joukosta.
     * @param sitsaaja Poistettava sitsaaja
     */
    public void poistaSitsaaja(Sitsaaja sitsaaja){
        if(sitsaajat.contains(new Sitsaaja(sitsaaja.getNimi(), null))){
            sitsaajat.remove(sitsaaja);
        }
    }
    
    /**
     * Palauttaa listan kaikista sitsaajista, jotka on ilmoitettu sitseille.
     * @return lista sitsaajsita.
     */
    public List<Sitsaaja> getSitsaajat(){
        return this.sitsaajat;
    }
    
    
    
}
