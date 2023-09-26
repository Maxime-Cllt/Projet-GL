/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vanadium.controler;

import org.vanadium.model.panier.Fruit;
import org.vanadium.model.panier.Orange;
import org.vanadium.model.panier.Panier;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * @author celine
 */
public class ControleurBtn implements ActionListener {
    private Panier m;
    public ArrayList<Fruit> selectedFruits = new ArrayList<>();

    @Override
    public void actionPerformed(ActionEvent e) {   //Invoked when an action occurs
        try {
            if (((Component) e.getSource()).getName().equals("Plus"))
                m.ajout(new Orange(Math.random() * 3, Orange.randomPays()));
            else {
                if (selectedFruits.size() > 0) {
                    for (Fruit fruit : selectedFruits) {
                        m.retrait(fruit);
                    }
                    selectedFruits.clear();
                } else {
                    m.retrait();
                }
            }
        } catch (Exception ignored) {
        }
    }

    public void setModele(Panier panier) {
        this.m = panier;
    }
}
