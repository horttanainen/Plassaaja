/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovelluslogiikka;

/**
 *
 * @author Santeri
 */
public class SitsaajienManagerointi {
    public SitsiIlmo ilmo;
    public AveccienParittaja aveccienParittaja;
    public KaverienParittaja kaverienParittaja;
    public SitsaajienJarjestaja sitsaajienJarjestaja;
    
    public SitsaajienManagerointi(){
        this.ilmo=new SitsiIlmo();
        this.aveccienParittaja=new AveccienParittaja(ilmo);
        this.kaverienParittaja=new KaverienParittaja(ilmo);
        this.sitsaajienJarjestaja=new SitsaajienJarjestaja(ilmo);
    }
    
}
