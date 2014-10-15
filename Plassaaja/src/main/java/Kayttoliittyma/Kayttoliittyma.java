/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.util.Scanner;
import sovelluslogiikka.SitsaajienManagerointi;
import sovelluslogiikka.sitsaajat.Sitsaaja;
import sovelluslogiikka.sitsaajat.Sukupuoli;

/**
 *
 * @author Santeri
 */
public class Kayttoliittyma {

    private Scanner lukija;
    private SitsaajienManagerointi manageri;

    public Kayttoliittyma() {
        this.lukija = new Scanner(System.in);

    }

    public void run() {

        System.out.println("\n\nk:Kyllä ja x sulkee ohjelman.\n");
        System.out.print("Tehdaanko uusi plassaus? (k/x): ");
        String komento = this.lukija.nextLine();
        switch (komento) {
            case "k":
                uusiPlassaus();
                menu();
                break;
            case "x":
                break;
            default:
                System.out.println("Vaara komento!");
                run();
                break;
        }

    }

    private void uusiPlassaus() {
        manageri = new SitsaajienManagerointi();
    }

    private void menu() {
        System.out.println("\n\n PLASSAAJA v1.0");
        System.out.println("Valitse vaihtoehto:");
        System.out.println("1. Lisaa sitsaajia");
        System.out.println("2. Plassaa");
        System.out.println("3. Lopeta");
        System.out.println("\nSitsaajia ilmoitettu: " + manageri.ilmo.getSitsaajat().size());
        System.out.print("\n> ");
        String komento = this.lukija.nextLine();
        switch (komento) {
            case "1":
                sitsaajienLisaysJaPoisto();
                break;
            case "2":
                plassaa();
                menu();
                break;
            case "3":
                return;

            default:
                System.out.println("Komentoa ei loydy!");
                menu();
                break;

        }
    }

    private void plassaa() {
        int sitsaajienMaara = manageri.ilmo.getSitsaajat().size();
        if (sitsaajienMaara % 4 != 0) {
            System.out.println("Sitsaajien maaran on oltava jaollinen neljalla!"
                    + "Lisaa tai poista sitsaajia.");
            return;
        } else {
            manageri.aveccienParittaja.plassaaAvecit();
            manageri.kaverienParittaja.paritaKaverit();
            manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
            manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
            manageri.plassaaja.plassaa();
            manageri.plassaaja.tulosta();
        }
    }

    private void sitsaajienLisaysJaPoisto() {

        System.out.println("\n\nSITSAAJIEN LISÄYS JA POISTO");
        System.out.println("1. Lisaa uusi sitsaaja");
        System.out.println("2. Poista sitsaaja");
        System.out.println("3. Näytä sitsaajat");
        System.out.println("4. Muokkaa sitsaajien tietoja");
        System.out.println("5. Palaa takaisin");
        System.out.println("\nSitsaajia ilmoitettu: " + manageri.ilmo.getSitsaajat().size());
        System.out.print("\n> ");

        String komento = this.lukija.nextLine();
        switch (komento) {
            case "1":
                lisaaUusiSitsaaja();
                sitsaajienLisaysJaPoisto();
                break;
            case "2":
                poistaSitsaajia();
                sitsaajienLisaysJaPoisto();
                break;
            case "3":
                naytaSitsaajat();
                sitsaajienLisaysJaPoisto();
                break;
            case "4":
                muokkaaSitsaajia();
                sitsaajienLisaysJaPoisto();
                break;
            case "5":
                return;

            default:
                System.out.println("Komentoa ei loydy!");
                sitsaajienLisaysJaPoisto();
                break;

        }
    }

    private void muokkaaSitsaajia() {
        System.out.println("\n\nMUOKKAA SITSAAJIA");
        System.out.println("1. Valitse sitsaaja");
        System.out.println("2. Näytä sitsaajat");
        System.out.println("3. Palaa takaisin");
        System.out.println("\nSitsaajia ilmoitettu: " + manageri.ilmo.getSitsaajat().size());
        System.out.print("\n> ");

        String komento = this.lukija.nextLine();
        switch (komento) {
            case "1":
                muokkaaSitsaajaaSitsaajanLisays();
                muokkaaSitsaajia();
                break;
            case "2":
                naytaSitsaajat();
                muokkaaSitsaajia();
                break;
            case "3":
                return;

            default:
                System.out.println("Komentoa ei loydy!");
                muokkaaSitsaajia();
                break;

        }
    }

    private void poistaSitsaajia() {
        System.out.println("\n\nPOISTA SITSAAJA");
        System.out.println("1. Poista sitsaaja");
        System.out.println("2. Näytä sitsaajat");
        System.out.println("3. Palaa takaisin");
        System.out.println("\nSitsaajia ilmoitettu: " + manageri.ilmo.getSitsaajat().size());
        System.out.print("\n> ");

        String komento = this.lukija.nextLine();
        switch (komento) {
            case "1":
                poistaSitsaaja();
                poistaSitsaajia();
                break;
            case "2":
                naytaSitsaajat();
                poistaSitsaajia();
                break;
            case "3":
                return;

            default:
                System.out.println("Komentoa ei loydy!");
                poistaSitsaajia();
                break;

        }
    }

    private void muokkaaSitsaajaaSitsaajanLisays() {
        Sitsaaja sitsaaja = etsitaanSitsaaja();
        if (sitsaaja.toString().equals("x")) {
            return;
        }
        muokkaaSitsaajaa(sitsaaja);

    }
    
    private void muokkaaSitsaajaa(Sitsaaja sitsaaja){
        System.out.println("\n\nMUOKKAUS VAIHTOEHDOT");
            System.out.println("1. Lisää, poista tai vaihda avectoive");
            System.out.println("2. Lisää, poista tai vaihda kaveritoiveita");
            System.out.println("3. Muuta nimeä");
            System.out.println("4. Vaihda sukupuolta");
            System.out.println("5. Muokkaa toisen sitsaajan tietoja");
            System.out.println("6. Palaa takaisin\n");
            System.out.println("Muokattava sitsaaja:\n");
            System.out.print(sitsaaja.toString() + ". Sukupuoli: " + sitsaaja.getSukupuoli().toString() + ". Avectoive: " + sitsaaja.getAvecToive() + ". Kaveritoiveet: ");
            for (String nimi : sitsaaja.getKaveriToive()) {
                System.out.print(nimi + ", ");
            }
            System.out.println("");
            System.out.println("\n> ");
            String komento = lukija.nextLine();
            switch (komento) {
                case "1":
                    muokkaaAvecToiveita(sitsaaja);
                    muokkaaSitsaajaa(sitsaaja);
                    break;
                case "2":
                    muokkaaKaveriToiveita(sitsaaja);
                    muokkaaSitsaajaa(sitsaaja);
                    break;
                case "3":

                case "4":

                case "5":
                    muokkaaSitsaajaaSitsaajanLisays();
                    break;
                case "6":
                    return;
                default:
                    System.out.println("Väärä komento!");
                    muokkaaSitsaajaa(sitsaaja);
                    break;

            }
    }

    private void muokkaaKaveriToiveita(Sitsaaja sitsaaja) {
        while (true) {
            System.out.println("\nMuokattava sitsaaja: \n");
            System.out.print(sitsaaja.toString() + ". Kaveritoiveet: ");
            for (String nimi : sitsaaja.getKaveriToive()) {
                System.out.print(nimi + ", ");
            }
            System.out.println("");
            System.out.println("\n1. Lisää kaveritoiveita");
            System.out.println("2. Poista kaveritoive");
            System.out.println("3. Tyhjennä kaveritoiveet");
            System.out.println("4. Palaa takaisin");
            System.out.println("> ");
            String komento = lukija.nextLine();
            if (komento.equals("4")) {
                return;
            } else if (komento.equals("2")) {
                
            } else if (komento.equals("1")) {
                
            } else if (komento.equals("3")) {
                
            } else{
                System.out.println("Väärä komento!");
            }
        }

    }

    private void muokkaaAvecToiveita(Sitsaaja sitsaaja) {
        while (true) {
            System.out.println("\nMuokattava sitsaaja: \n");
            System.out.println((sitsaaja.toString()) + ", avec: " + sitsaaja.getAvecToive());
            System.out.println("\n1. Lisää/Korvaa avectoive");
            System.out.println("2. Poista avectoive");
            System.out.println("3. Palaa takaisin");
            System.out.println("> ");
            String komento = lukija.nextLine();
            if (komento.equals("3")) {
                return;
            } else if (komento.equals("2")) {
                sitsaaja.poistaAvectoive();
            } else if (komento.equals("1")) {
                lisaaTaiKorvaaAvectoive(sitsaaja);
            } else {
                System.out.println("Väärä komento!");
            }
        }

    }

    private void lisaaTaiKorvaaAvectoive(Sitsaaja sitsaaja) {
        while (true) {
            System.out.println("\nMuokattava sitsaaja: \n");
            System.out.println((sitsaaja.toString()) + ", avec: " + sitsaaja.getAvecToive());
            System.out.println("\nJos avecilla on avectoive syöte korvaa edellisen.");
            System.out.println("x. Palaa takaisin");
            System.out.println("> ");
            String uusitoive = lukija.nextLine();
            if (uusitoive.equals("x")) {
                return;
            }
            sitsaaja.vaihdaAvectoivetta(uusitoive);
        }
    }

    private Sitsaaja etsitaanSitsaaja() {
        while (true) {
            System.out.println("\n\nSyötä sitsaajan nimi: ");
            System.out.println("x. Palaa takaisin");
            System.out.print("> ");
            String nimi = lukija.nextLine();
            Sitsaaja sitsaaja = new Sitsaaja(nimi, null);
            if (nimi.equals("x")) {
                return sitsaaja;
            } else if (manageri.ilmo.getSitsaajat().contains(sitsaaja)) {
                sitsaaja = manageri.ilmo.getSitsaajat().get(manageri.ilmo.getSitsaajat().indexOf(sitsaaja));
                return sitsaaja;
            } else {
                System.out.println("Sitsaajaa " + nimi + " ei löydetty.");
            }
        }
    }

    private void naytaSitsaajat() {
        while (true) {
            System.out.println("Sitseille ilmoitetut sitsaajat:\n\n");
            for (Sitsaaja sitsaaja : manageri.ilmo.getSitsaajat()) {
                System.out.print(sitsaaja.toString() + ". Sukupuoli: " + sitsaaja.getSukupuoli().toString() + ". Avectoive: " + sitsaaja.getAvecToive() + ". Kaveritoiveet: ");
                for (String nimi : sitsaaja.getKaveriToive()) {
                    System.out.print(nimi + ", ");
                }
                System.out.println("");
            }
            System.out.println("\n\nPalaa takaisin komennolla x");
            String komento = this.lukija.nextLine();
            if (komento.equals("x")) {
                return;
            } else {
                System.out.println("Komentoa ei loydy!");
            }
        }

    }

    private void poistaSitsaaja() {
        while (true) {
            System.out.println("\n\nAnna poistettavan sitsaajan nimi:");
            System.out.println("x. Palaa takaisin.");
            System.out.print("> ");
            String komento = this.lukija.nextLine();
            if (komento.equals("x")) {
                return;
            }
            Sitsaaja sitsaaja = new Sitsaaja(komento, null);
            if (manageri.ilmo.getSitsaajat().contains(sitsaaja)) {
                manageri.ilmo.poistaSitsaaja(sitsaaja);
                System.out.println(komento + " on poistettu sitseilta onnistuneesti!");
            } else {
                System.out.println(komento + " ei loytynyt sitseilta!");
            }
        }
    }

    private void lisaaUusiSitsaaja() {

        String nimi = annaSitsaajanNimi();

        String avecToive = annaSitsaajanAvectoive();

        Sitsaaja sitsaaja = new Sitsaaja(nimi, avecToive);

        asetaSitsaajanSukupuoli(sitsaaja);

        asetaSitsaajalleKaveritoiveet(sitsaaja);

        manageri.ilmo.lisaaSitsaaja(sitsaaja);
    }

    private void asetaSitsaajalleKaveritoiveet(Sitsaaja sitsaaja) {
        while (true) {
            System.out.println("\n\nAnna sitsaajan kaveritoiveet:");
            System.out.println("x. Lopettaa kaveritoiveiden asetuksen.");
            System.out.print("> ");
            String toive = this.lukija.nextLine();

            if (toive.equals("x")) {
                return;
            } else {
                sitsaaja.setKaveriToive(toive);
            }

        }
    }

    private String annaSitsaajanAvectoive() {
        String nimi = null;
        while (true) {
            System.out.println("\n\nAnna avectoive:");
            System.out.println("x. Jos sitsaajalla ei avectoivetta.");
            System.out.print("> ");
            String komento = this.lukija.nextLine();
            if (komento.equals("x")) {
                break;
            } else {
                nimi = komento;
                break;
            }
        }
        return nimi;
    }

    private String annaSitsaajanNimi() {
        String nimi = null;
        while (true) {
            System.out.println("\n\nAnna sitsaajan nimi:");
            System.out.print("> ");
            String komento = this.lukija.nextLine();
            if (komento.isEmpty()) {
                System.out.println("Nimi ei saa olla tyhja!");
            } else {
                nimi = komento;
                break;
            }

        }
        return nimi;
    }

    private void asetaSitsaajanSukupuoli(Sitsaaja sitsaja) {
        System.out.println("Anna sitsaajan sukupuoli:");
        System.out.println("m: Mies");
        System.out.println("n: Nainen");
        System.out.print("> ");
        String komento = this.lukija.nextLine();
        if (komento.equals("m")) {
            sitsaja.setSukupuoli(Sukupuoli.Mies);
        } else if (komento.equals("n")) {
            sitsaja.setSukupuoli(Sukupuoli.Nainen);
        } else {
            asetaSitsaajanSukupuoli(sitsaja);
        }
    }

}
