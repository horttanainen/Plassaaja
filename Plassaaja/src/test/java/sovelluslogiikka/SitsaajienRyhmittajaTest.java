/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
import sovelluslogiikka.sitsaajatJaPoyta.Sitsaaja;
import sovelluslogiikka.sitsaajatJaPoyta.Sukupuoli;

/**
 *
 * @author Santeri
 */
public class SitsaajienRyhmittajaTest {

    SitsaajienManagerointi manageri;
    Sitsaaja henkilo1;
    Sitsaaja henkilo2;
    Sitsaaja henkilo3;
    Sitsaaja henkilo4;
    Sitsaaja henkilo5;
    Sitsaaja henkilo6;

    @Before
    public void setUp() {
        manageri = new SitsaajienManagerointi();

    }

    @Test
    public void ryhmittajaJarjestaaEnsimmaiseksiSuosituimman() {
        henkilo1 = new Sitsaaja("Matti Meikalainen", "Vilma Sutela");
        henkilo2 = new Sitsaaja("Vilma Sutela", "Matti Meikalainen");
        henkilo3 = new Sitsaaja("Kippari Kalle", "Vilma Sutela");
        henkilo4 = new Sitsaaja("Tatti Meikalainen", "Kilma Sutela");
        henkilo5 = new Sitsaaja("Kilma Sutela", "Tatti Meikalainen");
        henkilo6 = new Sitsaaja("Kuppa Kalle", "Vilma Sutela");
        henkilo1.setKaveriToive("Vilma Sutela", "Kippari Kalle", "Tatti Meikalainen", "Kilma Sutela");
        henkilo2.setKaveriToive("Matti Meikalainen", "Tatti Meikalainen");
        henkilo3.setKaveriToive("Vilma Sutela");
        henkilo4.setKaveriToive("Vilma Sutela", "Matti MEikalainen", "Kippari kalle");
        henkilo5.setKaveriToive("vilma sutela", "kippari kalle", "Tatti MEikalainen");
        henkilo6.setKaveriToive("Vilma Sutela", "Kippari Kalle", "Tatti Meikalainen");
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.kaverienParittaja.paritaKaverit();
        manageri.aveccienParittaja.plassaaAvecit();
        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        List<Sitsaaja> lista = manageri.sitsaajienRyhmittaja.getRyhmitettyLista();
        assertEquals(henkilo2, lista.get(0));
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo2,henkilo1));
    }

    @Test
    public void ryhmittajaJarjestaaToiseksiSuosituimmanAvecinJosLoytyy() {
        henkilo1 = new Sitsaaja("Matti Meikalainen", "Vilma Sutela");
        henkilo2 = new Sitsaaja("Vilma Sutela", "Matti Meikalainen");
        henkilo3 = new Sitsaaja("Kippari Kalle", "Vilma Sutela");
        henkilo4 = new Sitsaaja("Tatti Meikalainen", "Kilma Sutela");
        henkilo5 = new Sitsaaja("Kilma Sutela", "Tatti Meikalainen");
        henkilo6 = new Sitsaaja("Kuppa Kalle", "Vilma Sutela");
        henkilo1.setKaveriToive("Vilma Sutela", "Kippari Kalle", "Tatti Meikalainen", "Kilma Sutela");
        henkilo2.setKaveriToive("Matti Meikalainen", "Tatti Meikalainen");
        henkilo3.setKaveriToive("Vilma Sutela");
        henkilo4.setKaveriToive("Vilma Sutela", "Matti MEikalainen", "Kippari kalle");
        henkilo5.setKaveriToive("vilma sutela", "kippari kalle", "Tatti MEikalainen");
        henkilo6.setKaveriToive("Vilma Sutela", "Kippari Kalle", "Tatti Meikalainen");
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.kaverienParittaja.paritaKaverit();
        manageri.aveccienParittaja.plassaaAvecit();
        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        List<Sitsaaja> lista = manageri.sitsaajienRyhmittaja.getRyhmitettyLista();
        assertEquals(henkilo1, lista.get(1));
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo1,henkilo2));
    }

    @Test
    public void ryhmittajaJarjestaaToiseksiToiseksiSuosituimmanVastakkaistaSukupuoltaOlevanJosAvecEiLoydy() {
        henkilo1 = new Sitsaaja("Matti Meikalainen", null);
        henkilo2 = new Sitsaaja("Vilma Sutela", null);
        henkilo3 = new Sitsaaja("Kippari Kalle", null);
        henkilo4 = new Sitsaaja("Tatti Meikalainen", null);
        henkilo5 = new Sitsaaja("Kilma Sutela", null);
        henkilo6 = new Sitsaaja("Kuppa Kalle", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Mies);
        henkilo3.setSukupuoli(Sukupuoli.Nainen);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(8);
        henkilo3.setSuosio(5);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        List<Sitsaaja> lista = manageri.sitsaajienRyhmittaja.getRyhmitettyLista();
        assertEquals(henkilo3, lista.get(1));
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo3, henkilo1));
    }

    @Test
    public void kolmanneksiTykatyimmanJaAvecinKaveriJosTykannytMolemmista() {
        henkilo1 = new Sitsaaja("M M", null);
        henkilo2 = new Sitsaaja("V S", null);
        henkilo3 = new Sitsaaja("K K", null);
        henkilo4 = new Sitsaaja("T M", null);
        henkilo5 = new Sitsaaja("K S", null);
        henkilo6 = new Sitsaaja("K T", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(8);
        henkilo3.setSuosio(5);
        henkilo4.setSuosio(9);
        henkilo5.setSuosio(4);
        henkilo1.setKaveri(henkilo6,henkilo3,henkilo5);
        henkilo2.setKaveri(henkilo6,henkilo3);
        henkilo3.setKaveri(henkilo1, henkilo2);
        henkilo5.setKaveri(henkilo1,henkilo2);
        henkilo6.setKaveri(henkilo1, henkilo2);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        assertEquals(henkilo3, manageri.sitsaajienRyhmittaja.getRyhmitettyLista().get(2));
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo3,henkilo5));
    }

    @Test
    public void kolmanneksiTykatyimmanJaAvecinKaveriJosTykannytSuosituimmastaKunMolempienKaveriaEiLoydy() {
        henkilo1 = new Sitsaaja("M M", null);
        henkilo2 = new Sitsaaja("V S", null);
        henkilo3 = new Sitsaaja("K K", null);
        henkilo4 = new Sitsaaja("T M", null);
        henkilo5 = new Sitsaaja("K S", null);
        henkilo6 = new Sitsaaja("K T", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(8);
        henkilo3.setSuosio(5);
        henkilo4.setSuosio(9);
        henkilo5.setSuosio(4);
        henkilo1.setKaveri(henkilo3,henkilo4,henkilo5,henkilo6);
        henkilo2.setKaveri(henkilo3,henkilo4,henkilo5,henkilo6);
        henkilo3.setKaveri(henkilo1);
        henkilo4.setKaveri(henkilo1);
        henkilo6.setKaveri(henkilo2);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        assertEquals(henkilo4, manageri.sitsaajienRyhmittaja.getRyhmitettyLista().get(2));
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo4,henkilo5));
    }

    @Test
    public void kolmanneksiTykatyimmanJaAvecinKaveriJosTykannytAvecistaMuttaEiSuosituimmasta() {
        henkilo1 = new Sitsaaja("M M", null);
        henkilo2 = new Sitsaaja("V S", null);
        henkilo3 = new Sitsaaja("K K", null);
        henkilo4 = new Sitsaaja("T M", null);
        henkilo5 = new Sitsaaja("K S", null);
        henkilo6 = new Sitsaaja("K T", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(8);
        henkilo3.setSuosio(5);
        henkilo4.setSuosio(9);
        henkilo5.setSuosio(4);
        henkilo6.setSuosio(6);
        henkilo1.setKaveri(henkilo6);
        henkilo2.setKaveri(henkilo6);
        henkilo3.setKaveri(henkilo1, henkilo2);
        henkilo6.setKaveri(henkilo2);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        assertEquals(henkilo6, manageri.sitsaajienRyhmittaja.getRyhmitettyLista().get(2));
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo6,henkilo5));

    }

    @Test
    public void kolmanneksiTykatyimmanJaAvecinKaveriJokaEitykannytKummastakaan() {
        henkilo1 = new Sitsaaja("M M", null);
        henkilo2 = new Sitsaaja("V S", null);
        henkilo3 = new Sitsaaja("K K", null);
        henkilo4 = new Sitsaaja("T M", null);
        henkilo5 = new Sitsaaja("K S", null);
        henkilo6 = new Sitsaaja("K T", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(8);
        henkilo3.setSuosio(5);
        henkilo4.setSuosio(9);
        henkilo5.setSuosio(4);
        henkilo6.setSuosio(6);
        henkilo1.setKaveri(henkilo4);
        henkilo2.setKaveri(henkilo4);
        henkilo3.setKaveri(henkilo1, henkilo2);
        henkilo6.setKaveri(henkilo2);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        assertEquals(henkilo4, manageri.sitsaajienRyhmittaja.getRyhmitettyLista().get(2));
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo4,henkilo5));
    }
    
    @Test
    public void kolmanneksiTykatyimmanKaveriJosTykannytMolemmista(){
        henkilo1 = new Sitsaaja("M M", null);
        henkilo2 = new Sitsaaja("V S", null);
        henkilo3 = new Sitsaaja("K K", null);
        henkilo4 = new Sitsaaja("T M", null);
        henkilo5 = new Sitsaaja("K S", null);
        henkilo6 = new Sitsaaja("K T", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(8);
        henkilo3.setSuosio(5);
        henkilo4.setSuosio(9);
        henkilo5.setSuosio(4);
        henkilo6.setSuosio(6);
        henkilo1.setKaveri(henkilo3,henkilo4,henkilo5,henkilo6);
        henkilo5.setKaveri(henkilo1,henkilo2);
        henkilo3.setKaveri(henkilo1, henkilo2);
        henkilo6.setKaveri(henkilo2);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        assertEquals(henkilo3, manageri.sitsaajienRyhmittaja.getRyhmitettyLista().get(2));
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo3,henkilo5));
    }
    
    @Test
    public void kolmanneksiTykatyimmanKaveriJosTykannytSuosituimmastaKunMolempienKaveriaEiLoydy(){
         henkilo1 = new Sitsaaja("M M", null);
        henkilo2 = new Sitsaaja("V S", null);
        henkilo3 = new Sitsaaja("K K", null);
        henkilo4 = new Sitsaaja("T M", null);
        henkilo5 = new Sitsaaja("K S", null);
        henkilo6 = new Sitsaaja("K T", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(8);
        henkilo3.setSuosio(5);
        henkilo4.setSuosio(9);
        henkilo5.setSuosio(4);
        henkilo6.setSuosio(6);
        henkilo1.setKaveri(henkilo3,henkilo4,henkilo5,henkilo6);
        henkilo5.setKaveri(henkilo1);
        henkilo3.setKaveri(henkilo2);
        henkilo6.setKaveri(henkilo2);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        assertEquals(henkilo5, manageri.sitsaajienRyhmittaja.getRyhmitettyLista().get(2));
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo2,henkilo1));
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo4,henkilo5));
    }
    
    @Test
    public void kolmanneksiTykatyimmanKaveriJosTykannytAvecistaMuttaEiSuosituimmasta(){
                 henkilo1 = new Sitsaaja("M M", null);
        henkilo2 = new Sitsaaja("V S", null);
        henkilo3 = new Sitsaaja("K K", null);
        henkilo4 = new Sitsaaja("T M", null);
        henkilo5 = new Sitsaaja("K S", null);
        henkilo6 = new Sitsaaja("K T", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(8);
        henkilo3.setSuosio(5);
        henkilo4.setSuosio(9);
        henkilo5.setSuosio(4);
        henkilo6.setSuosio(6);
        henkilo1.setKaveri(henkilo3,henkilo4,henkilo5,henkilo6);
        henkilo3.setKaveri(henkilo2);
        henkilo6.setKaveri(henkilo2);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        assertEquals(henkilo6, manageri.sitsaajienRyhmittaja.getRyhmitettyLista().get(2));
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo6,henkilo5));
    }
    @Test
    public void kolmanneksiTykatyimmanKaveriJokaEitykannytKummastakaan(){
        henkilo1 = new Sitsaaja("M M", null);
        henkilo2 = new Sitsaaja("V S", null);
        henkilo3 = new Sitsaaja("K K", null);
        henkilo4 = new Sitsaaja("T M", null);
        henkilo5 = new Sitsaaja("K S", null);
        henkilo6 = new Sitsaaja("K T", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(8);
        henkilo3.setSuosio(5);
        henkilo4.setSuosio(9);
        henkilo5.setSuosio(4);
        henkilo6.setSuosio(6);
        henkilo1.setKaveri(henkilo3,henkilo4,henkilo5,henkilo6);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        assertEquals(henkilo4, manageri.sitsaajienRyhmittaja.getRyhmitettyLista().get(2));
    }
    
    @Test
    public void kolmanneksiAvecinKaveriJosTykannytMolemmista(){
        henkilo1 = new Sitsaaja("M M", null);
        henkilo2 = new Sitsaaja("V S", null);
        henkilo3 = new Sitsaaja("K K", null);
        henkilo4 = new Sitsaaja("T M", null);
        henkilo5 = new Sitsaaja("K S", null);
        henkilo6 = new Sitsaaja("K T", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(9);
        henkilo3.setSuosio(7);
        henkilo4.setSuosio(6);
        henkilo6.setSuosio(1);
        henkilo2.setKaveri(henkilo3,henkilo4,henkilo5,henkilo6);
        henkilo3.setKaveri(henkilo2);
        henkilo6.setKaveri(henkilo2,henkilo1);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        assertEquals(henkilo6, manageri.sitsaajienRyhmittaja.getRyhmitettyLista().get(2));
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo6,henkilo5));
    }
    
    @Test
    public void kolmanneksiAvecinKaveriJosTykannytSuosituimmastaKunMolempienKaveriaEiLoydy(){
        henkilo1 = new Sitsaaja("M M", null);
        henkilo2 = new Sitsaaja("V S", null);
        henkilo3 = new Sitsaaja("K K", null);
        henkilo4 = new Sitsaaja("T M", null);
        henkilo5 = new Sitsaaja("K S", null);
        henkilo6 = new Sitsaaja("K T", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(9);
        henkilo3.setSuosio(7);
        henkilo4.setSuosio(6);
        henkilo6.setSuosio(1);
        henkilo2.setKaveri(henkilo3,henkilo4,henkilo5,henkilo6);
        henkilo5.setKaveri(henkilo1);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        assertEquals(henkilo5, manageri.sitsaajienRyhmittaja.getRyhmitettyLista().get(2));
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo3,henkilo5));
    }
    
    @Test
    public void kolmanneksiAvecinKaveriJosTykannytAvecistaMuttaEiSuosituimmasta(){
        henkilo1 = new Sitsaaja("M M", null);
        henkilo2 = new Sitsaaja("V S", null);
        henkilo3 = new Sitsaaja("K K", null);
        henkilo4 = new Sitsaaja("T M", null);
        henkilo5 = new Sitsaaja("K S", null);
        henkilo6 = new Sitsaaja("K T", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(9);
        henkilo3.setSuosio(7);
        henkilo4.setSuosio(6);
        henkilo2.setKaveri(henkilo3,henkilo4,henkilo5,henkilo6);
        henkilo5.setKaveri(henkilo2);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        assertEquals(henkilo5, manageri.sitsaajienRyhmittaja.getRyhmitettyLista().get(2));
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo3,henkilo5));
    }
    @Test
    public void kolmanneksiAvecinKaveriJokaEitykannytKummastakaan(){
        henkilo1 = new Sitsaaja("M M", null);
        henkilo2 = new Sitsaaja("V S", null);
        henkilo3 = new Sitsaaja("K K", null);
        henkilo4 = new Sitsaaja("T M", null);
        henkilo5 = new Sitsaaja("K S", null);
        henkilo6 = new Sitsaaja("K T", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(9);
        henkilo3.setSuosio(7);
        henkilo4.setSuosio(6);
        henkilo5.setAvec(henkilo6);
        henkilo6.setAvec(henkilo5);
        henkilo2.setKaveri(henkilo3,henkilo4,henkilo5,henkilo6);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        assertEquals(henkilo3, manageri.sitsaajienRyhmittaja.getRyhmitettyLista().get(2));
        assertTrue(manageri.aveccienParittaja.ovatkoAvecit(henkilo3,henkilo4));
    }
  

    @Test
    public void kolmanneksiSeuraavaksiSuosituinJosTykannytMolemmista() {
        henkilo1 = new Sitsaaja("M M", null);
        henkilo2 = new Sitsaaja("V S", null);
        henkilo3 = new Sitsaaja("K K", null);
        henkilo4 = new Sitsaaja("T M", null);
        henkilo5 = new Sitsaaja("K S", null);
        henkilo6 = new Sitsaaja("K T", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(8);
        henkilo3.setSuosio(5);
        henkilo4.setSuosio(9);
        henkilo5.setSuosio(4);
        henkilo6.setKaveri(henkilo1, henkilo2);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        assertEquals(henkilo6, manageri.sitsaajienRyhmittaja.getRyhmitettyLista().get(2));

    }
    
    @Test
    public void kolmanneksiSeuraavaksiSuosituinJosTykannytSuosituimmastaKunMolempienKaveriaEiLoydy(){
        henkilo1 = new Sitsaaja("M M", null);
        henkilo2 = new Sitsaaja("V S", null);
        henkilo3 = new Sitsaaja("K K", null);
        henkilo4 = new Sitsaaja("T M", null);
        henkilo5 = new Sitsaaja("K S", null);
        henkilo6 = new Sitsaaja("K T", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(8);
        henkilo4.setSuosio(9);
        henkilo5.setSuosio(4);
        henkilo3.setKaveri(henkilo1);
        henkilo6.setKaveri(henkilo2);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        assertEquals(henkilo3, manageri.sitsaajienRyhmittaja.getRyhmitettyLista().get(2));
    }
    
    @Test
    public void kolmanneksiSeuraavaksiSuosituinJosTykannytAvecistaMuttaEiSuosituimmasta(){
        henkilo1 = new Sitsaaja("M M", null);
        henkilo2 = new Sitsaaja("V S", null);
        henkilo3 = new Sitsaaja("K K", null);
        henkilo4 = new Sitsaaja("T M", null);
        henkilo5 = new Sitsaaja("K S", null);
        henkilo6 = new Sitsaaja("K T", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(8);
        henkilo4.setSuosio(9);
        henkilo5.setSuosio(4);
        henkilo3.setKaveri(henkilo2);
        henkilo6.setKaveri(henkilo2);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        assertEquals(henkilo3, manageri.sitsaajienRyhmittaja.getRyhmitettyLista().get(2));
    }
    @Test
    public void kolmanneksiSeuraavaksiSuosituinJokaEitykannytKummastakaan(){
        henkilo1 = new Sitsaaja("M M", null);
        henkilo2 = new Sitsaaja("V S", null);
        henkilo3 = new Sitsaaja("K K", null);
        henkilo4 = new Sitsaaja("T M", null);
        henkilo5 = new Sitsaaja("K S", null);
        henkilo6 = new Sitsaaja("K T", null);
        henkilo1.setSukupuoli(Sukupuoli.Mies);
        henkilo2.setSukupuoli(Sukupuoli.Nainen);
        henkilo3.setSukupuoli(Sukupuoli.Mies);
        henkilo4.setSukupuoli(Sukupuoli.Mies);
        henkilo5.setSukupuoli(Sukupuoli.Nainen);
        henkilo6.setSukupuoli(Sukupuoli.Mies);
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(8);
        henkilo4.setSuosio(9);
        henkilo5.setSuosio(4);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        assertEquals(henkilo4, manageri.sitsaajienRyhmittaja.getRyhmitettyLista().get(2));
    }
    
    

}
