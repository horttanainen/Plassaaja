/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plassaaja.sovelluslogiikka.managerinTyokalut;

import plassaaja.sovelluslogiikka.sitsaajat.Sitsaaja;
import java.util.*;
/**
 *AveccienParittaja nimensä mukaisesti parittaa sitsaajille avecit
 *aveccitoiveita noudattaen, mikäli kummallakin on toisensa aveceiksi merkittyina.
 * @author Santeri
 */

public class AveccienParittaja {
    private SitsiIlmo ilmo;
    private List<Sitsaaja> sitsaajat;
    /**
     * Luo Aveccienparittajan ja liittää tähän SitsiIlmo-olion.
     * @param ilmo SitsiIlmo josta Aveccienparittaja hakee sitsaajat.
     */
    public AveccienParittaja(SitsiIlmo ilmo){
        this.ilmo=ilmo;
    }

    /**
     * Asettaa parittajalle sitsaajalistan. Tämä ei tapahdu aveccienparittajaa
     * luodessa, koska manageri luo myös sitsiilmon parittajan yhteydessä.
     */
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
            plassaaSitsaajalleAvec(a);
        }
    }
    /**
     * Plassaa yksittäiselle Sitsaajalle A avecin, jos avec on myös toivonut A:ta
     * @param a Sitsaaja A
     */
    protected void plassaaSitsaajalleAvec(Sitsaaja a){
        for(Sitsaaja b: sitsaajat){
                if(loytyykoAnAvecToiveistaB(a, b)){
                    if(loytyykoAnAvecToiveistaB(b, a)){
                        a.setAvec(b);
                    }
                }
            }
    }
    /**
     * Nimensä mukasiesti tarkastaa löytyykö sitsaajan A toiveista Sitsaaja B
     * @param a Sitsaaja A
     * @param b Sitsaaja B
     * @return Palauttaa true jos löytyy
     */
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
        if(sitsaaja1.getAvec()==null||sitsaaja2.getAvec()==null) return false;
        return sitsaaja1.getAvec()==sitsaaja2;
    }
    
}
