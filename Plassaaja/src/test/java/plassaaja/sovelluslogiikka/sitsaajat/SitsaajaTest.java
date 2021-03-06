/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plassaaja.sovelluslogiikka.sitsaajat;

import plassaaja.sovelluslogiikka.sitsaajat.Sukupuoli;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import plassaaja.sovelluslogiikka.sitsaajat.Sitsaaja;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import plassaaja.sovelluslogiikka.managerinTyokalut.SitsiIlmo;


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
    
    @Test(expected = NullPointerException.class)
    public void sitsaajallaPitaaOllaNimi(){
        henkilo=new Sitsaaja(null, null);
    }
    
    @Test
    public void sukupuolenAsetusOnnistuu(){
        henkilo.setSukupuoli(Sukupuoli.Mies);
        assertEquals(Sukupuoli.Mies, henkilo.getSukupuoli());
    }
    
    @Test
    public void aveccitoiveentyhjennysTyhjentaaAvecciToiveen(){
        henkilo.poistaAvectoive();
        assertTrue(henkilo.getAvecToive()==null);
    }
    
    @Test
    public void avecciToiveenvaihtoToimiiOikein(){
        henkilo.vaihdaAvectoivetta("Sanna");
        assertEquals("Sanna", henkilo.getAvecToive());
    }
    
    @Test
    public void poistaKaveritoiveetOnnistuneesti(){
        henkilo.setKaveriToive("sami","salla","santeri");
        henkilo.tyhjennaKaveritoiveet();
        assertTrue(henkilo.kaveriToiveet.isEmpty());
    }
    
    @Test
    public void poistaYksittainenKaveritoiveOnnistuneesti(){
        henkilo.setKaveriToive("sami","salla","santeri");
        henkilo.poistaKaveritoiveita("sami");
        List<String> lista = new ArrayList<>();
        lista.add("salla");
        lista.add("santeri");
        assertEquals(lista, henkilo.kaveriToiveet);
    }
    
    @Test
    public void sitsaajanNimenVaihtoOnnistuu(){
        henkilo.vaihdaNimi("kalle pulu");
        assertTrue(henkilo.getNimi().equals("kalle pulu"));
    }
    
    @Test
    public void poistaUseampiKaveritoiveOnnistuneesti(){
        henkilo.setKaveriToive("sami","salla","santeri");
        henkilo.poistaKaveritoiveita("sami","santeri");
        List<String> lista = new ArrayList<>();
        lista.add("salla");
        assertEquals(lista, henkilo.kaveriToiveet);
    }
    
    @Test
    public void sukupulenAsetusNaiseksiOnnistuu(){
        henkilo.setSukupuoli(Sukupuoli.Nainen);
        assertEquals(Sukupuoli.Nainen, henkilo.getSukupuoli());
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
    public void equals(){
        assertFalse(henkilo.equals(henkilo2));
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
    
    @Test
    public void toStringToimii(){
        assertEquals("Matti Meikalainen", henkilo.toString());
    }
    
    @Test
    public void sukupuolenVaihdosToimiiJosMiesJaNaisTasapainoOnPielessa(){
        henkilo.setSukupuoli(Sukupuoli.Mies);
        henkilo.vaihdaSukupuolta();
        assertEquals(Sukupuoli.Nainen, henkilo.getSukupuoli());
    }
    
}
