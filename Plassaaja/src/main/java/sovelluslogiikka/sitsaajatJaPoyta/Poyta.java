/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka.sitsaajatJaPoyta;

import java.util.*;
import sovelluslogiikka.SitsiIlmo;

/**
 *Poyta on luokka, jossa on sitsaajien paikat poydassa. Poyta pitaa kasitella 
 *metodeilla vastaamaan todelista poytaa. 
 *Poyta on List jossa ensimmainen paikka [0] on poydan vasemmassa
 *ylakulmassa sijaitseva paikka. Seuraava paikka [1] on paikkaa [0] vastapaata.
 *0   2   4   6   8   10  ...     i-2    i       i+2
 *1   3   5   7   9   11  ...     i-1    i+1     i+3
 *
 * Naiset istuvat paikoilla 0,3,4,7,8,11,12,15
 * Miehet paikoilla 1,2,5,6,9,10,13,14,17
 * Avecit istuvat aina vieressä eli jos sitsaajan paikka on i, avecin paikka on
 * i+2
 * @author Santeri
 */

public class Poyta {
    private List<Sitsaaja> poyta;

    public Poyta(){
        this.poyta= new ArrayList<>();
}    
}
