/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.Collections;
import java.util.List;
import sovelluslogiikka.sitsaajatJaPoyta.Sitsaaja;

/**
 *SitsaajienPisteyttajan on tarkoitus jarjestaa Sitsaajat järjestykseen siten,
 *että eniten kaveritoiveita saanut jarjestetaan listassa ensimmaiseksi,
 * toiseksi eniten toiveita kerännyt toiseksi jne...
 * @author Santeri
 */

public class SitsaajienPisteyttaja{
    private List<Sitsaaja> sitsaajat;
    private SitsiIlmo ilmo;
    
    
    public void pisteytaSitsaajat(){
        setSitsaajaLista();
        for(Sitsaaja a: sitsaajat){
            pisteytaSitsaaja(a);
        }
    }
    
    //setterit
    private void setSitsaajaLista(){
        this.sitsaajat=ilmo.getSitsaajat();
    }
    
    //getterit
    
    public List<Sitsaaja> getPisteytettyLista(){
        Collections.sort(sitsaajat);
        return sitsaajat;
    }
    
    protected void pisteytaSitsaaja(Sitsaaja a){
        int loytyi=0;
        for(Sitsaaja b: sitsaajat){
            if( LoytyykoAKaveritoiveista(a, b)){
                loytyi++;
            }
        }
        if(a.getAvec()!=null) loytyi++;
        a.setSuosio(loytyi);
        
    }
    
    protected boolean LoytyykoAKaveritoiveista(Sitsaaja a,Sitsaaja b){
        for (Sitsaaja toive : b.getKaverit()) {
            if (toive==a) return true;
        }
        return false;
    }
    
    
    
}
