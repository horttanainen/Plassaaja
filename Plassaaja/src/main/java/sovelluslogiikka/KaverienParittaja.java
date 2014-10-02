/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import sovelluslogiikka.sitsaajatJaPoyta.Sitsaaja;
import java.util.*;

/**
 *Parittaa Sitsaajan ilmentymälle sitsaajista kaverit mikäli kaverit löytyvät
 *ilmoittautuneiden joukosta. Toisin kuin Aveccienparitustilanteessa: 
 *kaveriksiparittaminen ei tarvitse molempien henkilöiden toivomusta.
 * @author Santeri
 */

public class KaverienParittaja{
    private List<Sitsaaja> sitsaajat;
    private SitsiIlmo ilmo;
    /**
     * Luo kaverienparittajan ja alustaa tälle Sitsiilmon, josta parittaja löytää
     * paritettavat sitsaajat.
     * @param ilmo 
     */
    public KaverienParittaja(SitsiIlmo ilmo){
        this.ilmo=ilmo;
    }
    
    /**
     * Asettaa kaverienparittajalle listan sitsaajista paritaKaverit() yhteydessä
     */
    private void setSitsaajaLista(){
        this.sitsaajat=ilmo.getSitsaajat();
    }

/**
 * Parittaa kaikille sitsaajille kaverit kaveripyyntöjä noudattaen.
 */
    public void paritaKaverit() {
        setSitsaajaLista();
        for (Sitsaaja a : sitsaajat) {
            paritaSitsaajalleKaveri(a);
        }
    }
    /**
     * Parittaa yksittäiselle sitsaajalle A kaverin.
     * @param a Sitsaaja A
     */
protected void paritaSitsaajalleKaveri(Sitsaaja a){
    if (a.getKaveriToive() != null) {
                for (String kaveritoive : a.getKaveriToive()) {
                    for (Sitsaaja b : sitsaajat) {
                        if (b.getNimi().equalsIgnoreCase(kaveritoive)) {
                            a.setKaveri(b);
                        }
                    }
                }
            }
}
}
