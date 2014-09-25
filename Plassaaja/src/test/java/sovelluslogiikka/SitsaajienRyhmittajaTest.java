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
        manageri=new SitsaajienManagerointi();
        
    }
    
//    @Test
//    public void ryhmittajaJarjestaaEnsimmaiseksiSuosituimman(){
//        henkilo1= new Sitsaaja("Matti Meikalainen", "Vilma Sutela");
//        henkilo2= new Sitsaaja("Vilma Sutela", "Matti Meikalainen");
//        henkilo3= new Sitsaaja("Kippari Kalle", "Vilma Sutela");
//        henkilo4= new Sitsaaja("Tatti Meikalainen", "Kilma Sutela");
//        henkilo5= new Sitsaaja("Kilma Sutela", "Tatti Meikalainen");
//        henkilo6= new Sitsaaja("Kuppa Kalle", "Vilma Sutela");
//        henkilo1.setKaveriToive("Vilma Sutela", "Kippari Kalle", "Tatti Meikalainen","Kilma Sutela");
//        henkilo2.setKaveriToive("Matti Meikalainen", "Tatti Meikalainen");
//        henkilo3.setKaveriToive("Vilma Sutela");
//        henkilo4.setKaveriToive("Vilma Sutela","Matti MEikalainen","Kippari kalle");
//        henkilo5.setKaveriToive("vilma sutela","kippari kalle","Tatti MEikalainen");
//        henkilo6.setKaveriToive("Vilma Sutela", "Kippari Kalle", "Tatti Meikalainen");
//        henkilo1.setSukupuoli(Sukupuoli.Mies);
//        henkilo2.setSukupuoli(Sukupuoli.Nainen);
//        henkilo3.setSukupuoli(Sukupuoli.Mies);
//        henkilo4.setSukupuoli(Sukupuoli.Mies);
//        henkilo5.setSukupuoli(Sukupuoli.Nainen);
//        henkilo6.setSukupuoli(Sukupuoli.Mies);
//        manageri.ilmo.lisaaSitsaaja(henkilo1,henkilo2,henkilo3,henkilo4,henkilo5,henkilo6);
//        manageri.kaverienParittaja.paritaKaverit();
//        manageri.aveccienParittaja.plassaaAvecit();
//        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
//        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
//        List<Sitsaaja> lista = manageri.sitsaajienRyhmittaja.getRyhmitettyLista();
//        assertEquals(henkilo2, lista.get(0));
//    }
//    
//    @Test
//    public void ryhmittajaJarjestaaToiseksiSuosituimmanAvecinJosLoytyy(){
//        henkilo1= new Sitsaaja("Matti Meikalainen", "Vilma Sutela");
//        henkilo2= new Sitsaaja("Vilma Sutela", "Matti Meikalainen");
//        henkilo3= new Sitsaaja("Kippari Kalle", "Vilma Sutela");
//        henkilo4= new Sitsaaja("Tatti Meikalainen", "Kilma Sutela");
//        henkilo5= new Sitsaaja("Kilma Sutela", "Tatti Meikalainen");
//        henkilo6= new Sitsaaja("Kuppa Kalle", "Vilma Sutela");
//        henkilo1.setKaveriToive("Vilma Sutela", "Kippari Kalle", "Tatti Meikalainen","Kilma Sutela");
//        henkilo2.setKaveriToive("Matti Meikalainen", "Tatti Meikalainen");
//        henkilo3.setKaveriToive("Vilma Sutela");
//        henkilo4.setKaveriToive("Vilma Sutela","Matti MEikalainen","Kippari kalle");
//        henkilo5.setKaveriToive("vilma sutela","kippari kalle","Tatti MEikalainen");
//        henkilo6.setKaveriToive("Vilma Sutela", "Kippari Kalle", "Tatti Meikalainen");
//        henkilo1.setSukupuoli(Sukupuoli.Mies);
//        henkilo2.setSukupuoli(Sukupuoli.Nainen);
//        henkilo3.setSukupuoli(Sukupuoli.Mies);
//        henkilo4.setSukupuoli(Sukupuoli.Mies);
//        henkilo5.setSukupuoli(Sukupuoli.Nainen);
//        henkilo6.setSukupuoli(Sukupuoli.Mies);
//        manageri.ilmo.lisaaSitsaaja(henkilo1,henkilo2,henkilo3,henkilo4,henkilo5,henkilo6);
//        manageri.kaverienParittaja.paritaKaverit();
//        manageri.aveccienParittaja.plassaaAvecit();
//        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
//        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
//        List<Sitsaaja> lista = manageri.sitsaajienRyhmittaja.getRyhmitettyLista();
//        assertEquals(henkilo1, lista.get(1));
//    }
//    
//    @Test
//    public void ryhmittajaJarjestaaToiseksiToiseksiSuosituimmanVastakkaistaSukupuoltaOlevanJosAvecEiLoydy(){
//        henkilo1= new Sitsaaja("Matti Meikalainen", "Vilma Sutela");
//        henkilo2= new Sitsaaja("Vilma Sutela", null);
//        henkilo3= new Sitsaaja("Kippari Kalle", "Vilma Sutela");
//        henkilo4= new Sitsaaja("Tatti Meikalainen", "Kilma Sutela");
//        henkilo5= new Sitsaaja("Kilma Sutela", "Tatti Meikalainen");
//        henkilo6= new Sitsaaja("Kuppa Kalle", "Vilma Sutela");
//        henkilo1.setKaveriToive("Vilma Sutela", "Kippari Kalle", "Tatti Meikalainen","Kilma Sutela");
//        henkilo2.setKaveriToive("Matti Meikalainen", "Tatti Meikalainen");
//        henkilo3.setKaveriToive("Vilma Sutela");
//        henkilo4.setKaveriToive("Vilma Sutela","Matti MEikalainen","Kippari kalle");
//        henkilo5.setKaveriToive("vilma sutela","kippari kalle","Tatti MEikalainen");
//        henkilo6.setKaveriToive("Vilma Sutela", "Kippari Kalle", "Tatti Meikalainen");
//        henkilo1.setSukupuoli(Sukupuoli.Mies);
//        henkilo2.setSukupuoli(Sukupuoli.Mies);
//        henkilo3.setSukupuoli(Sukupuoli.Mies);
//        henkilo4.setSukupuoli(Sukupuoli.Mies);
//        henkilo5.setSukupuoli(Sukupuoli.Nainen);
//        henkilo6.setSukupuoli(Sukupuoli.Mies);
//        manageri.ilmo.lisaaSitsaaja(henkilo1,henkilo2,henkilo3,henkilo4,henkilo5,henkilo6);
//        manageri.kaverienParittaja.paritaKaverit();
//        manageri.aveccienParittaja.plassaaAvecit();
//        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
//        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
//        henkilo2.setSuosio(10);
//        List<Sitsaaja> lista = manageri.sitsaajienRyhmittaja.getRyhmitettyLista();
//        assertEquals(henkilo5, lista.get(1));
//    }
    
    
//    @Test
//    public void kolmanneksiTykatyimmanJaAvecinKaveriJosTykannytMolemmista(){
//        
//    }
//    
//    @Test
//    public void kolmanneksiTykatyimmanJaAvecinKaveriJosTykannytSuosituimmastaKunMolempienKaveriaEiLoydy(){
//        
//    }
//    
//    @Test
//    public void kolmanneksiTykatyimmanJaAvecinKaveriJosTykannytAvecistaMuttaEiSuosituimmasta(){
//        
//    }
//    @Test
//    public void kolmanneksiTykatyimmanJaAvecinKaveriJokaEitykannytKummastakaan(){
//        
//    }
//    
//    @Test
//    public void kolmanneksiTykatyimmanKaveriJosTykannytMolemmista(){
//        
//    }
//    
//    @Test
//    public void kolmanneksiTykatyimmanKaveriJosTykannytSuosituimmastaKunMolempienKaveriaEiLoydy(){
//        
//    }
//    
//    @Test
//    public void kolmanneksiTykatyimmanKaveriJosTykannytAvecistaMuttaEiSuosituimmasta(){
//        
//    }
//    @Test
//    public void kolmanneksiTykatyimmanKaveriJokaEitykannytKummastakaan(){
//        
//    }
//    
//    @Test
//    public void kolmanneksiAvecinKaveriJosTykannytMolemmista(){
//        
//    }
//    
//    @Test
//    public void kolmanneksiAvecinKaveriJosTykannytSuosutuimmastaKunMolempienKaveriaEiLoydy(){
//        
//    }
//    
//    @Test
//    public void kolmanneksiAvecinKaveriJosTykannytAvecistaMuttaEiSuosituimmasta(){
//        
//    }
//    @Test
//    public void kolmanneksiAvecinKaveriJokaEitykannytKummastakaan(){
//        
//    }
//    
//    @Test
//    public void kolmanneksiSeuraavaksiSuosituinJosTykannytMolemmista(){
//        
//    }
//    
//    @Test
//    public void kolmanneksiSeuraavaksiSuosituinJosTykannytSuosituimmastaKunMolempienKaveriaEiLoydy(){
//        
//    }
//    
//    @Test
//    public void kolmanneksiSeuraavaksiSuosituinJosTykannytAvecistaMuttaEiSuosituimmasta(){
//        
//    }
//    @Test
//    public void kolmanneksiSeuraavaksiSuosituinJokaEitykannytKummastakaanTassaMyosRyhmaKatkaistaan(){
//        
//    }
    
    
}
