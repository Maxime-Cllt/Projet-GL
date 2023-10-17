package org.vanadium.controler;

import org.vanadium.interfaces.Fruit;
import org.vanadium.model.ContenantFruitAbstract;
import org.vanadium.model.Macedoine.Macedoine;
import org.vanadium.model.fruit.FruitItem;
import org.vanadium.view.modifyDialog.AbstractModifyDialog;
import org.vanadium.view.modifyDialog.ModifyFruitDialog;
import org.vanadium.view.modifyDialog.ModifyMacedoineDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class ControllerPopMenuList implements ActionListener {

    private final JList list;
    private ContenantFruitAbstract m;

    public ControllerPopMenuList(JList list, ContenantFruitAbstract m) {
        this.list = list;
        this.m = m;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (m == null) return;
        List selectedFruits = list.getSelectedValuesList();
        switch (e.getActionCommand()) {
            case "Supprimer" -> {
                for (Object o : selectedFruits) {
                    FruitItem f_item = (FruitItem) o;
                    m.retrait(f_item.getFruit());
                }
            }
            case "Modifier" -> {
                FruitItem selectedFruit = (FruitItem) selectedFruits.get(0);
                AbstractModifyDialog dialog;
                if (selectedFruit.getFruit().getClass() == Macedoine.class) {
                    dialog = new ModifyMacedoineDialog((FruitItem) selectedFruits.get(0));
                    final ControleurMainWindow controleur = new ControleurMainWindow();
                    dialog.addControleur(controleur);
                    controleur.setModele((ContenantFruitAbstract) selectedFruit.getFruit());
                } else {
                    System.out.println(selectedFruit.getFruit().getClass().getName());
                    dialog = new ModifyFruitDialog((FruitItem) selectedFruits.get(0));
                }
                dialog.setVisible(true);
                try {
                    m.retrait(dialog.getOldFruitItem().getFruit());
                    m.ajout(Map.entry(dialog.getNewFruitItem().getFruit(), dialog.getNewFruitItem().getQuantity()));
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
            case "Boycotter" -> {
                for (Object o : selectedFruits) {
                    FruitItem f_item = (FruitItem) o;
                    m.boycotteOrigine(f_item.getFruit().getOrigine());
                }
            }
        }
    }

    public void setContenantFruit(ContenantFruitAbstract m) {
        this.m = m;
    }
}
