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
    
    AveccienParittaja parittaja;
    SitsaajatListana ilmo;
    Sitsaaja henkilo1;
    Sitsaaja henkilo2;
    Sitsaaja henkilo3;
    

    @Before
    public void setUp() {
        henkilo1= new Sitsaaja("Matti Meikalainen", "Vilma Sutela");
        henkilo2= new Sitsaaja("Vilma Sutela", "Matti Meikalainen");
        henkilo3= new Sitsaaja("Kippari Kalle", "Vilma Sutela");
        ilmo= new SitsaajatListana();
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
    
    @Test
    public void avecinNimenAsetusOnnistuuVaikkaIsotKirjaimetSekaisin(){
        Sitsaaja henkilo4= new Sitsaaja("MAIju meneva", "jaska jokela");
        Sitsaaja henkilo5=new Sitsaaja("Jaska Jokela", "Maiju Meneva");
        ilmo.lisaaSitsaaja(henkilo4);
        ilmo.lisaaSitsaaja(henkilo5);
        parittaja.plassaaAvecit();
        assertTrue(parittaja.ovatkoAvecit(henkilo4, henkilo5));
    }
    
    @Test
    public void itseaanEiVoiValitaAvecikci(){
        Sitsaaja henkilo6=new Sitsaaja("Antonio Boas", "Antonio Boas");
        ilmo.lisaaSitsaaja(henkilo6);
        parittaja.plassaaAvecit();
        
    }
    
    
    
    
    
    
}
