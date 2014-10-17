/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plassaaja.sovelluslogiikka.managerinTyokalut;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import plassaaja.sovelluslogiikka.SitsaajienManagerointi;
import plassaaja.sovelluslogiikka.sitsaajat.Sitsaaja;
import plassaaja.sovelluslogiikka.sitsaajat.Sukupuoli;

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
        henkilo25.setSukupuoli(Sukupuoli.Mies);
        henkilo26.setSukupuoli(Sukupuoli.Mies);
        henkilo27.setSukupuoli(Sukupuoli.Mies);
        henkilo28.setSukupuoli(Sukupuoli.Mies);
        henkilo29.setSukupuoli(Sukupuoli.Mies);
        henkilo30.setSukupuoli(Sukupuoli.Mies);
        henkilo31.setSukupuoli(Sukupuoli.Nainen);
        henkilo32.setSukupuoli(Sukupuoli.Nainen);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6, henkilo7, henkilo8, henkilo9, henkilo10, henkilo11, henkilo12, henkilo13, henkilo14, henkilo15, henkilo16, henkilo17, henkilo18, henkilo19, henkilo20, henkilo21, henkilo22, henkilo23, henkilo24, henkilo25, henkilo26, henkilo27, henkilo28, henkilo29, henkilo30, henkilo31, henkilo32);
        manageri.aveccienParittaja.plassaaAvecit();
        manageri.kaverienParittaja.paritaKaverit();
        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        manageri.plassaaja.plassaa();
        List<Sitsaaja> poyta = manageri.poyta.getPoyta();
        assertEquals(32, poyta.size());

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
        assertFalse(poyta.get(poyta.size()-2).getSukupuoli()==Sukupuoli.Nainen);
        
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
    public void paikkojenErikoistapaukset(){
        List<List<Integer>> paikat = manageri.plassaaja.paikatTestaustaVarten(0);
        List<Integer> normaali= new ArrayList<>();
        List<Integer> tapaus2= new ArrayList<>();
        List<Integer> tapaus4= new ArrayList<>();
        List<Integer> tapaus6= new ArrayList<>();
        List<Integer> tapaus8= new ArrayList<>();
        List<Integer> tapaus101= new ArrayList<>();
        List<Integer> tapaus102= new ArrayList<>();
        List<Integer> tapaus12= new ArrayList<>();
        normaali.add(0);
        normaali.add(-2);
        normaali.add(-1);
        normaali.add(1);
        normaali.add(4);
        normaali.add(2);
        normaali.add(3);
        normaali.add(5);
        normaali.add(-5);
        normaali.add(-3);
        normaali.add(-4);
        normaali.add(-6);
        tapaus2.add(0);
        tapaus2.add(2);
        tapaus4.add(0);
        tapaus4.add(-2);
        tapaus4.add(-5);
        tapaus4.add(-3);
        tapaus6.add(0);
        tapaus6.add(-2);
        tapaus6.add(-1);
        tapaus6.add(1);
        tapaus6.add(-5);
        tapaus6.add(-3);
        tapaus8.add(0);
        tapaus8.add(-2);
        tapaus8.add(-1);
        tapaus8.add(1);
        tapaus8.add(4);
        tapaus8.add(2);
        tapaus8.add(-5);
        tapaus8.add(-3);
        tapaus101.add(0);
        tapaus101.add(-2);
        tapaus101.add(-1);
        tapaus101.add(1);
        tapaus101.add(5);
        tapaus101.add(3);
        tapaus101.add(-5);
        tapaus101.add(-3);
        tapaus101.add(-4);
        tapaus101.add(-6);
        tapaus102.add(0);
        tapaus102.add(-2);
        tapaus102.add(-1);
        tapaus102.add(1);
        tapaus102.add(3);
        tapaus102.add(5);
        tapaus102.add(4);
        tapaus102.add(2);
        tapaus102.add(-5);
        tapaus102.add(-3);
        tapaus12.add(0);
        tapaus12.add(-2);
        tapaus12.add(-1);
        tapaus12.add(1);
        tapaus12.add(3);
        tapaus12.add(5);
        tapaus12.add(4);
        tapaus12.add(2);
        tapaus12.add(-5);
        tapaus12.add(-3);
        tapaus12.add(8);
        tapaus12.add(6);
        assertEquals(normaali, paikat.get(0));
        assertEquals(tapaus2, paikat.get(1));
        assertEquals(tapaus4, paikat.get(2));
        assertEquals(tapaus6, paikat.get(3));
        assertEquals(tapaus8, paikat.get(4));
        assertEquals(tapaus101, paikat.get(5));
        assertEquals(tapaus102, paikat.get(6));
        assertEquals(tapaus12, paikat.get(7));
        
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
        assertEquals(36, manageri.sitsaajienRyhmittaja.getPoydanKoko());

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
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        manageri.plassaaja.plassaa();

        List<String> nimet=new ArrayList<>();
        nimet.add("S");
        nimet.add("A");
        nimet.add("E");
        nimet.add("B");
        nimet.add("D");
        nimet.add("K");
        nimet.add("C");
        nimet.add("U");
        nimet.add("H");
        nimet.add("I");
        nimet.add("G");
        nimet.add("F");
        nimet.add("Y");
        nimet.add("J");
        nimet.add("O");
        nimet.add("V");
        nimet.add("T");
        nimet.add("AF");
        nimet.add("AA");
        nimet.add("AE");
        nimet.add("X");
        nimet.add("P");
        nimet.add("Q");
        nimet.add("R");
        nimet.add("AG");
        nimet.add("AB");
        nimet.add("L");
        nimet.add("AH");
        nimet.add("AI");
        nimet.add("AC");
        nimet.add("M");
        nimet.add("AK");
        nimet.add("AL");
        nimet.add("AD");
        nimet.add("N");
        nimet.add("AM");
        int i=0;
        for(String nimi:nimet){
            assertEquals(nimi, manageri.poyta.getPoyta().get(i).toString());
            i++;
        }
    }
}
