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

//Parittaa Sitsaajan ilmentymälle sitsaajista kaverit mikäli sitsaajat löytyvät
//ilmoittautuneiden joukosta. Toisin kuin Aveccienparitustilanteessa: 
//kaveriksiparittaminen ei tarvitse molempien henkilöiden toivomusta.
public class KaverienParittaja {

    private List<Sitsaaja> sitsaajat;

    public KaverienParittaja(SitsaajatListana sitsaajat) {
        this.sitsaajat = sitsaajat.getSitsaajat();
    }

    public void paritaKaverit() {
        for (Sitsaaja a : sitsaajat) {
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

}
