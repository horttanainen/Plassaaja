/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sovelluslogiikka;

import java.util.*;
import sovelluslogiikka.sitsaajatJaPoyta.Sitsaaja;

/**
 *
 * @author Santeri
 */
//SitsaajatListana toimii ilmona ja samalla se säilyttää listan kaikista
//ilmoittautuneista sitsaajista.

public class SitsaajatListana {
    private List<Sitsaaja> sitsaajat;
    
    public SitsaajatListana(){
        sitsaajat= new ArrayList<Sitsaaja>();
    }
    
    //setterit
    
    public void lisaaSitsaaja(Sitsaaja... sitsaajat){
        for(Sitsaaja a: sitsaajat){
        if(!this.sitsaajat.contains(a)){
            this.sitsaajat.add(a);
        }
        }
    }
    
    public void poistaSitsaaja(Sitsaaja sitsaaja){
        if(sitsaajat.contains(new Sitsaaja(sitsaaja.getNimi(), null))){
            sitsaajat.remove(sitsaaja);
        }
    }
    
    //getterit
    public List<Sitsaaja> getSitsaajat(){
        return this.sitsaajat;
    }
    
    
    
}
