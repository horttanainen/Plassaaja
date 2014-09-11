/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sovelluslogiikka;

import sitsaajatJaPoyta.Sitsaaja;
import java.util.*;
/**
 *
 * @author Santeri
 */
public class AveccienParittaja {
    private List<Sitsaaja> sitsaajat;
    
    public AveccienParittaja(SitsaajienLisaaja lisaaja){
        sitsaajat = lisaaja.getSitsaajat();
    }
    
    public void plassaaAvecit(){
        for(Sitsaaja a: sitsaajat){
            for(Sitsaaja b: sitsaajat){
                if(a.getAvecToive().matches(b.getNimi())){
                    if(b.getAvecToive().matches(a.getNimi())){
                        a.setAvec(b);
                    }
                }
            }
        }
    }
    
    public boolean ovatkoAvecit(Sitsaaja sitsaaja1, Sitsaaja sitsaaja2){
        return sitsaaja1.getAvec()==sitsaaja2;
    }
    
}
