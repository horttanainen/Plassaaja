/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import Kayttoliittyma.Taulukko;
import java.util.*;
import javax.swing.JFrame;
import sovelluslogiikka.sitsaajat.Sitsaaja;
import sovelluslogiikka.sitsaajat.Sukupuoli;

/**
 *
 * @author Santeri
 */
public class Plassaaja{
    private List<List<Sitsaaja>> kaveriporukat;
    private SitsaajienRyhmittaja ryhmittaja;
    private Map<Integer,Sitsaaja> esiPoyta;
    private Poyta poyta;
    protected List<Sitsaaja> sitsaajatryhmissa;
    protected List<Sitsaaja> sitsaajatIlmanRyhmaa;
    
    public Plassaaja(SitsaajienRyhmittaja ryhmittaja, Poyta poyta) {
        this.ryhmittaja = ryhmittaja;
        this.kaveriporukat = new ArrayList<>();
        this.esiPoyta=new HashMap<>();
        this.poyta=poyta;
    }
    
    public void plassaa() {
        setListat();
         if ((sitsaajatryhmissa.size() + sitsaajatIlmanRyhmaa.size()) % 4 != 0) {
             throw new IllegalArgumentException("Sitsaajien lukumaara on"
                    + " oltava jaollinen neljalla. Lisaa tai poista sitsaajia!");
         }
         jaaSitsaajatOmiinListoihin();
         plassaaKaveriporukat();
         plassaaLoputSitsaajat();
         plassaaEsiPoytaPoydaksi();
    }
    
    protected void setListat(){
        this.sitsaajatryhmissa = this.ryhmittaja.getRyhmitettyLista();
        this.sitsaajatIlmanRyhmaa = this.ryhmittaja.getSitsaajatIlmanKaveriporukkaa();
    }
    
    private void plassaaEsiPoytaPoydaksi(){
        int poydanKoko = esiPoyta.size()+100;
        
        for (int i =0; i <poydanKoko; i++) {
            Sitsaaja sitsaaja =esiPoyta.get(i);
            if(sitsaaja!=null){
            poyta.lisaaSitsaaja(sitsaaja);
            }
        }
    }
    
    private void plassaaLoputSitsaajat() {
        while (!sitsaajatIlmanRyhmaa.isEmpty()) {
            etsiMuodostaJaLisaaPari(10, 20);
        }
    }
    
    private void plassaaKaveriporukat() {
        for(List<Sitsaaja> porukka:this.kaveriporukat){
            selvitaKaveriporukanKokoJaMuoto(porukka);
            }
    }
    
    private void selvitaKaveriporukanKokoJaMuoto(List<Sitsaaja> porukka) {
        int kaveriporukanKoko = porukka.size();
        int suosituimmanPaikka;
        porukka = jarjestaKaveriporukkaMiesNainenJarjestykseen(porukka);
 
        switch (kaveriporukanKoko) {

            case 4:
                suosituimmanPaikka = 3;
                plassaaKaveriporukka(suosituimmanPaikka, porukka, false, false);
                return;
            case 6:
                suosituimmanPaikka = 3;
                plassaaKaveriporukka(suosituimmanPaikka, porukka, false, true);
                return;
            case 8:
                suosituimmanPaikka =  3;
                plassaaKaveriporukka(suosituimmanPaikka, porukka, false, false);
                return;
            case 10:
                suosituimmanPaikka =7;
                plassaaKaveriporukka(suosituimmanPaikka, porukka, true, false);
                return;
            case 12:
                suosituimmanPaikka =7;
                plassaaKaveriporukka(suosituimmanPaikka, porukka, false, false);
                return;
        }
    }
    
    private List<Sitsaaja> jarjestaKaveriporukkaMiesNainenJarjestykseen(List<Sitsaaja> porukka) {
        List<Sitsaaja> kaveritMNMNjarjestyksessa = new ArrayList<>();
        Sitsaaja henkilo;
        Sitsaaja avec;
        for (int i = 0; i < porukka.size();i+=2) {
            henkilo = porukka.get(i);
            avec = henkilo.getAvec();
            if (henkilo.getSukupuoli() == Sukupuoli.Mies && avec.getSukupuoli() == Sukupuoli.Nainen) {
                kaveritMNMNjarjestyksessa.add(henkilo);
                kaveritMNMNjarjestyksessa.add(avec);
            } else if (henkilo.getSukupuoli() == Sukupuoli.Nainen && avec.getSukupuoli() == Sukupuoli.Mies) {
                kaveritMNMNjarjestyksessa.add(avec);
                kaveritMNMNjarjestyksessa.add(henkilo);
            } else if (henkilo.getSukupuoli() == Sukupuoli.Mies && avec.getSukupuoli() == Sukupuoli.Mies) {
                kaveritMNMNjarjestyksessa.add(henkilo);
                avec.vaihdaSukupuolta();
                kaveritMNMNjarjestyksessa.add(avec);
            } else {
                henkilo.vaihdaSukupuolta();
                kaveritMNMNjarjestyksessa.add(henkilo);
                kaveritMNMNjarjestyksessa.add(avec);
            }
        }
        return kaveritMNMNjarjestyksessa;
    }
    
    private void plassaaKaveriporukka(int suosituimmanpaikka, List<Sitsaaja> kaveriporukka, boolean tarvitaankoEteenPari, boolean tarvitaankoPerallePari) {
        suosituimmanpaikka +=haeViimeisimmanSitsaajanPaikka();
        List<Integer> paikat = muodostaPaikatKaveriporukalle(suosituimmanpaikka);
        for (int i = 0; i < kaveriporukka.size(); i++) {
            Sitsaaja kaverus=kaveriporukka.get(i);
            if(kaverus==null){
                continue;
            }
            int paikka = paikat.get(i);
            esiPoyta.put(paikka, kaverus);
            
        }
        if (tarvitaankoPerallePari == true) {
            etsiMuodostaJaLisaaPari(-1, -3);
        }
        if (tarvitaankoEteenPari == true) {
            etsiMuodostaJaLisaaPari(-7, -9);
        }
    }
    
        private List<Integer> muodostaPaikatKaveriporukalle(int i) {
        List<Integer> lista = new ArrayList<>();
        lista.add(i);
        lista.add(i - 2);
        lista.add(i - 1);
        lista.add(i + 1);
        lista.add(i + 3);
        lista.add(i + 5);
        lista.add(i + 4);
        lista.add(i + 2);
        lista.add(i - 5);
        lista.add(i - 3);
        lista.add(i - 4);
        lista.add(i - 6);
        return lista;
    }
    
    private void etsiMuodostaJaLisaaPari(int paikka1, int paikka2) {
        paikka1 += haeViimeisimmanSitsaajanPaikka();
        paikka2 += haeViimeisimmanSitsaajanPaikka();
        Collection<Sitsaaja> poydassaJoIstuvat=esiPoyta.values();
            for(Sitsaaja sitsaaja:sitsaajatIlmanRyhmaa){
                if(poydassaJoIstuvat.contains(sitsaaja)||sitsaaja==null){
                    continue;
                }
            haeSitsaajalleAvec(sitsaaja, false);
            laitaPariPaikoilleen(sitsaaja, sitsaaja.getAvec(), paikka1, paikka2);
            sitsaajatIlmanRyhmaa.remove(sitsaaja);
            sitsaajatIlmanRyhmaa.remove(sitsaaja.getAvec());
            break;
            }

    }
    
    private void haeSitsaajalleAvec(Sitsaaja sitsaaja, boolean sukupuolenVaihdos) {

        for (int i = 0; i < sitsaajatIlmanRyhmaa.size(); i++) {
            Sitsaaja avec = sitsaajatIlmanRyhmaa.get(i);
            if (avec.getSukupuoli() == sitsaaja.getSukupuoli() || avec.getAvec()!=null || avec==null) {
                if (i == sitsaajatIlmanRyhmaa.size() - 1 && sukupuolenVaihdos == false) {
                    sitsaaja.vaihdaSukupuolta();
                    haeSitsaajalleAvec(sitsaaja, true);
                    break;
                }
                continue;
            }
            sitsaaja.setAvec(avec);
            avec.setAvec(sitsaaja);
            break;
        }
 
    }
    
    private void laitaPariPaikoilleen(Sitsaaja sitsaaja1, Sitsaaja sitsaaja2, int paikka1, int paikka2) {
        if (miestenPaikat().contains(paikka1)) {
            if (sitsaaja1.getSukupuoli() == Sukupuoli.Mies) {
                esiPoyta.put(paikka1, sitsaaja1);
                esiPoyta.put(paikka2, sitsaaja2);
            } else {
                esiPoyta.put(paikka1, sitsaaja2);
                esiPoyta.put(paikka2, sitsaaja1);   
            }
        } else {
            if (sitsaaja1.getSukupuoli() == Sukupuoli.Mies) {
                esiPoyta.put(paikka2, sitsaaja1);
                esiPoyta.put(paikka1, sitsaaja2);
            } else {
                esiPoyta.put(paikka1, sitsaaja1);
                esiPoyta.put(paikka2, sitsaaja2);
            }
        }
    }
    
    protected List<Integer> miestenPaikat() {
        List<Integer> miestenPaikat = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            double paikka = 0.5 * (4 * i - Math.pow(-1, i) - 3);
            int x = (int) paikka;
            miestenPaikat.add(x);
        }
        return miestenPaikat;
    }
    
    private int haeViimeisimmanSitsaajanPaikka() {
        if(esiPoyta.keySet().isEmpty()){
            return -1;
        }
        Set<Integer> paikat = esiPoyta.keySet();
        int viimeinenPaikka=0;
        for(Integer i:paikat){
            viimeinenPaikka=Math.max(i, viimeinenPaikka);
        }
        return viimeinenPaikka+6;
    }
    
    public void jaaSitsaajatOmiinListoihin() {
        List<List<Sitsaaja>> liianPienetPorukat=new ArrayList<>();
        List<Integer> katkaisukohdat = ryhmittaja.getKaveririporukoidenPaikatListassa();
        int vanhaKatkaisuKohta = -1;
        List<Sitsaaja> tmp;
        for (Integer katkaisukohta : katkaisukohdat) {
            tmp = new ArrayList<>();
            for (int i = 0; i < sitsaajatryhmissa.size(); i++) {
                if (i <= katkaisukohta && i > vanhaKatkaisuKohta) {
                    tmp.add(sitsaajatryhmissa.get(i));
                } else if (i > katkaisukohta) {
                    if (tmp.size() > 12) {
                        jaaLiianSuuriKaveriporukkaPienemmiksi(tmp);
                        vanhaKatkaisuKohta = katkaisukohta;
                        break;
                    }
                    if(tmp.size()<4){
                        liianPienetPorukat.add(tmp);
                        vanhaKatkaisuKohta = katkaisukohta;
                        break;
                    }
                    this.kaveriporukat.add(tmp);
                    vanhaKatkaisuKohta = katkaisukohta;
                    break;
                }
            }
        }
        lisaaLiianPienetKaveriporukatToisiinsa(liianPienetPorukat);
    }
    
    private void lisaaLiianPienetKaveriporukatToisiinsa(List<List<Sitsaaja>> liianPienetPorukat){
        List<Sitsaaja> porukka=new ArrayList<>();
        for(List<Sitsaaja> kporukka:liianPienetPorukat){
            for(Sitsaaja sitsaaja:kporukka){
                porukka.add(sitsaaja);
            }
        }
        if(porukka.size()>12){
            jaaLiianSuuriKaveriporukkaPienemmiksi(porukka);
            return;
        }
        if(porukka.size()<4){
            for(Sitsaaja sitsaaja:porukka){
                sitsaajatIlmanRyhmaa.add(sitsaaja);
            }
            return;
        }
        this.kaveriporukat.add(porukka);
    }
    
    private void jaaLiianSuuriKaveriporukkaPienemmiksi(List<Sitsaaja> porukka) {
        while (porukka.size() > 12) {
            Sitsaaja ylimaarainen = porukka.get(porukka.size() - 1);
            sitsaajatIlmanRyhmaa.add(ylimaarainen);
            porukka.remove(ylimaarainen);
        }
        this.kaveriporukat.add(porukka);
    }
    
    
    public void tulosta() {
        Taulukko taulukko = new Taulukko(poyta);
        taulukko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        taulukko.setSize(800, 1100);
        taulukko.setVisible(true);
        taulukko.setTitle("Poyta");
    }
}
