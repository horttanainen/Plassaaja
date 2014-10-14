/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kayttoliittyma;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTable;
import sovelluslogiikka.sitsaajat.Sitsaaja;
import java.util.*;
import sovelluslogiikka.Poyta;

/**
 *
 * @author Santeri
 */
public class Taulukko extends JFrame {
    
    JTable taulukko;
    private List<Sitsaaja> sitsaajat;
    
    public Taulukko(Poyta poyta){
        setLayout(new FlowLayout());
        this.sitsaajat=poyta.getPoyta();
        String[] sarakkeidenNimet=new String[(sitsaajat.size()/2)];
        int i=0;
        String[][] data=new String[50][50];
        for (int j = 0; j < sitsaajat.size()-1;j+=2) {
            sarakkeidenNimet[i]="Paikat:"+i+ " ja "+i+1;
            data[i][i]=sitsaajat.get(j).toString();
            data[i][i+1]=sitsaajat.get(j+1).toString();
            i+=2;
        }
         taulukko=new JTable(data, sarakkeidenNimet);
         taulukko.setPreferredScrollableViewportSize(new Dimension(100,1000));
         taulukko.setFillsViewportHeight(true);
    }
    
}
