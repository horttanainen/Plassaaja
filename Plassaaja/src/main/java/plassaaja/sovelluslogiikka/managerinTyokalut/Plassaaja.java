/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plassaaja.sovelluslogiikka.managerinTyokalut;

import plassaaja.kayttoliittyma.gui.Taulukko;
import java.util.*;
import javax.swing.JFrame;
import plassaaja.sovelluslogiikka.Poyta;
import plassaaja.sovelluslogiikka.sitsaajat.Sitsaaja;
import plassaaja.sovelluslogiikka.sitsaajat.Sukupuoli;

/**
 *Plassaaja plassaa ryhmittajan ryhmittamat ja ilman kaveriporukkaa jääneet
 sitsaajat pöytään. Ryhmittäjän ryhmittämät kaveriporukat eivät vielä ole
 * plassattavassa järjestyksessä, joten plassaajan päätehtävä on järjestää
 * sitsaajat kaveriporukan sisällä oikeaan järjestykseen ja täyttää porukoiden
 * väliin jäävät raot sitsaajapareilla.
 * @author Santeri
 */
public class Plassaaja{
    /**
     * Ryhmittäjältä haetut kaveriporukat.
     */
    private List<List<Sitsaaja>> kaveriporukat;
    /**
     * Ryhmittäjä luovuttaa plassaajalle kaveriporukat ja kaverittomat sitsaajat
     * plassattavaksi.
     */
    private SitsaajienRyhmittaja ryhmittaja;
    /**
     * esiPoyta on apu attribuutti johon sitsaajat plassataan aluksi. Sitsaajat 
     * plassataan tästä lopulliseen pöytään aivan plassauksen lopuksi.
     */
    private Map<Integer,Sitsaaja> esiPoyta;
    /**
     * Poyta luokan ilmeentymä, joka sisältää arrayListin johon sitsaajat
     * plassataan.
     */
    private Poyta poyta;
    /**
     * Sitsaajat joilla ei ole vielä ryhmää. Näitä sitsaajia käytetään 
     * kaveriporukoiden väleihin.
     */
    protected List<Sitsaaja> sitsaajatIlmanRyhmaa;
    /**
     * joPlassatutSitsaajat kerää kaikki jo pöytään plassatut sitsaajat.
     */
    private List<Sitsaaja> joPlassatutSitsaajat;
    /**
     * Luo plassaajan ja liittää tähän ryhmittäjäolion ja poytaolion. 
     * @param ryhmittaja ryhmittaja josta ryhmät ja sitsaajat haetaan.
     * @param poyta Poyta johon sitsaajat plassataan.
     */
    public Plassaaja(SitsaajienRyhmittaja ryhmittaja, Poyta poyta) {
        this.ryhmittaja = ryhmittaja;
        this.kaveriporukat = new ArrayList<>();
        this.esiPoyta=new HashMap<>();
        this.poyta=poyta;
        joPlassatutSitsaajat=new ArrayList<>();
    }
    /**
     * Plassaa pöydän ja tarkistaa että sitsaajia on tarpeeksi. Vain neljällä
     * jaollisen ihmismäärän voi plassata.
     */
    public void plassaa() {
         setListat();
         if(ryhmittaja.getPoydanKoko()%4!=0){
             throw new IllegalArgumentException("Sitsaajien lukumaaran on oltava jaollinen neljalla!");
         }
         plassaaKaveriporukat();
         plassaaLoputSitsaajat();
         plassaaEsiPoytaPoydaksi();
    }
    /**
     * Asettaa plassaajalle sen kaipaamat listat: ryhmittäjän plassaamat kaveri-
     * porukat ja sitsaajat ilman kavereita.
     */
    protected void setListat(){
        this.sitsaajatIlmanRyhmaa = this.ryhmittaja.getSitsaajatIlmanKaveriporukkaa();
        this.kaveriporukat=ryhmittaja.getKaveriporukat();
    }
    
    private void plassaaEsiPoytaPoydaksi(){
        int poydanKoko = esiPoyta.size()+100;
        
        for (int i =-100; i <poydanKoko; i++) {
            Sitsaaja sitsaaja =esiPoyta.get(i);
            if(sitsaaja!=null){
            poyta.lisaaSitsaaja(sitsaaja);
            }
        }
    }
    
    private void plassaaLoputSitsaajat() {
        for(Sitsaaja sitsaaja:sitsaajatIlmanRyhmaa){
            if(onkoSitsaajaJoPlassattu(sitsaaja)) continue;
            if(haeViimeisimmanSitsaajanPaikka()%2==0){
             etsiMuodostaJaLisaaPari(1,-1);   
            }
            else{
                etsiMuodostaJaLisaaPari(1, 3);
            }
        }
    }
    
    private boolean onkoSitsaajaJoPlassattu(Sitsaaja sitsaaja){
        if (this.joPlassatutSitsaajat.contains(sitsaaja)) {
                return true;
            }
        return false;
    }
    
    private void plassaaKaveriporukat() {
        for(List<Sitsaaja> porukka:kaveriporukat){
            selvitaKaveriporukanKokoJaMuoto(porukka);
            }
    }
    
    
    private void selvitaKaveriporukanKokoJaMuoto(List<Sitsaaja> porukka) {
        int kaveriporukanKoko = porukka.size();
        porukka = jarjestaKaveriporukkaMiesNainenJarjestykseen(porukka);
        if(haeViimeisimmanSitsaajanPaikka()%2==0){
            plassaaKunPisteettomatSitsaajatLopuu(kaveriporukanKoko, porukka);
        } else{
            plassaaNormaalisti(kaveriporukanKoko, porukka);
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
    
    private void plassaaKunPisteettomatSitsaajatLopuu(int kaveriporukanKoko, List<Sitsaaja> kaveriPorukka){
        List<Integer> paikat=new ArrayList<>();
        int j=haeViimeisimmanSitsaajanPaikka();
        if(kaveriporukanKoko==2){
            paikat=muodostaPaikatKahdenErikoisTapaukselle(j+1);
        }
        if(kaveriporukanKoko==4){
            paikat=muodostaPaikatNeljanErikoistapaukselle(j+4);
        }
        if(kaveriporukanKoko==6){
            paikat=muodostaPaikatKuudenErikoistapaukselle(j+4);
        }
        if(kaveriporukanKoko==8){
            paikat=muodostaPaikatKasinErikoistapaukselle(j+4);
        }
        if(kaveriporukanKoko==10){
            paikat=muodostaPaikatKympinToiselleErikoistapaukselle(j+4);
        }
        if(kaveriporukanKoko==12){
            paikat=muodostaPaikatKahdentoistaErikoistapaukselle(j+4);
        }
        
        for (int i = 0; i < kaveriporukanKoko; i++) {
            joPlassatutSitsaajat.add(kaveriPorukka.get(i));
            esiPoyta.put(paikat.get(i), kaveriPorukka.get(i));
        }
        
    }
    
    private void plassaaNormaalisti(int kaveriporukanKoko, List<Sitsaaja> kaveriporukka) {
        boolean loytyikoPari = true;
        int suosituimmanPaikka=3;
        if(kaveriporukanKoko==10 ||kaveriporukanKoko ==12){
            suosituimmanPaikka=7;
        }
        List<Integer> paikat=new ArrayList<>();
        if(kaveriporukanKoko==10){
            loytyikoPari=etsiMuodostaJaLisaaPari(1, 3);
        }
        if(loytyikoPari==false){
            suosituimmanPaikka+=haeViimeisimmanSitsaajanPaikka();
            paikat=muodostaPaikatKympinEnsimmaiselleErikoistapaukselle(suosituimmanPaikka);
        } else{
            suosituimmanPaikka+=haeViimeisimmanSitsaajanPaikka();
            paikat=muodostaPaikatKaveriporukalle(suosituimmanPaikka);
        }
        for (int i = 0; i < kaveriporukanKoko; i++) {
            joPlassatutSitsaajat.add(kaveriporukka.get(i));
            esiPoyta.put(paikat.get(i), kaveriporukka.get(i));
        }
        if(kaveriporukanKoko==6){
            etsiMuodostaJaLisaaPari(1, -1);
        }
        if(kaveriporukanKoko==2){
            etsiMuodostaJaLisaaPari(1, -1);
        }
    }
    
    private boolean etsiMuodostaJaLisaaPari(int paikka1, int paikka2) {
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
            return true;
            }
            return false;
    }
    
    private void haeSitsaajalleAvec(Sitsaaja sitsaaja, boolean sukupuolenVaihdos) {

        for (int i = 0; i < sitsaajatIlmanRyhmaa.size(); i++) {
            Sitsaaja avec = sitsaajatIlmanRyhmaa.get(i);
            if (avec.getSukupuoli() == sitsaaja.getSukupuoli() || avec.getAvec()!=null) {
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
    /**
     * Laskee kaavan mukaan ensimmäiset 10000 miesten paikkaa sitseille.
     * Miesten paikoille plassataan luonnolisesti miehet ja poikkeustilanteissa
     * myös naisia.
     * @return Lista miesten paikoista.
     */
    protected List<Integer> miestenPaikat() {
        List<Integer> miestenPaikat = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
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
        return viimeinenPaikka;
    }
    /**
     * Tulostaa naytolle taulukon, joka sisaltaa sitsaajat oikeassa jarjestyksessa.
     */
    public void tulosta() {
        Taulukko taulukko = new Taulukko(poyta);
        taulukko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        taulukko.setSize(1000, 200);
        taulukko.setVisible(true);
        taulukko.setTitle("Poyta");
    }
    /**
     * * Palauttaa kaikille mahdollisille kaveriporukoille paikat. Tämä metodi on
     * vain testausta varten.
     * @return Lista joka sisätlää listat kaikista erikoistapauksista.
     * @param i Ryhmän suosituimman paikka.
     */
    protected List<List<Integer>> paikatTestaustaVarten(int i){
        List<List<Integer>> erikoistapaukset= new ArrayList<>();
        List<Integer> paikat;
        paikat=muodostaPaikatKaveriporukalle(i);
        erikoistapaukset.add(paikat);
        paikat=muodostaPaikatKahdenErikoisTapaukselle(i);
        erikoistapaukset.add(paikat);
        paikat=muodostaPaikatNeljanErikoistapaukselle(i);
        erikoistapaukset.add(paikat);
        paikat=muodostaPaikatKuudenErikoistapaukselle(i);
        erikoistapaukset.add(paikat);
        paikat=muodostaPaikatKasinErikoistapaukselle(i);
        erikoistapaukset.add(paikat);
        paikat=muodostaPaikatKympinEnsimmaiselleErikoistapaukselle(i);
        erikoistapaukset.add(paikat);
        paikat=muodostaPaikatKympinToiselleErikoistapaukselle(i);
        erikoistapaukset.add(paikat);
        paikat=muodostaPaikatKahdentoistaErikoistapaukselle(i);
        erikoistapaukset.add(paikat);
        return erikoistapaukset;
    }
    
    private List<Integer> muodostaPaikatKahdenErikoisTapaukselle(int i) {
        List<Integer> lista = new ArrayList<>();
        lista.add(i);       //3
        lista.add(i + 2);   //5
        return lista;
    }
    
    private List<Integer> muodostaPaikatNeljanErikoistapaukselle(int i) {
        List<Integer> lista = new ArrayList<>();
        lista.add(i);       //8
        lista.add(i - 2);   //6
        lista.add(i - 5);   //3
        lista.add(i - 3);   //5
        return lista;
    }
    
    private List<Integer> muodostaPaikatKuudenErikoistapaukselle(int i) {
        List<Integer> lista = new ArrayList<>();
        lista.add(i);       //8
        lista.add(i - 2);   //6
        lista.add(i - 1);   //7
        lista.add(i + 1);   //9
        lista.add(i - 5);   //3
        lista.add(i - 3);   //5
        return lista;
    }
    
    private List<Integer> muodostaPaikatKasinErikoistapaukselle(int i) {
        List<Integer> lista = new ArrayList<>();
        lista.add(i);       //8
        lista.add(i - 2);   //6
        lista.add(i - 1);   //7
        lista.add(i + 1);   //9
        lista.add(i + 4);   //12
        lista.add(i + 2);   //10
        lista.add(i - 5);   //3
        lista.add(i - 3);   //5
        return lista;
    }
    
    private List<Integer> muodostaPaikatKympinEnsimmaiselleErikoistapaukselle(int i) {
        List<Integer> lista = new ArrayList<>();
        lista.add(i);       //6
        lista.add(i - 2);   //4
        lista.add(i - 1);   //5
        lista.add(i + 1);   //7
        lista.add(i + 5);   //11
        lista.add(i + 3);   //9
        lista.add(i - 5);   //1
        lista.add(i - 3);   //3
        lista.add(i - 4);   //2
        lista.add(i - 6);   //0
        return lista;
    }
    
        private List<Integer> muodostaPaikatKympinToiselleErikoistapaukselle(int i) {
        List<Integer> lista = new ArrayList<>();
        lista.add(i);       //8
        lista.add(i - 2);   //6
        lista.add(i - 1);   //7
        lista.add(i + 1);   //9
        lista.add(i + 3);   //11
        lista.add(i + 5);   //13
        lista.add(i + 4);   //12
        lista.add(i + 2);   //10
        lista.add(i - 5);   //3
        lista.add(i - 3);   //5
        return lista;
    }
        
        private List<Integer> muodostaPaikatKahdentoistaErikoistapaukselle(int i) {
        List<Integer> lista = new ArrayList<>();
        lista.add(i);       //8
        lista.add(i - 2);   //6
        lista.add(i - 1);   //7
        lista.add(i + 1);   //9
        lista.add(i + 3);   //11
        lista.add(i + 5);   //13
        lista.add(i + 4);   //12
        lista.add(i + 2);   //10
        lista.add(i - 5);   //3
        lista.add(i - 3);   //5
        lista.add(i + 8);   //16
        lista.add(i + 6);   //14
        return lista;
    }
    
        private List<Integer> muodostaPaikatKaveriporukalle(int i) {
        List<Integer> lista = new ArrayList<>();
        lista.add(i);
        lista.add(i - 2);
        lista.add(i - 1);
        lista.add(i + 1);
        lista.add(i + 4);
        lista.add(i + 2);
        lista.add(i + 3);
        lista.add(i + 5);
        lista.add(i - 5);
        lista.add(i - 3);
        lista.add(i - 4);
        lista.add(i - 6);
        return lista;
    }
}
