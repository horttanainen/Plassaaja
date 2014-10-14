/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

/**
 *SitsaajienManagerointi luo kerralla kaikki sitsaajien käsittelyyn
 *tarvittavat työkalut ja niitä on helppo käyttää managerin kautta.
 * @author Santeri
 */
public class SitsaajienManagerointi {
    /**
     * Sitsi ilmo. Ilmolla voi lisätä ja poistaa sitsaajia.
     */
    public SitsiIlmo ilmo;
    /**
     * Aveccien parittaja. Parittaa avecit.
     */
    public AveccienParittaja aveccienParittaja;
    /**
     * Kaverien parittaja. Asettaa sitsaajalle hänen kaveritoiveita vastaavat
     * kaverit, jos löytyvät sitseiltä.
     */
    public KaverienParittaja kaverienParittaja;
    /**
     * Pisteyttää sitsaajat suosion perusteella.
     */
    public SitsaajienPisteyttaja sitsaajienPisteyttaja;
    /**
     * Ryhmittää sitsaajat kaveriporukoihin Pisteyttäjän tulosten ja toiveiden
     * perusteella.
     */
    public SitsaajienRyhmittaja sitsaajienRyhmittaja;
    /**
     * Plassaa sitsaajat pöytään käyttäen hyväkseen ryhmittajan luomia
     * kaveriporukoita.
     */
    public Plassaaja plassaaja;
    /**
     * Poyta. Sisaltaa Arraylistin, johon sitsaajat sijoitetaan.
     */
    public Poyta poyta;
    
    /**
     * Luo SitsaajienManagerointiolion. Manageri sisältää kaikki sitsaajien plassaukseen
     * tarvittavat työkalut. Konstruktorin kutsun yhteydessä manageri syöttää
     * kaikille "työkalu" attribuuteille niiden tarvitsemat tiedot.
     */
    public SitsaajienManagerointi(){
        this.ilmo=new SitsiIlmo();
        this.poyta=new Poyta();
        this.aveccienParittaja=new AveccienParittaja(ilmo);
        this.kaverienParittaja=new KaverienParittaja(ilmo);
        this.sitsaajienPisteyttaja=new SitsaajienPisteyttaja(ilmo);
        this.sitsaajienRyhmittaja=new SitsaajienRyhmittaja(sitsaajienPisteyttaja);
        this.plassaaja=new Plassaaja(sitsaajienRyhmittaja,poyta);
    }

}
