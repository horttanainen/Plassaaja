/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka.managerinTyokalut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sovelluslogiikka.sitsaajat.Sitsaaja;

/**
 *SitsaajienPisteyttajan on tarkoitus jarjestaa Sitsaajat järjestykseen siten,
 *että eniten kaveritoiveita saanut jarjestetaan listassa ensimmaiseksi,
 * toiseksi eniten toiveita kerännyt toiseksi jne...
 * @author Santeri
 */

public class SitsaajienPisteyttaja{
    /**
     * Lista sitseille ilmoitetusita sitsaajista.
     */
    private List<Sitsaaja> sitsaajat;
    /**
     * Sitsaajat jotka kerösivät pisteitä päätyvät tänne.
     */
    private List<Sitsaaja> sitsaajatPisteytettyna;
    /**
     * Sitsaajat jotka eivät saaneet toimeita sijaitsevat tässä listassa.
     */
    private List<Sitsaaja> sitsaajatJoillaEiPisteita;
    /**
     * SitsiIlmon ilmentymä josta sitseille ilmoitetut sitsaajat haetaan.
     */
    private SitsiIlmo ilmo;
    /**
     * Luo sitsaajienpisteyttäjän ja asettaa tälle SitsiIlmon ilmentymän, josta
     * pisteyttaja hakee pisteytettavat sitsaajat.
     * @param ilmo SitsiIlmo olio
     */
    public SitsaajienPisteyttaja(SitsiIlmo ilmo){
        this.ilmo=ilmo;
    }
    /**
     * Pisteyttaa kaikki sitseille ilmoitetut sitsaajat
     */
    public void pisteytaSitsaajat(){
        setSitsaajaLista();
        for(Sitsaaja a: sitsaajat){
            pisteytaSitsaaja(a);
        }
        jaaSitsaajatJoukkoihin();
    }
    /**
     * Jakaa sitsaajat kahteen joukkoon: Sitsaajiin jotka ovat saaneet
     * kaveritoiveita ja niihin jotka eivät.
     */
    protected void jaaSitsaajatJoukkoihin(){
        sitsaajatPisteytettyna=new ArrayList<>();
        sitsaajatJoillaEiPisteita=new ArrayList<>();
        Collections.sort(sitsaajat);
        for (Sitsaaja sitsaaja : sitsaajat) {
            if(sitsaaja.getSuosio()>0) sitsaajatPisteytettyna.add(sitsaaja);
            else{
                sitsaajatJoillaEiPisteita.add(sitsaaja);
            }
        }
    }
    
    /**
     * Asettaa sitsaajaListan pisteytaSitsaajat() kutsun yhteydessä.
     */
    protected void setSitsaajaLista(){
        this.sitsaajat=ilmo.getSitsaajat();
    }
    
    /**
     * Palauttaa Sitsaajat joilla on jonkinlainen pisteytys järjestettynä
     * suosion mukaan.
     * @return Lista pisteytetyistä sitsaajista.
     */
    public List<Sitsaaja> getPisteytettyLista(){
        Collections.sort(sitsaajatPisteytettyna);
        return sitsaajatPisteytettyna;
    }
    
    /**
     * Palauttaa listan sitsaajista joilla ei ole pisteitä.
     * @return Lista sitsaajista joilla ei ole pisteitä
     */
    public List<Sitsaaja> getSitsaajatJoillaEiOlePisteita(){
        Collections.sort(sitsaajatJoillaEiPisteita);
        return sitsaajatJoillaEiPisteita;
    }
    /**
     * Pisteyttää yksittäisen sitsaajan A
     * @param a Sitsaaja A
     */
    protected void pisteytaSitsaaja(Sitsaaja a){
        int loytyi=0;
        for(Sitsaaja b: sitsaajat){
            if( LoytyykoAKaveritoiveista(a, b)){
                loytyi++;
            }
        }
        a.setSuosio(loytyi);
    }
    /**
     * Tämä tarkastaa löytyykö sitsaajan A kaveritoivesta sitsaaja B.
     * @param a Sitsaaja A
     * @param b Sitsaaja B
     * @return true jos löytyy
     */
    protected boolean LoytyykoAKaveritoiveista(Sitsaaja a,Sitsaaja b){
        for (Sitsaaja toive : b.getKaverit()) {
            if (toive==a) return true;
        }
        return false;
    }
    
    
    
}
