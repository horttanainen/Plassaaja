/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plassaaja.sovelluslogiikka;

import plassaaja.sovelluslogiikka.Poyta;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.ls.LSInput;
import plassaaja.sovelluslogiikka.managerinTyokalut.SitsiIlmo;
import plassaaja.sovelluslogiikka.sitsaajat.Sitsaaja;
import plassaaja.sovelluslogiikka.sitsaajat.Sitsaaja;

/**
 *
 * @author Santeri
 */
public class PoytaTest {
    
    Poyta poyta;
    
    @Before
    public void setUp(){
      poyta=new Poyta();
    }
    
    
    @Test
    public void getPoytaPalauttaaList(){
        List<Sitsaaja> lista =new ArrayList<>();
        assertEquals(lista, poyta.getPoyta());
    }
    
    
    
}
