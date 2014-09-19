/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sovelluslogiikka;

import sovelluslogiikka.sitsaajatJaPoyta.Sitsaaja;
import java.util.*;
/**
 *
 * @author Santeri
 */
//AveccienParittaja nimensä mukaisesti parittaa sitsaajille avecit
//aveccitoiveita noudattaen, mikäli kummallakin on toisensa aveceiksi merkittyina.
public class AveccienParittaja extends SitsiIlmo {
    private List<Sitsaaja> sitsaajat;
    
    public AveccienParittaja(SitsiIlmo ilmo){
        this.sitsaajat=ilmo.getSitsaajat();
    }
    
    public void plassaaAvecit(){
        for(Sitsaaja a: sitsaajat){
            for(Sitsaaja b: sitsaajat){
                if(a.getAvecToive()!=null && a.getAvecToive().equalsIgnoreCase(b.getNimi())){
                    if(b.getAvecToive() !=null && b.getAvecToive().equalsIgnoreCase(a.getNimi())){
                        a.setAvec(b);
                    }
                }
            }
        }
    }
    
    public boolean ovatkoAvecit(Sitsaaja sitsaaja1, Sitsaaja sitsaaja2){
        if(sitsaaja1.getAvecToive()==null || sitsaaja2.getAvecToive()==null){
            return false;
        }
        return sitsaaja1.getAvec()==sitsaaja2;
    }
    
}
