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
    public SitsiIlmo ilmo;
    public AveccienParittaja aveccienParittaja;
    public KaverienParittaja kaverienParittaja;
    public SitsaajienPisteyttaja sitsaajienPisteyttaja;
    public SitsaajienRyhmittaja sitsaajienRyhmittaja;
    
    
    public SitsaajienManagerointi(){
        this.ilmo=new SitsiIlmo();
        this.aveccienParittaja=new AveccienParittaja();
        this.kaverienParittaja=new KaverienParittaja();
        this.sitsaajienPisteyttaja=new SitsaajienPisteyttaja();
        this.sitsaajienRyhmittaja=new SitsaajienRyhmittaja(sitsaajienPisteyttaja);
    }

}
