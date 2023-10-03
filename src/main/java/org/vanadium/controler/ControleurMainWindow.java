/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vanadium.controler;

import org.vanadium.interfaces.ContenantFruit;
import org.vanadium.interfaces.Fruit;
import org.vanadium.model.ContenantFruitAbstract;
import org.vanadium.view.CreateFruitDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy BARRANCO
 * @author Julie PRIGENT
 */
public class ControleurMainWindow implements ActionListener {
    public ArrayList<Fruit> selectedFruits = new ArrayList<>();
    private ContenantFruitAbstract m;

    @Override
    public void actionPerformed(ActionEvent e) {   //Invoked when an action occurs
        try {
            if (((Component) e.getSource()).getName().equals("Plus")) {
                CreateFruitDialog dialog = new CreateFruitDialog();
                dialog.setVisible(true);
                m.ajout(dialog.getFruit());
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
        } catch (Exception q) {
            JOptionPane.showMessageDialog(null,
                    q.getMessage(),
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setModele(ContenantFruitAbstract contenantFruit) {
        this.m = contenantFruit;
    }

    public ContenantFruitAbstract getModele() {
        return m;
    }
}
