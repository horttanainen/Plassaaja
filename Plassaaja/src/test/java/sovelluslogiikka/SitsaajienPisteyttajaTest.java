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

/**
 *
 * @author Santeri
 */
public class SitsaajienPisteyttajaTest {

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
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.kaverienParittaja.paritaKaverit();
        manageri.aveccienParittaja.plassaaAvecit();
    }

    @Test
    public void JarjestajaPisteyttaaSitsaajatOikein() {
        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
        List<Sitsaaja> lista = new ArrayList<>();
        lista.add(henkilo2);
        lista.add(henkilo4);
        lista.add(henkilo3);
        lista.add(henkilo1);
        lista.add(henkilo5);
        assertEquals(lista, manageri.sitsaajienPisteyttaja.getPisteytettyLista());
    }

    @Test
    public void loytyykoKaveritoiveistaPalauttaaTrueJosOnToiveissa() {
        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
        assertTrue(manageri.sitsaajienPisteyttaja.LoytyykoAKaveritoiveista(henkilo2, henkilo1));
    }

    @Test
    public void loytyykoKaveritoiveistaPalauttaaFalseJosEiToiveissa() {
        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
        assertFalse(manageri.sitsaajienPisteyttaja.LoytyykoAKaveritoiveista(henkilo1, henkilo3));
    }

    @Test
    public void pisteyttaakoPisteytaSitsaajaOikein() {
        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
        assertEquals(6, henkilo2.getSuosio());
    }

    @Test
    public void jakaakoJakajaSitsaajatOnnistuneesti() {
        henkilo1.setSuosio(10);
        henkilo2.setSuosio(9);
        henkilo3.setSuosio(8);
        henkilo4.setSuosio(1);
        henkilo5.setSuosio(0);
        henkilo6.setSuosio(0);
        manageri.ilmo.lisaaSitsaaja(henkilo1, henkilo2, henkilo3, henkilo4, henkilo5, henkilo6);
        manageri.sitsaajienPisteyttaja.setSitsaajaLista();
        manageri.sitsaajienPisteyttaja.jaaSitsaajatJoukkoihin();
        List<Sitsaaja> pisteytetyt = new ArrayList<>();
        List<Sitsaaja> pisteyttamattomat = new ArrayList<>();
        pisteytetyt.add(henkilo1);
        pisteytetyt.add(henkilo2);
        pisteytetyt.add(henkilo3);
        pisteytetyt.add(henkilo4);
        pisteyttamattomat.add(henkilo5);
        pisteyttamattomat.add(henkilo6);
        assertEquals(pisteytetyt, manageri.sitsaajienPisteyttaja.getPisteytettyLista());
        assertEquals(pisteyttamattomat, manageri.sitsaajienPisteyttaja.getSitsaajatJoillaEiOlePisteita());
    }

}
