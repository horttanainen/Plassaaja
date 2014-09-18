/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sovelluslogiikka.sitsaajatJaPoyta.Sitsaaja;

/**
 *
 * @author Santeri
 */
public class SitsaajienJarjestajaTest {

    SitsaajienJarjestaja jarjestaja;
    SitsaajatListana ilmo;
    Sitsaaja henkilo1;
    Sitsaaja henkilo2;
    Sitsaaja henkilo3;
    Sitsaaja henkilo4;
    Sitsaaja henkilo5;
    Sitsaaja henkilo6;
    KaverienParittaja kParittaja;
    AveccienParittaja aParittaja;
    
    @Before
    public void setUp() {
        henkilo1= new Sitsaaja("Matti Meikalainen", "Vilma Sutela");
        henkilo2= new Sitsaaja("Vilma Sutela", "Matti Meikalainen");
        henkilo3= new Sitsaaja("Kippari Kalle", "Vilma Sutela");
        henkilo4= new Sitsaaja("Tatti Meikalainen", "Kilma Sutela");
        henkilo5= new Sitsaaja("Kilma Sutela", "Tatti Meikalainen");
        henkilo6= new Sitsaaja("Kuppa Kalle", "Vilma Sutela");
        henkilo1.setKaveriToive("Vilma Sutela", "Kippari Kalle", "Tatti Meikalainen","Kilma Sutela");
        henkilo2.setKaveriToive("Matti Meikalainen", "Tatti Meikalainen");
        henkilo3.setKaveriToive("Vilma Sutela");
        henkilo4.setKaveriToive("Vilma Sutela","Matti MEikalainen","Kippari kalle");
        henkilo5.setKaveriToive("vilma sutela","kippari kalle","Tatti MEikalainen");
        henkilo6.setKaveriToive("Vilma Sutela", "Kippari Kalle", "Tatti Meikalainen");
        ilmo.lisaaSitsaaja(henkilo1,henkilo2,henkilo3,henkilo4,henkilo5,henkilo6);
        kParittaja=new KaverienParittaja(ilmo);
        kParittaja.paritaKaverit();
        aParittaja=new AveccienParittaja(ilmo);
        aParittaja.plassaaAvecit();
        jarjestaja=new SitsaajienJarjestaja(ilmo);
        
    }
    
//    @Test
//    public void JarjestajaPisteyttaaSitsaajatOikein(){
//        jarjestaja.pisteytaSitsaajat();
//        List<Sitsaaja> lista = new ArrayList<>();
//        lista.add(henkilo2);
//        lista.add(henkilo4);
//        lista.add(henkilo3);
//        lista.add(henkilo1);
//        lista.add(henkilo5);
//        lista.add(henkilo6);
//        assertEquals(lista, jarjestaja.getPisteytettyLista());
//    }
    
}
