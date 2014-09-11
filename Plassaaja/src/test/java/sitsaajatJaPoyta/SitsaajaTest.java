/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sitsaajatJaPoyta;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Santeri
 */
public class SitsaajaTest {

    Sitsaaja henkilo;

    
    @Before
    public void setUp() {
        henkilo = new Sitsaaja("Matti Meikalainen", "Maija Muukalainen");
}
    @Test
    public void OikeanNimenAsetusOnnistuu(){
        assertEquals("Matti Meikalainen", henkilo.getNimi());
    }
    
    @Test
    public void OikeanAvecToiveenAsetusOnnistuu(){
        assertEquals("Maija Muukalainen", henkilo.getAvecToive());
    }
    

    
    @Test(expected = IllegalArgumentException.class)
    public void nimessaVainKirjaimia(){
        henkilo= new Sitsaaja("124214 3443asdf", null);
    }

    @Test
    public void avecinNimessaVainKirjaimia(){
        assertTrue(henkilo.getAvecToive().matches("[a-zA-Z a-zA-Z]+"));
    }
    
    @Test
    public void sitsaajanAvecinAsetusOnnistuu(){
        Sitsaaja henkilo2 =new Sitsaaja("Muija Meiju", null);
        henkilo.setAvec(henkilo2);
        assertEquals(henkilo2, henkilo.getAvec());
    }
    
}
