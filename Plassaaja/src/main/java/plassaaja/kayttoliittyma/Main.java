package plassaaja.kayttoliittyma;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import plassaaja.sovelluslogiikka.sitsaajat.Sitsaaja;
import plassaaja.sovelluslogiikka.managerinTyokalut.AveccienParittaja;
import plassaaja.sovelluslogiikka.SitsaajienManagerointi;
import plassaaja.sovelluslogiikka.managerinTyokalut.SitsiIlmo;
import plassaaja.sovelluslogiikka.sitsaajat.Sukupuoli;

/**
 * Main. Luo käyttöliittymän ja käynnistää sen.
 *
 */
public class Main {

    public static void main(String[] args) {
        Kayttoliittyma kayttis=new Kayttoliittyma();
        kayttis.run();
}
}
