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
            System.out.print("> ");
            String komento = this.lukija.nextLine();
            switch (komento) {
                case "1":
                    lisaaSitsaaja();
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
    
    private void plassaa(){
        int sitsaajienMaara=manageri.ilmo.getSitsaajat().size();
        if(sitsaajienMaara%4!=0){
            System.out.println("Sitsaajien maaran on oltava jaollinen neljalla!"
                    + "Lisaa tai poista sitsaajia.");
            return;
        } else{
        manageri.aveccienParittaja.plassaaAvecit();
        manageri.kaverienParittaja.paritaKaverit();
        manageri.sitsaajienPisteyttaja.pisteytaSitsaajat();
        manageri.sitsaajienRyhmittaja.ryhmitaSitsaajat();
        manageri.plassaaja.plassaa();
        manageri.plassaaja.tulosta();
    }
    }

    private void lisaaSitsaaja() {

            System.out.println("\n\nLISAA SITSAAJA");
            System.out.println("1. Lisaa uusi sitsaaja");
            System.out.println("2. poista sitsaaja");
            System.out.println("3. Palaa takaisin");
            System.out.print("> ");

            String komento = this.lukija.nextLine();
            switch (komento) {
                case "1":
                    lisaaUusiSitsaaja();
                    lisaaSitsaaja();
                    break;
                case "2":
                    poistaSitsaajia();
                       lisaaSitsaaja();
                    break;
                case "3":
                    menu();
                    return;

                default:
                    System.out.println("Komentoa ei loydy!");
                    lisaaSitsaaja();
                    break;


        }
    }
    
    private void poistaSitsaajia(){
            System.out.println("\n\nPOISTA SITSAAJA");
            System.out.println("1. Poista sitsaaja");
            System.out.println("2. Näytä sitsaajat");
            System.out.println("3. Palaa takaisin");
            System.out.print("> ");

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
    
    private void naytaSitsaajat(){
        while(true){
        System.out.println("Sitseille ilmoitetut sitsaajat:\n\n");
        for(Sitsaaja sitsaaja:manageri.ilmo.getSitsaajat()){
            System.out.println(sitsaaja.toString() + " Sukupuoli: " + sitsaaja.getSukupuoli().toString()+" Avectoive: " +sitsaaja.getAvecToive() +" Kaveritoiveet: ");
            for(String nimi:sitsaaja.getKaveriToive()){
                System.out.print(nimi+", ");
            }
            System.out.println("");
        }
        System.out.println("\n\nPalaa takaisin komennolla x");
        String komento = this.lukija.nextLine();
            switch (komento) {
                case "x":
                    return;

                default:
                    System.out.println("Komentoa ei loydy!");
                    naytaSitsaajat();
                    break;

            }
        }
        
    }
    
    private void poistaSitsaaja(){
        while (true){
        System.out.println("\n\nAnna poistettavan sitsaajan nimi:");
        System.out.println("x. Palaa takaisin.");
        System.out.print("> ");
        String komento = this.lukija.nextLine();
        if(komento.equals("x")){
            return;
        }
        Sitsaaja sitsaaja = new Sitsaaja(komento, null);
        if(manageri.ilmo.getSitsaajat().contains(sitsaaja)){
            manageri.ilmo.poistaSitsaaja(sitsaaja);
            System.out.println(komento +" on poistettu sitseilta onnistuneesti!");
        } else{
            System.out.println(komento +" ei loytynyt sitseilta!");
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
