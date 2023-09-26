/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vanadium.view;

import org.vanadium.controler.ControleurBtn;
import org.vanadium.model.panier.Orange;
import org.vanadium.model.panier.Panier;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.*;

/**
 * @author celine
 */
public class MainWindow extends JFrame implements VueG {
    private JButton inc;
    private JButton dec;
    private JLabel affiche;

    private JList list;

    public MainWindow() {
        super("Fruit");
        // set Mini size
        this.setMinimumSize(new Dimension(500, 500));
        inc = new JButton("+");
        dec = new JButton("-");
        list = new JList();
        affiche = new JLabel("0", JLabel.CENTER);
        add(inc, BorderLayout.EAST);
        add(dec, BorderLayout.WEST);
        add(affiche, BorderLayout.CENTER);
        add(list, BorderLayout.SOUTH);

        inc.setName("Plus");
        dec.setName("Moins");
        affiche.setName("Affichage");
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addControleur(ControleurBtn c) {
        getInc().addActionListener(c);
        getDec().addActionListener(c);
        new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                System.out.println("Selected fruit: " + list.getSelectedValue());
            }
        };
        list.addListSelectionListener(ListSelectionListener -> {
            for (Object f : list.getSelectedValuesList()) {
                c.selectedFruits.add((Orange) f);
            }
        });
    }

    @Override
    public void update(Observable m, Object panier) {     //This method is called whenever the observed object is changed
        affiche.setText(((Panier) panier).getTaillePanier() + "");
        list.setListData(((Panier) panier).getFruits().toArray());
    }

    /**
     * @return the inc
     */
    public JButton getInc() {
        return inc;
    }

    /**
     * @param inc the inc to set
     */
    public void setInc(JButton inc) {
        this.inc = inc;
    }

    /**
     * @return the dec
     */
    public JButton getDec() {
        return dec;
    }

    /**
     * @param dec the dec to set
     */
    public void setDec(JButton dec) {
        this.dec = dec;
    }

    /**
     * @return the affiche
     */
    public JLabel getAffiche() {
        return affiche;
    }

    /**
     * @param affiche the affiche to set
     */
    public void setAffiche(JLabel affiche) {
        this.affiche = affiche;
    }

    public void setList(JList list) {
        this.list = list;
    }

    public JList getList() {
        return list;
    }
}
