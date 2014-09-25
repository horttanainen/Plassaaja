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
import static org.junit.Assert.*;
import sovelluslogiikka.sitsaajatJaPoyta.Sitsaaja;

/**
 *
 * @author Santeri
 */
public class KaverienParittajaTest {

    Sitsaaja henkilo1;
    Sitsaaja henkilo2;
    Sitsaaja henkilo3;
    Sitsaaja henkilo4;
    Sitsaaja henkilo5;
    Sitsaaja henkilo6;

    SitsaajienManagerointi manageri;


    @Before
    public void setUp() {
        henkilo1 = new Sitsaaja("Santeri H", null);
        henkilo2 = new Sitsaaja("Kake J", null);
        henkilo3 = new Sitsaaja("Pietari S", null);
        henkilo4 = new Sitsaaja("Satu H", null);
        henkilo5 = new Sitsaaja("Anna A", null);
        henkilo6 = new Sitsaaja("Joku Viela", null);
        manageri=new SitsaajienManagerointi();
        manageri.ilmo.lisaaSitsaaja(henkilo1,henkilo2,henkilo3,henkilo4,henkilo5,henkilo6);
    }

    @Test
    public void onnistunutKaverinAsetus() {
        henkilo1.setKaveriToive("Kake J", "Pietari S", "Satu H");
        Sitsaaja[] kaverit={henkilo2,henkilo3,henkilo4};
        manageri.kaverienParittaja.paritaKaverit();
        assertArrayEquals(kaverit, henkilo1.getKaverit());
    }

    @Test
    public void josKaveriaEiLoydyNiinKaveriaEiLisata() {
            henkilo1.setKaveriToive("Kake J", "Pietari S", "Satu H","Mielikuvituksen Tuote");
        Sitsaaja[] kaverit={henkilo2,henkilo3,henkilo4};
        manageri.kaverienParittaja.paritaKaverit();
        assertArrayEquals(kaverit, henkilo1.getKaverit());
    }

    @Test
    public void kaverinNimiEiOleCaseSensitive() {
        henkilo1.setKaveriToive("KAKE J", "pietari s", "SatU H");
        Sitsaaja[] kaverit={henkilo2,henkilo3,henkilo4};
        manageri.kaverienParittaja.paritaKaverit();
        assertArrayEquals(kaverit, henkilo1.getKaverit());

    }
    

}
