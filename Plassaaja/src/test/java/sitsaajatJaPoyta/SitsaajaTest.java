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
        henkilo = new Sitsaaja("Matti Meikäläinen", "Maija Muukalainen");
}
    @Test
    public void OikeanNimenAsetusOnnistuu(){
        assertEquals("Matti Meikäläinen", henkilo.getNimi());
    }
    
    @Test
    public void OikeanAvecToiveenAsetusOnnistuu(){
        assertEquals("Maija Muukalainen", henkilo.getAvecToive());
    }
    
    @Test
    public void nimessaVainKirjaimia(){
        assertTrue(henkilo.getNimi().matches("[a-zA-Z]+"));
    }

    @Test
    public void avecinNimessaVainKirjaimia(){
        assertTrue(henkilo.getAvecToive().matches("[a-zA-Z]+"));
    }

}
