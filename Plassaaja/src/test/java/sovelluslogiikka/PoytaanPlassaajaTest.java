/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sovelluslogiikka;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import sitsaajatJaPoyta.Sitsaaja;

/**
 *
 * @author Santeri
 */
public class PoytaanPlassaajaTest {
    
    PoytaanPlassaaja plassaaja;
    Sitsaaja henkilo1;
    Sitsaaja henkilo2;
    Sitsaaja henkilo3;
    

    @Before
    public void setUp() {
        plassaaja = new PoytaanPlassaaja();
        henkilo1= new Sitsaaja("Matti Meikäläinen", "Vilma Sutela");
        henkilo2= new Sitsaaja("Vilma Sutela", "Matti Meikäläinen");
        henkilo3= new Sitsaaja("Kippari Kalle", "Vilma Sutela");
    }
    
    @Test
    public void OnnistunutAvecinAsetus(){
        
    }
    
    @Test
    public void AvecValintaOnnistuuVainMolempienSuostumuksella(){
        
    }
    
    
    
    
    
    
    
}
