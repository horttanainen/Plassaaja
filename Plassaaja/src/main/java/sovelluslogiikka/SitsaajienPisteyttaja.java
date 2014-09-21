/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.List;
import sovelluslogiikka.sitsaajatJaPoyta.Sitsaaja;

/**
 *
 * @author Santeri
 */

//SitsaajienJarjestajan on tarkoitus jarjestaa Sitsaajat järsejtykseen siten
//että eniten kaveritoiveita saanut plassataan ensimmäiseksi ja seuraavaksi avec, jne..
public class SitsaajienJarjestaja extends SitsiIlmo {
    private List<Sitsaaja> sitsaajat;
    
    public SitsaajienJarjestaja(SitsiIlmo ilmo){
        this.sitsaajat=ilmo.getSitsaajat();
    }
    
    public void pisteytaSitsaajat(){
        
    }
    
    
}
