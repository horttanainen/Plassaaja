/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka.sitsaajatJaPoyta;

import java.util.*;
import sovelluslogiikka.SitsaajatListana;

/**
 *
 * @author Santeri
 */
//Poyta on luokka, jossa on sitsaajien paikat poydassa. Poyta pitaa kasitella 
//metodeilla vastaamaan todelista poytaa. 
//Sitsaajat voi istuttaa vaika kolmeen pieneen ja yhteen isoon pöytään.
//Poyta on Sitsaaja[] array jossa ensimmainen paikka [0] on poydan vasemmassa
//ylakulmassa sijaitseva paikka. Seuraava paikka [1] on paikkaa [0] vastapaata.
//  0   2   4   6   8   10  ...     i-2    i       i+2
//  1   3   5   7   9   11  ...     i-1    i+1     i+3
//Missa Sitsaaja[i]=henkilo(Nimi,Avec,...)
public class Poyta {
    private Sitsaaja[] poyta;
    public Poyta(SitsaajatListana listaSitsaajista){
        poyta = new Sitsaaja[listaSitsaajista.getSitsaajat().size()];
        this.poyta=listaSitsaajista.getSitsaajat().toArray(poyta);
        
    }
    
    //getterit
    
    public int getKoko(){
        return poyta.length;
    }
    public Sitsaaja[] getPoyta(){
        return poyta;
    }
    

    
    
    
    
    
}
