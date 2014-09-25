/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sovelluslogiikka;

import sovelluslogiikka.sitsaajatJaPoyta.Sitsaaja;
import java.util.*;
/**
 *AveccienParittaja nimensä mukaisesti parittaa sitsaajille avecit
 *aveccitoiveita noudattaen, mikäli kummallakin on toisensa aveceiksi merkittyina.
 * @author Santeri
 */

public class AveccienParittaja {
    private SitsiIlmo ilmo;
    private List<Sitsaaja> sitsaajat;

    
    private void setSitsaajaLista(){
        this.sitsaajat=ilmo.getSitsaajat();
    }
    /**
     * Plassaa avecit kaikille aveccia toivoneille, jos toiveet täsmäävät
     * mielitietyn kanssa.
     */
    public void plassaaAvecit(){
        setSitsaajaLista();
        for(Sitsaaja a: sitsaajat){
            plassaaAlleAvec(a);
        }
    }
    
    protected void plassaaAlleAvec(Sitsaaja a){
        for(Sitsaaja b: sitsaajat){
                if(loytyykoAnAvecToiveistaB(a, b)){
                    if(loytyykoAnAvecToiveistaB(b, a)){
                        a.setAvec(b);
                    }
                }
            }
    }
    
    protected boolean loytyykoAnAvecToiveistaB(Sitsaaja a,Sitsaaja b){
        if(a.getAvecToive()!=null && a.getAvecToive().equalsIgnoreCase(b.getNimi())){
            return true;
        }
        return false;
    }
    /**
     * Tarkistaa ovatko kaksi sitsaajaa avecit keskenään.
     * @param sitsaaja1 Sitsaaja
     * @param sitsaaja2 Sitsaaja
     * @return true jos ovat avecit, muutoin false.
     */
    public boolean ovatkoAvecit(Sitsaaja sitsaaja1, Sitsaaja sitsaaja2){
        if(sitsaaja1.getAvecToive()==null || sitsaaja2.getAvecToive()==null){
            return false;
        }
        return sitsaaja1.getAvec()==sitsaaja2;
    }
    
}
