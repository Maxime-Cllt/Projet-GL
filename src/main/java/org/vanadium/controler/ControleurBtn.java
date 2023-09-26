/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vanadium.controler;

import org.vanadium.model.panier.Fruit;
import org.vanadium.model.panier.Orange;
import org.vanadium.model.panier.Panier;
import org.vanadium.view.CreateFruitDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy Barranco
 */
public class ControleurBtn implements ActionListener {
    private Panier m;
    public ArrayList<Fruit> selectedFruits = new ArrayList<>();

    @Override
    public void actionPerformed(ActionEvent e) {   //Invoked when an action occurs
        try {
            if (((Component) e.getSource()).getName().equals("Plus")) {
                CreateFruitDialog dialog = new CreateFruitDialog(null, "Create Fruit", true);
                dialog.setVisible(true);
            } else {
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
