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
public class AveccienParittajaTest {
    
    AveccienParittaja parittaja;
    SitsaajienLisaaja ilmo;
    Sitsaaja henkilo1;
    Sitsaaja henkilo2;
    Sitsaaja henkilo3;
    

    @Before
    public void setUp() {
        henkilo1= new Sitsaaja("Matti Meikalainen", "Vilma Sutela");
        henkilo2= new Sitsaaja("Vilma Sutela", "Matti Meikalainen");
        henkilo3= new Sitsaaja("Kippari Kalle", "Vilma Sutela");
        ilmo= new SitsaajienLisaaja();
        ilmo.lisaaSitsaaja(henkilo1);
        ilmo.lisaaSitsaaja(henkilo2);
        ilmo.lisaaSitsaaja(henkilo3);
        parittaja = new AveccienParittaja(ilmo);
        
        
    }
    
    @Test
    public void OnnistunutAvecinAsetus(){
        parittaja.plassaaAvecit();
        assertTrue(parittaja.ovatkoAvecit(henkilo1, henkilo2));
    }
    
    @Test
    public void AvecValintaOnnistuuVainMolempienSuostumuksella(){
        parittaja.plassaaAvecit();
        assertFalse(parittaja.ovatkoAvecit(henkilo3, henkilo2));
    }
    
    
    
    
    
    
}
