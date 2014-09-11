/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sovelluslogiikka;

import java.util.*;
import sitsaajatJaPoyta.Sitsaaja;

/**
 *
 * @author Santeri
 */
public class SitsaajienLisaaja {
    private List<Sitsaaja> sitsaajat;
    
    public SitsaajienLisaaja(){
        sitsaajat= new ArrayList<Sitsaaja>();
    }
    
    //setterit
    
    public void lisaaSitsaaja(Sitsaaja sitsaaja){
        if(!sitsaajat.contains(sitsaaja)){
            sitsaajat.add(sitsaaja);
        }
        
    }
    
    //getterit
    public List<Sitsaaja> getSitsaajat(){
        return this.sitsaajat;
    }
    
    
    
}
