/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sovelluslogiikka.sitsaajatJaPoyta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sovelluslogiikka.sitsaajatJaPoyta.Sitsaaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sovelluslogiikka.SitsiIlmo;


/**
 *
 * @author Santeri
 */
public class SitsaajaTest {

    Sitsaaja henkilo;
    Sitsaaja henkilo2;
    Sitsaaja henkilo3;
    Sitsaaja henkilo4;
    Sitsaaja henkilo5;
    Sitsaaja henkilo6;

    
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

    @Test (expected = IllegalArgumentException.class)
    public void avecinNimessaVainKirjaimia(){
        henkilo=new Sitsaaja("joko mias", "234124 3453453");
    }
    
    @Test(expected = NullPointerException.class)
    public void sitsaajallaPitaaOllaNimi(){
        henkilo=new Sitsaaja(null, null);
    }
    

    
    @Test
    public void sitsaajanAvecinAsetusOnnistuu(){
        Sitsaaja henkilo2 =new Sitsaaja("Muija Meiju", null);
        henkilo.setAvec(henkilo2);
        assertEquals(henkilo2, henkilo.getAvec());
    }
    
    @Test
    public void kaverinAsetusOnnistuuOikeillaNimilla(){
        henkilo.setKaveriToive("Mikko Mallikas","Ville Kolehmainen");
        String[] kaverit= {"Mikko Mallikas","Ville Kolehmainen"};
        assertArrayEquals(kaverit, henkilo.getKaveriToive());
    }
    
    @Test
    public void compareToJarjestaaSitsaajatOikeinSuosionPerusteella(){
        henkilo2= new Sitsaaja("Vilma Sutela", "Matti Meikalainen");
        henkilo3= new Sitsaaja("Kippari Kalle", "Vilma Sutela");
        henkilo4= new Sitsaaja("Tatti Meikalainen", "Kilma Sutela");
        henkilo2.setSuosio(9);
        henkilo3.setSuosio(4);
        henkilo4.setSuosio(34);
        List<Sitsaaja> SitsaajatVaarin = new ArrayList<>();
        SitsaajatVaarin.add(henkilo2); SitsaajatVaarin.add(henkilo3); SitsaajatVaarin.add(henkilo4);
        List<Sitsaaja> SitsaajatOikein = new ArrayList<>();
        SitsaajatOikein.add(henkilo4); SitsaajatOikein.add(henkilo2); SitsaajatOikein.add(henkilo3);
        Collections.sort(SitsaajatVaarin);
        assertEquals(SitsaajatOikein, SitsaajatVaarin);
    }
    
}
