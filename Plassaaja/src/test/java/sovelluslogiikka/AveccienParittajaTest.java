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
import sovelluslogiikka.sitsaajatJaPoyta.Sitsaaja;

/**
 *
 * @author Santeri
 */
public class AveccienParittajaTest {
    
    SitsaajienManagerointi manageri;

    Sitsaaja henkilo1;
    Sitsaaja henkilo2;
    Sitsaaja henkilo3;
    

    @Before
    public void setUp() {
        henkilo1= new Sitsaaja("Matti Meikalainen", "Vilma Sutela");
        henkilo2= new Sitsaaja("Vilma Sutela", "Matti Meikalainen");
        henkilo3= new Sitsaaja("Kippari Kalle", "Vilma Sutela");
        manageri = new SitsaajienManagerointi();
        manageri.ilmo.lisaaSitsaaja(henkilo1);
        manageri.ilmo.lisaaSitsaaja(henkilo2);
        manageri.ilmo.lisaaSitsaaja(henkilo3);
       
        
        
    }
    
    @Test
    public void OnnistunutAvecinAsetus(){
        manageri.aveccienParittaja.plassaaAvecit();
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo1, henkilo2));
    }
    
    @Test
    public void AvecValintaOnnistuuVainMolempienSuostumuksella(){
        manageri.aveccienParittaja.plassaaAvecit();
        assertFalse(manageri.aveccienParittaja.ovatkoAvecit(henkilo3, henkilo2));
    }
    
    @Test
    public void avecinNimenAsetusOnnistuuVaikkaIsotKirjaimetSekaisin(){
        Sitsaaja henkilo4= new Sitsaaja("MAIju meneva", "jaska jokela");
        Sitsaaja henkilo5=new Sitsaaja("Jaska Jokela", "Maiju Meneva");
        manageri.ilmo.lisaaSitsaaja(henkilo4);
        manageri.ilmo.lisaaSitsaaja(henkilo5);
        manageri.aveccienParittaja.plassaaAvecit();
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo4, henkilo5));
    }
    
    @Test
    public void itseaanEiVoiValitaAvecikci(){
        Sitsaaja henkilo6=new Sitsaaja("Antonio Boas", "Antonio Boas");
        manageri.ilmo.lisaaSitsaaja(henkilo6);
        manageri.aveccienParittaja.plassaaAvecit();
        assertFalse(manageri.aveccienParittaja.ovatkoAvecit(henkilo6, henkilo6));
    }
    
    
    
    
    
    
}
