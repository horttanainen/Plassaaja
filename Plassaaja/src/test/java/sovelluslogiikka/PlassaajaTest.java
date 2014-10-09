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
import sovelluslogiikka.sitsaajat.Sitsaaja;
import sovelluslogiikka.sitsaajat.Sukupuoli;

/**
 *
 * @author Santeri
 */
public class PlassaajaTest {

    SitsaajienManagerointi manageri;
    Sitsaaja henkilo1;
    Sitsaaja henkilo2;
    Sitsaaja henkilo3;
    Sitsaaja henkilo4;
    Sitsaaja henkilo5;
    Sitsaaja henkilo6;
    Sitsaaja henkilo7;
    Sitsaaja henkilo8;
    Sitsaaja henkilo9;
    Sitsaaja henkilo10;
    Sitsaaja henkilo11;
    Sitsaaja henkilo12;
    Sitsaaja henkilo13;
    Sitsaaja henkilo14;
    Sitsaaja henkilo15;
    Sitsaaja henkilo16;
    Sitsaaja henkilo17;
    Sitsaaja henkilo18;
    Sitsaaja henkilo19;
    Sitsaaja henkilo20;
    Sitsaaja henkilo21;
    Sitsaaja henkilo22;
    Sitsaaja henkilo23;
    Sitsaaja henkilo24;

    @Before
    public void setUp() {
        manageri = new SitsaajienManagerointi();
        henkilo1 = new Sitsaaja("A", "B");
        henkilo2 = new Sitsaaja("B", "A");
        henkilo3 = new Sitsaaja("C", "D");
        henkilo4 = new Sitsaaja("D", "C");
        henkilo5 = new Sitsaaja("E", "joku");
        henkilo6 = new Sitsaaja("F", "E");
        henkilo7 = new Sitsaaja("G", "H");
        henkilo8 = new Sitsaaja("H", "G");
        henkilo9 = new Sitsaaja("I", null);
        henkilo10 = new Sitsaaja("J", null);
        henkilo11 = new Sitsaaja("K", null);
        henkilo12 = new Sitsaaja("L", null);
        henkilo13 = new Sitsaaja("M", null);
        henkilo14 = new Sitsaaja("N", null);
        henkilo15 = new Sitsaaja("O", null);
        henkilo16 = new Sitsaaja("P", "R");
        henkilo17 = new Sitsaaja("Q", null);
        henkilo18 = new Sitsaaja("R", "P");
        henkilo19 = new Sitsaaja("S", null);
        henkilo20 = new Sitsaaja("T", null);
        henkilo21 = new Sitsaaja("U", null);
        henkilo22 = new Sitsaaja("V", null);
        henkilo23 = new Sitsaaja("X", null);
        henkilo24 = new Sitsaaja("Y", null);
        henkilo1.setKaveriToive("I", "U", "C");
        henkilo2.setKaveriToive("I", "L");
        henkilo3.setKaveriToive("D", "K", "F");
        henkilo4.setKaveriToive("U", "G", "D", "K");
        henkilo5.setKaveriToive("X", "U", "C");
        henkilo6.setKaveriToive("Q", "Y", "O", "A");
        henkilo7.setKaveriToive("C", "V", "N");
        henkilo8.setKaveriToive("D");
        henkilo9.setKaveriToive("A", "D", "B", "G");
        henkilo10.setKaveriToive("Y", "S", "V", "R");
        henkilo11.setKaveriToive("O", "B", "Y", "Q");
        henkilo17.setKaveriToive("J", "K");
        henkilo18.setKaveriToive("T", "M");
        henkilo19.setKaveriToive("C", "H");
        henkilo20.setKaveriToive("Y");
        henkilo21.setKaveriToive("A", "D");
        henkilo22.setKaveriToive("Y");
        henkilo23.setKaveriToive("K", "V");
        henkilo24.setKaveriToive("O");
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Nainen);
        henkilo5.setSukupuoli(Sukupuoli.Mies);
        henkilo6.setSukupuoli(Sukupuoli.Nainen);
        henkilo7.setSukupuoli(Sukupuoli.Mies);
        henkilo8.setSukupuoli(Sukupuoli.Mies);
        henkilo9.setSukupuoli(Sukupuoli.Mies);
        henkilo10.setSukupuoli(Sukupuoli.Mies);
        henkilo11.setSukupuoli(Sukupuoli.Mies);
        henkilo12.setSukupuoli(Sukupuoli.Mies);
        henkilo13.setSukupuoli(Sukupuoli.Mies);
        henkilo14.setSukupuoli(Sukupuoli.Mies);
        henkilo15.setSukupuoli(Sukupuoli.Mies);
        henkilo16.setSukupuoli(Sukupuoli.Mies);
        henkilo17.setSukupuoli(Sukupuoli.Mies);
        henkilo18.setSukupuoli(Sukupuoli.Nainen);
        henkilo19.setSukupuoli(Sukupuoli.Nainen);
        henkilo20.setSukupuoli(Sukupuoli.Nainen);
        henkilo21.setSukupuoli(Sukupuoli.Nainen);
        henkilo22.setSukupuoli(Sukupuoli.Nainen);
        henkilo23.setSukupuoli(Sukupuoli.Nainen);
        henkilo24.setSukupuoli(Sukupuoli.Nainen);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void valittaakoLiianPienestaMaarasta(){
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.aveccienParittaja.plassaaAvecit();
        manageri.kaverienParittaja.paritaKaverit();
        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        manageri.plassaaja.plassaa();
    }
    @Test
    public void OnkoJokaToinenSitsaajaMies(){
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6,henkilo7,henkilo8,henkilo9,henkilo10,henkilo11,henkilo12,henkilo13,henkilo14,henkilo15,henkilo16);
        manageri.aveccienParittaja.plassaaAvecit();
        manageri.kaverienParittaja.paritaKaverit();
        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        manageri.plassaaja.plassaa();
        List<Sitsaaja> poyta=manageri.poyta.getPoyta();
        assertTrue(poyta.get(0).getSukupuoli()==Sukupuoli.Mies);
        assertTrue(poyta.get(1).getSukupuoli()==Sukupuoli.Nainen);
        
    }
}
