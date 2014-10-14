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
    Sitsaaja henkilo25;
    Sitsaaja henkilo26;
    Sitsaaja henkilo27;
    Sitsaaja henkilo28;
    Sitsaaja henkilo29;
    Sitsaaja henkilo30;
    Sitsaaja henkilo31;
    Sitsaaja henkilo32;
    Sitsaaja henkilo33;
    Sitsaaja henkilo34;
    Sitsaaja henkilo36;
    Sitsaaja henkilo35;

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
    public void valittaakoLiianPienestaMaarasta() {
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.aveccienParittaja.plassaaAvecit();
        manageri.kaverienParittaja.paritaKaverit();
        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        manageri.plassaaja.plassaa();
    }
    

    @Test
    public void OnkoPoydankokoOikea() {
        henkilo25 = new Sitsaaja("AA", null);
        henkilo26 = new Sitsaaja("AB", null);
        henkilo27 = new Sitsaaja("AC", null);
        henkilo28 = new Sitsaaja("AD", null);
        henkilo29 = new Sitsaaja("AE", null);
        henkilo30 = new Sitsaaja("AF", null);
        henkilo31 = new Sitsaaja("AG", null);
        henkilo32 = new Sitsaaja("AH", null);
        henkilo33 = new Sitsaaja("AI", null);
        henkilo34 = new Sitsaaja("AK", null);
        henkilo35 = new Sitsaaja("AL", null);
        henkilo36 = new Sitsaaja("AM", null);
        henkilo25.setSukupuoli(Sukupuoli.Mies);
        henkilo26.setSukupuoli(Sukupuoli.Mies);
        henkilo27.setSukupuoli(Sukupuoli.Mies);
        henkilo28.setSukupuoli(Sukupuoli.Mies);
        henkilo29.setSukupuoli(Sukupuoli.Mies);
        henkilo30.setSukupuoli(Sukupuoli.Mies);
        henkilo31.setSukupuoli(Sukupuoli.Nainen);
        henkilo32.setSukupuoli(Sukupuoli.Nainen);
        henkilo33.setSukupuoli(Sukupuoli.Nainen);
        henkilo34.setSukupuoli(Sukupuoli.Nainen);
        henkilo35.setSukupuoli(Sukupuoli.Nainen);
        henkilo36.setSukupuoli(Sukupuoli.Nainen);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6, henkilo7, henkilo8, henkilo9, henkilo10, henkilo11, henkilo12, henkilo13, henkilo14, henkilo15, henkilo16, henkilo17, henkilo18, henkilo19, henkilo20, henkilo21, henkilo22, henkilo23, henkilo24, henkilo25, henkilo26, henkilo27, henkilo28, henkilo29, henkilo30, henkilo31, henkilo32, henkilo33, henkilo34, henkilo35, henkilo36);
        manageri.aveccienParittaja.plassaaAvecit();
        manageri.kaverienParittaja.paritaKaverit();
        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        manageri.plassaaja.plassaa();
        List<Sitsaaja> poyta = manageri.poyta.getPoyta();
        assertEquals(36, poyta.size());

    }
    
    @Test
    public void onkoJokaToinenMies(){
        henkilo25 = new Sitsaaja("AA", null);
        henkilo26 = new Sitsaaja("AB", null);
        henkilo27 = new Sitsaaja("AC", null);
        henkilo28 = new Sitsaaja("AD", null);
        henkilo29 = new Sitsaaja("AE", null);
        henkilo30 = new Sitsaaja("AF", null);
        henkilo31 = new Sitsaaja("AG", null);
        henkilo32 = new Sitsaaja("AH", null);
        henkilo33 = new Sitsaaja("AI", null);
        henkilo34 = new Sitsaaja("AK", null);
        henkilo35 = new Sitsaaja("AL", null);
        henkilo36 = new Sitsaaja("AM", null);
        henkilo25.setSukupuoli(Sukupuoli.Mies);
        henkilo26.setSukupuoli(Sukupuoli.Mies);
        henkilo27.setSukupuoli(Sukupuoli.Mies);
        henkilo28.setSukupuoli(Sukupuoli.Mies);
        henkilo29.setSukupuoli(Sukupuoli.Mies);
        henkilo30.setSukupuoli(Sukupuoli.Mies);
        henkilo31.setSukupuoli(Sukupuoli.Nainen);
        henkilo32.setSukupuoli(Sukupuoli.Nainen);
        henkilo33.setSukupuoli(Sukupuoli.Nainen);
        henkilo34.setSukupuoli(Sukupuoli.Nainen);
        henkilo35.setSukupuoli(Sukupuoli.Nainen);
        henkilo36.setSukupuoli(Sukupuoli.Nainen);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6, henkilo7, henkilo8, henkilo9, henkilo10, henkilo11, henkilo12, henkilo13, henkilo14, henkilo15, henkilo16, henkilo17, henkilo18, henkilo19, henkilo20, henkilo21, henkilo22, henkilo23, henkilo24, henkilo25, henkilo26, henkilo27, henkilo28, henkilo29, henkilo30, henkilo31, henkilo32, henkilo33, henkilo34, henkilo35, henkilo36);
        manageri.aveccienParittaja.plassaaAvecit();
        manageri.kaverienParittaja.paritaKaverit();
        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        manageri.plassaaja.plassaa();
        List<Sitsaaja> poyta = manageri.poyta.getPoyta();
        assertTrue(poyta.get(0).getSukupuoli()==Sukupuoli.Nainen);
        assertTrue(poyta.get(3).getSukupuoli()==Sukupuoli.Nainen);
        assertTrue(poyta.get(4).getSukupuoli()==Sukupuoli.Nainen);
        assertTrue(poyta.get(7).getSukupuoli()==Sukupuoli.Nainen);
        assertTrue(poyta.get(1).getSukupuoli()==Sukupuoli.Mies);
        assertTrue(poyta.get(2).getSukupuoli()==Sukupuoli.Mies);
        assertTrue(poyta.get(5).getSukupuoli()==Sukupuoli.Mies);
        assertTrue(poyta.get(6).getSukupuoli()==Sukupuoli.Mies);
        
    }
    
    @Test
    public void miestenPaikatToimiiOikein(){
        List<Integer> m = manageri.plassaaja.miestenPaikat();
        assertTrue(m.contains(1));
        assertTrue(m.contains(2));
        assertTrue(m.contains(5));
        assertTrue(m.contains(6));
        assertTrue(m.contains(9));
        assertFalse(m.contains(0));
        assertFalse(m.contains(3));
        assertFalse(m.contains(4));
        assertFalse(m.contains(7));
        assertFalse(m.contains(8));
        assertFalse(m.contains(11));
        
    }
    
    @Test
    public void ryhmittajaEihukkaaSitsaajia(){
        henkilo25 = new Sitsaaja("AA", null);
        henkilo26 = new Sitsaaja("AB", null);
        henkilo27 = new Sitsaaja("AC", null);
        henkilo28 = new Sitsaaja("AD", null);
        henkilo29 = new Sitsaaja("AE", null);
        henkilo30 = new Sitsaaja("AF", null);
        henkilo31 = new Sitsaaja("AG", null);
        henkilo32 = new Sitsaaja("AH", null);
        henkilo33 = new Sitsaaja("AI", null);
        henkilo34 = new Sitsaaja("AK", null);
        henkilo35 = new Sitsaaja("AL", null);
        henkilo36 = new Sitsaaja("AM", null);
        henkilo25.setSukupuoli(Sukupuoli.Mies);
        henkilo26.setSukupuoli(Sukupuoli.Mies);
        henkilo27.setSukupuoli(Sukupuoli.Mies);
        henkilo28.setSukupuoli(Sukupuoli.Mies);
        henkilo29.setSukupuoli(Sukupuoli.Mies);
        henkilo30.setSukupuoli(Sukupuoli.Mies);
        henkilo31.setSukupuoli(Sukupuoli.Nainen);
        henkilo32.setSukupuoli(Sukupuoli.Nainen);
        henkilo33.setSukupuoli(Sukupuoli.Nainen);
        henkilo34.setSukupuoli(Sukupuoli.Nainen);
        henkilo35.setSukupuoli(Sukupuoli.Nainen);
        henkilo36.setSukupuoli(Sukupuoli.Nainen);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6, henkilo7, henkilo8, henkilo9, henkilo10, henkilo11, henkilo12, henkilo13, henkilo14, henkilo15, henkilo16, henkilo17, henkilo18, henkilo19, henkilo20, henkilo21, henkilo22, henkilo23, henkilo24, henkilo25, henkilo26, henkilo27, henkilo28, henkilo29, henkilo30, henkilo31, henkilo32, henkilo33, henkilo34, henkilo35, henkilo36);
        manageri.aveccienParittaja.plassaaAvecit();
        manageri.kaverienParittaja.paritaKaverit();
        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        manageri.plassaaja.setListat();
        int sitsaajienMaara=manageri.plassaaja.sitsaajatIlmanRyhmaa.size()+manageri.plassaaja.sitsaajatryhmissa.size();
        Set<Sitsaaja> joukko =new HashSet<>();
        for(Sitsaaja sitsaaja:manageri.plassaaja.sitsaajatIlmanRyhmaa){
            joukko.add(sitsaaja);
        }
        for(Sitsaaja sitsaaja:manageri.plassaaja.sitsaajatryhmissa){
            joukko.add(sitsaaja);
        }
        assertEquals(36, joukko.size());
        assertEquals(36, sitsaajienMaara);
    }

    @Test
    public void plassaajaPlassaaPoydanOikein() {
        henkilo25 = new Sitsaaja("AA", null);
        henkilo26 = new Sitsaaja("AB", null);
        henkilo27 = new Sitsaaja("AC", null);
        henkilo28 = new Sitsaaja("AD", null);
        henkilo29 = new Sitsaaja("AE", null);
        henkilo30 = new Sitsaaja("AF", null);
        henkilo31 = new Sitsaaja("AG", null);
        henkilo32 = new Sitsaaja("AH", null);
        henkilo33 = new Sitsaaja("AI", null);
        henkilo34 = new Sitsaaja("AK", null);
        henkilo35 = new Sitsaaja("AL", null);
        henkilo36 = new Sitsaaja("AM", null);
        henkilo25.setSukupuoli(Sukupuoli.Mies);
        henkilo26.setSukupuoli(Sukupuoli.Mies);
        henkilo27.setSukupuoli(Sukupuoli.Mies);
        henkilo28.setSukupuoli(Sukupuoli.Mies);
        henkilo29.setSukupuoli(Sukupuoli.Mies);
        henkilo30.setSukupuoli(Sukupuoli.Mies);
        henkilo31.setSukupuoli(Sukupuoli.Nainen);
        henkilo32.setSukupuoli(Sukupuoli.Nainen);
        henkilo33.setSukupuoli(Sukupuoli.Nainen);
        henkilo34.setSukupuoli(Sukupuoli.Nainen);
        henkilo35.setSukupuoli(Sukupuoli.Nainen);
        henkilo36.setSukupuoli(Sukupuoli.Nainen);

        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6, henkilo7, henkilo8, henkilo9, henkilo10, henkilo11, henkilo12, henkilo13, henkilo14, henkilo15, henkilo16, henkilo17, henkilo18, henkilo19, henkilo20, henkilo21, henkilo22, henkilo23, henkilo24, henkilo25, henkilo26, henkilo27, henkilo28, henkilo29, henkilo30, henkilo31, henkilo32, henkilo33, henkilo34, henkilo35, henkilo36);
        manageri.aveccienParittaja.plassaaAvecit();
        manageri.kaverienParittaja.paritaKaverit();
        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
        henkilo20.setSuosio(100);
        henkilo4.setSuosio(95);
        henkilo1.setSuosio(90);
        henkilo3.setSuosio(85);
        henkilo2.setSuosio(80);
        henkilo7.setSuosio(75);
        henkilo11.setSuosio(70);
        henkilo15.setSuosio(65);
        henkilo21.setSuosio(60);
        henkilo22.setSuosio(55);
        henkilo9.setSuosio(50);
        henkilo17.setSuosio(45);
        henkilo18.setSuosio(40);
        henkilo6.setSuosio(35);
        henkilo8.setSuosio(30);
        henkilo12.setSuosio(25);
        henkilo14.setSuosio(20);
        henkilo16.setSuosio(18);
        henkilo19.setSuosio(16);
        henkilo23.setSuosio(14);
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        manageri.plassaaja.plassaa();

    }
}
