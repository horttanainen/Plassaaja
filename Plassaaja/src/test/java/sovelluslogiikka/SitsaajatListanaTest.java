/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import java.util.*;
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
public class SitsaajatListanaTest {

    SitsaajatListana ilmo;
    Sitsaaja henkilo1;
    Sitsaaja henkilo2;
    Sitsaaja henkilo3;
    Sitsaaja henkilo4;
    Sitsaaja henkilo5;
    Sitsaaja henkilo6;

    @Before
    public void setUp() {
        ilmo = new SitsaajatListana();
        henkilo1= new Sitsaaja("Matti Meikalainen", "Vilma Sutela");
        henkilo2= new Sitsaaja("Vilma Sutela", "Matti Meikalainen");
        henkilo3= new Sitsaaja("Kippari Kalle", "Vilma Sutela");
        henkilo4= new Sitsaaja("Tatti Meikalainen", "Kilma Sutela");
        henkilo5= new Sitsaaja("Kilma Sutela", "Tatti Meikalainen");
        henkilo6= new Sitsaaja("Kuppa Kalle", "Vilma Sutela");
    }

    @Test
    public void yksittaisenSitsaajanLisaysOikeallaArvolla() {
        ilmo.lisaaSitsaaja(henkilo1);
        assertTrue(ilmo.getSitsaajat().contains(henkilo1));
    }
    
    @Test
    public void kahdenSamanNimisenHenkilonLisaaminenEiOnnistu(){
        henkilo2=new Sitsaaja("Matti Meikalainen", null);
        ilmo.lisaaSitsaaja(henkilo1);
        ilmo.lisaaSitsaaja(henkilo2);
        assertEquals(1,ilmo.getSitsaajat().size());
    }
    
    

}
