/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;
import java.util.*;
import sovelluslogiikka.sitsaajatJaPoyta.Poyta;
import sovelluslogiikka.sitsaajatJaPoyta.Sitsaaja;
import sovelluslogiikka.sitsaajatJaPoyta.Sukupuoli;

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
    
    public Plassaaja(SitsaajienRyhmittaja ryhmittaja, Poyta poyta){
        this.ryhmittaja=ryhmittaja;
        this.poyta=poyta;
    }
    
    public void plassaa(){
        if(sitsaajatryhmissa.size()+sitsaajatIlmanRyhmaa.size()%4!=0){
            throw new IllegalArgumentException("Sitsaajien lukumäärän on"
                    + " oltava jaollinen neljällä. Lisää tai poista sitsaajia!");
        }
        setListat();
        jaaSitsaajatOmiinListoihin();
        
    }
    
    private void plassaaKaveriporukat(){
        int kaveriporukoidenLKM=kaveriporukat.size();
        for (int i = 0; i < kaveriporukoidenLKM; i++) {
            selvitaKaveriporukanKokoJaMuoto(kaveriporukat.get(i));
        }
        
    }
    
    private void selvitaKaveriporukanKokoJaMuoto(List<Sitsaaja> porukka){
        Sukupuoli suosituimmanSukupuoli=porukka.get(0).getSukupuoli();
        int viimeisimmanSitsaajanPaikka=this.poyta.getPoyta().indexOf(poyta.getPoyta().size()-1);
        int kaveriporukanKoko=porukka.size();
        int suosituimmanPaikka;
        if(suosituimmanSukupuoli==Sukupuoli.Nainen){
            suosituimmanPaikka=-2;
        }
        switch(kaveriporukanKoko){
            case 4:
                suosituimmanPaikka=viimeisimmanSitsaajanPaikka+3;
                plassaaKaveriporukka(suosituimmanPaikka, porukka, false);
                break;
            case 6:
                suosituimmanPaikka=viimeisimmanSitsaajanPaikka+3;
                plassaaKaveriporukka(suosituimmanPaikka, porukka, false);
                break;
            case 8:
                suosituimmanPaikka=viimeisimmanSitsaajanPaikka+3;
                plassaaKaveriporukka(suosituimmanPaikka, porukka, false);
                break;
            case 10:
                suosituimmanPaikka=viimeisimmanSitsaajanPaikka+7;
                plassaaKaveriporukka(suosituimmanPaikka, porukka, true);
                break;
            case 12:
                suosituimmanPaikka=viimeisimmanSitsaajanPaikka+7;
                plassaaKaveriporukka(suosituimmanPaikka, porukka, false);
                break;
        }
}
    
    private void plassaaKaveriporukka(int suosituimmanpaikka, List<Sitsaaja> kaveriporukka, boolean tarvitaankoPari){
        if (tarvitaankoPari==true){
            etsiMuodostaJaLisaaPari(int paikka1,int paikka2);//paikoille 1 ja 3
        }
        List<Integer> paikat = muodostaPaikatKaveriporukalle(suosituimmanpaikka);
        
        for (int i = 0; i < kaveriporukka.size(); i++) {
            Sitsaaja kaverus=kaveriporukka.get(i);
            int sitsaajanPaikka =paikat.get(i);
//            poyta.getPoyta().add(sitsaajanPaikka,kaverus); //tämä idea mutta miehet miesten paikoille ja naiset naisten. Musita että suosituinkin voi olla nainen.
            //mitä jos järjestettäisiin jo ennen edeltävää metodia kaveriporukka mies,nainen,mies,nainen järjestykseen....
        }
        
        this.kaveriporukat.remove(kaveriporukka);
    }
    
    private List<Integer> muodostaPaikatKaveriporukalle(int i){
        List<Integer> lista = new ArrayList<>();
        lista.add(i);
        lista.add(i-2);
        lista.add(i+1);
        lista.add(i-1);
        lista.add(i+3);
        lista.add(i+5);
        lista.add(i+2);
        lista.add(i+4);
        lista.add(i-3);
        lista.add(i-5);
        lista.add(i-4);
        lista.add(i-6);
        return lista;
    }
    
    private void setListat(){
        this.sitsaajatryhmissa=this.ryhmittaja.getRyhmitettyLista();
        this.sitsaajatIlmanRyhmaa=this.ryhmittaja.getSitsaajatIlmanKaveriporukkaa();
    }
    
    public void jaaSitsaajatOmiinListoihin(){
        List<Integer> katkaisukohdat = ryhmittaja.getKaveririporukoidenPaikatListassa();
        List<Sitsaaja> tmp;
        for (Integer katkaisukohta : katkaisukohdat) {
            tmp=new ArrayList<>();
        for (int i = 0; i <sitsaajatryhmissa.size(); i++) {
            if(i<=katkaisukohta &&sitsaajatryhmissa.get(i)!=null){
                tmp.add(sitsaajatryhmissa.get(i));
                sitsaajatryhmissa.add(i, null);
            } else{
                this.kaveriporukat.add(tmp);
            }
        }
        }
    }
    
    
    
}
