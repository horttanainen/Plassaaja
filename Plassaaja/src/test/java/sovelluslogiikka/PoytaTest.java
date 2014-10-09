/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import sovelluslogiikka.Poyta;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.ls.LSInput;
import sovelluslogiikka.SitsiIlmo;
import sovelluslogiikka.sitsaajat.Sitsaaja;
import sovelluslogiikka.sitsaajat.Sitsaaja;

/**
 *
 * @author Santeri
 */
public class PoytaTest {
    Sitsaaja henkilo1;
    Sitsaaja henkilo2;
    Sitsaaja henkilo3;
    Sitsaaja henkilo4;
    Sitsaaja henkilo5;
    Sitsaaja henkilo6;
    SitsiIlmo ilmo;
    Poyta poyta;
    
    @Before
    public void setUp() {
        henkilo1= new Sitsaaja("Matti Meikalainen", "Vilma Sutela");
        henkilo2= new Sitsaaja("Vilma Sutela", "Matti Meikalainen");
        henkilo3= new Sitsaaja("Kippari Kalle", "Vilma Sutela");
        henkilo4= new Sitsaaja("Tatti Meikalainen", "Kilma Sutela");
        henkilo5= new Sitsaaja("Kilma Sutela", "Tatti Meikalainen");
        henkilo6= new Sitsaaja("Kuppa Kalle", "Vilma Sutela");
        ilmo=new SitsiIlmo();
        ilmo.lisaaSitsaaja(henkilo1,henkilo2,henkilo3,henkilo4,henkilo5,henkilo6);
    }
    
    
//    @Test
//    public void getPoytaPalauttaaList(){
//        assertEquals(new List<Sitsaaja>, poyta.getPoyta());
//    }
    
}
