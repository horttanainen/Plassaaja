/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

import GUI.Taulukko;
import java.util.*;
import javax.swing.JFrame;
import sovelluslogiikka.sitsaajat.Sitsaaja;
import sovelluslogiikka.sitsaajat.Sukupuoli;

/**
 *
 * @author Santeri
 */
public class Plassaaja {

    private SitsaajienRyhmittaja ryhmittaja;
    private List<Sitsaaja> sitsaajatryhmissa;
    private List<Sitsaaja> sitsaajatIlmanRyhmaa;
    private List<List<Sitsaaja>> kaveriporukat;
    private Poyta poyta;

    public Plassaaja(SitsaajienRyhmittaja ryhmittaja, Poyta poyta) {
        this.ryhmittaja = ryhmittaja;
        this.poyta = poyta;
    }

    public void plassaa() {
        setListat();
        if (sitsaajatryhmissa.size() + sitsaajatIlmanRyhmaa.size() % 4 != 0) {
            throw new IllegalArgumentException("Sitsaajien lukumaara on"
                    + " oltava jaollinen neljalla. Lisaa tai poista sitsaajia!");
        }
        jaaSitsaajatOmiinListoihin();
        plassaaKaveriporukat();
        plassaaLoputSitsaajat();
    }
    

    private void plassaaKaveriporukat() {
        int kaveriporukoidenLKM = kaveriporukat.size();
        for (int i = 0; i < kaveriporukoidenLKM; i++) {
            selvitaKaveriporukanKokoJaMuoto(kaveriporukat.get(i));
        }

    }

    private void plassaaLoputSitsaajat() {
        while (!sitsaajatIlmanRyhmaa.isEmpty()) {
            etsiMuodostaJaLisaaPari(1, 3);
            etsiMuodostaJaLisaaPari(2, 4);
        }
    }

    private void selvitaKaveriporukanKokoJaMuoto(List<Sitsaaja> porukka) {
        int viimeisimmanSitsaajanPaikka = this.poyta.getPoyta().indexOf(poyta.getPoyta().size() - 1);
        int kaveriporukanKoko = porukka.size();
        int suosituimmanPaikka;
        porukka = jarjestaKaveriporukkaMiesNainenJarjestykseen(porukka);

        switch (kaveriporukanKoko) {
            case 4:
                suosituimmanPaikka = viimeisimmanSitsaajanPaikka + 3;
                plassaaKaveriporukka(suosituimmanPaikka, porukka, false, false);
                break;
            case 6:
                suosituimmanPaikka = viimeisimmanSitsaajanPaikka + 3;
                plassaaKaveriporukka(suosituimmanPaikka, porukka, false, true);
                break;
            case 8:
                suosituimmanPaikka = viimeisimmanSitsaajanPaikka + 3;
                plassaaKaveriporukka(suosituimmanPaikka, porukka, false, false);
                break;
            case 10:
                suosituimmanPaikka = viimeisimmanSitsaajanPaikka + 7;
                plassaaKaveriporukka(suosituimmanPaikka, porukka, true, false);
                break;
            case 12:
                suosituimmanPaikka = viimeisimmanSitsaajanPaikka + 7;
                plassaaKaveriporukka(suosituimmanPaikka, porukka, false, false);
                break;
        }
    }

    private List<Sitsaaja> jarjestaKaveriporukkaMiesNainenJarjestykseen(List<Sitsaaja> porukka) {
        List<Sitsaaja> kaveritMNMNjarjestyksessa = new ArrayList<>();
        Sitsaaja henkilo;
        Sitsaaja avec;
        for (int i = 0; i < porukka.size() - 1;) {
            henkilo = porukka.get(i);
            avec = porukka.get(i + 1);
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
            i+=2;
        }
        return kaveritMNMNjarjestyksessa;
    }

    private void plassaaKaveriporukka(int suosituimmanpaikka, List<Sitsaaja> kaveriporukka, boolean tarvitaankoPari, boolean tarvitaankoPerallePari) {
        if (tarvitaankoPari == true) {
            etsiMuodostaJaLisaaPari(1, 3);
        }
        List<Integer> paikat = muodostaPaikatKaveriporukalle(suosituimmanpaikka);
        for (int i = 0; i < kaveriporukka.size(); i++) {
            Sitsaaja kaverus = kaveriporukka.get(i);
            int sitsaajanPaikka = paikat.get(i);
            poyta.getPoyta().add(sitsaajanPaikka, kaverus);
        }
        if (tarvitaankoPerallePari == true) {
            etsiMuodostaJaLisaaPari(5, 7);
        }
        this.kaveriporukat.remove(kaveriporukka);
    }

    private void etsiMuodostaJaLisaaPari(int paikka1, int paikka2) {
        paikka1 += poyta.getPoyta().indexOf(poyta.getPoyta().size() - 1);
        paikka2 += poyta.getPoyta().indexOf(poyta.getPoyta().size() - 1);
        Iterator<Sitsaaja> iterator = this.sitsaajatIlmanRyhmaa.iterator();
        while (iterator.hasNext()) {
            Sitsaaja next = iterator.next();
            haeSitsaajalleAvec(next, false);
            laitaPariPaikoilleen(next, next.getAvec(), paikka1, paikka2);
            sitsaajatIlmanRyhmaa.remove(next);
            sitsaajatIlmanRyhmaa.remove(next.getAvec());
            break;
        }
    }

    private void laitaPariPaikoilleen(Sitsaaja sitsaaja1, Sitsaaja sitsaaja2, int paikka1, int paikka2) {
        if (miestenPaikat().contains(paikka1)) {
            if (sitsaaja1.getSukupuoli() == Sukupuoli.Mies) {
                poyta.getPoyta().add(paikka1, sitsaaja1);
                poyta.getPoyta().add(paikka2, sitsaaja2);
            } else {
                poyta.getPoyta().add(paikka1, sitsaaja2);
                poyta.getPoyta().add(paikka2, sitsaaja1);
            }
        } else {
            if (sitsaaja1.getSukupuoli() == Sukupuoli.Mies) {
                poyta.getPoyta().add(paikka2, sitsaaja1);
                poyta.getPoyta().add(paikka1, sitsaaja2);
            } else {
                poyta.getPoyta().add(paikka2, sitsaaja2);
                poyta.getPoyta().add(paikka1, sitsaaja1);
            }
        }
    }

    private List<Integer> miestenPaikat() {
        List<Integer> miestenPaikat = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            double paikka = 0.5 * (4 * i - Math.pow(-1, i) - 3);
            int x = (int) paikka;
            miestenPaikat.add(x);
        }
        return miestenPaikat;
    }

    private void haeSitsaajalleAvec(Sitsaaja sitsaaja, boolean sukupuolenVaihdos) {
        for (int i = 0; i < sitsaajatIlmanRyhmaa.size(); i++) {
            Sitsaaja avec = sitsaajatIlmanRyhmaa.get(i);
            if (avec.getSukupuoli() == sitsaaja.getSukupuoli()) {
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

    private List<Integer> muodostaPaikatKaveriporukalle(int i) {
        List<Integer> lista = new ArrayList<>();
        lista.add(i);
        lista.add(i - 2);
        lista.add(i + 1);
        lista.add(i - 1);
        lista.add(i + 3);
        lista.add(i + 5);
        lista.add(i + 2);
        lista.add(i + 4);
        lista.add(i - 3);
        lista.add(i - 5);
        lista.add(i - 4);
        lista.add(i - 6);
        return lista;
    }

    private void setListat() {
        this.sitsaajatryhmissa = this.ryhmittaja.getRyhmitettyLista();
        this.sitsaajatIlmanRyhmaa = this.ryhmittaja.getSitsaajatIlmanKaveriporukkaa();
    }

    public void jaaSitsaajatOmiinListoihin() {
        List<Integer> katkaisukohdat = ryhmittaja.getKaveririporukoidenPaikatListassa();
        List<Sitsaaja> tmp;
        for (Integer katkaisukohta : katkaisukohdat) {
            tmp = new ArrayList<>();
            for (int i = 0; i < sitsaajatryhmissa.size(); i++) {
                if (i <= katkaisukohta && sitsaajatryhmissa.get(i) != null) {
                    tmp.add(sitsaajatryhmissa.get(i));
                    sitsaajatryhmissa.add(i, null);
                } else {
                    if (tmp.size() > 12) {
                        jaaLiianSuuriKaveriporukkaPienemmiksi(tmp);
                        break;
                    }
                    this.kaveriporukat.add(tmp);
                    break;
                }
            }
        }
    }

    private void jaaLiianSuuriKaveriporukkaPienemmiksi(List<Sitsaaja> porukka) {
        while (porukka.size() > 12) {
            Sitsaaja ylimaarainen = porukka.get(porukka.size() - 1);
            porukka.remove(ylimaarainen);
            sitsaajatIlmanRyhmaa.add(ylimaarainen);
        }
        this.kaveriporukat.add(porukka);
    }
    
    public void tulosta(){
        Taulukko taulukko =new Taulukko(poyta);
        taulukko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        taulukko.setSize(200, 1100);
        taulukko.setVisible(true);
        taulukko.setTitle("Poyta");
    }

}
