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
import javax.swing.JScrollPane;
import javax.swing.table.TableColumn;
import sovelluslogiikka.Poyta;

/**
 *
 * @author Santeri
 */
public class Taulukko extends JFrame {

    JTable taulukko;
    private List<Sitsaaja> sitsaajat;

    public Taulukko(Poyta poyta) {
        setLayout(new FlowLayout());
        this.sitsaajat = poyta.getPoyta();
        Iterator<Sitsaaja> iteraattori=sitsaajat.iterator();
        int cols = sitsaajat.size() / 2;
        String[] sarakkeidenNimet = new String[cols];
        int rows = 2;
        int nimet=0;
        String[][] data = new String[rows][cols];
        for (int i = 0; i < cols; i++) {
            sarakkeidenNimet[i]="Sitsaajat "+nimet+" ja "+(nimet+1);
            nimet+=2;
            for (int j = 0; j < rows; j++) {
                String sitsaajanNimi=iteraattori.next().toString();
                data[j][i] = sitsaajanNimi;
            }
        }
        
        taulukko = new JTable(data, sarakkeidenNimet);
        taulukko.setPreferredScrollableViewportSize(new Dimension(900, 100));
        taulukko.setFillsViewportHeight(true);
        JScrollPane scrollpane = new JScrollPane(taulukko);
        add(scrollpane);
    }

}
