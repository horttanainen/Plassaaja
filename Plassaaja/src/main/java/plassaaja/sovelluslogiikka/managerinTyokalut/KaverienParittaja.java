/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plassaaja.sovelluslogiikka.managerinTyokalut;

import plassaaja.sovelluslogiikka.sitsaajat.Sitsaaja;
import java.util.*;

/**
 *Parittaa Sitsaajaoliollle sitsaajista kaverit mikäli kaverit löytyvät
 *ilmoittautuneiden joukosta. Toisin kuin Aveccienparitustilanteessa: 
 *kaveriksiparittaminen ei tarvitse molempien henkilöiden toivomusta.
 * @author Santeri
 */

public class KaverienParittaja{
    /**
     * Sitseille ilmoitetut sitsaajat.
     */
    private List<Sitsaaja> sitsaajat;
    /**
     * Sitsiilmo josta sitseille ilmoitetut sitsaajat haetaan.
     */
    private SitsiIlmo ilmo;
    /**
     * Luo kaverienparittajan ja liittää tähän SitsiIlmo-olion, josta parittaja löytää
     * paritettavat sitsaajat.
     * @param ilmo SitsiIlmo
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
        for (Sitsaaja sitsaaja : sitsaajat) {
            paritaSitsaajalleKaveri(sitsaaja);
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
