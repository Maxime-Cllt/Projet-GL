package org.vanadium.controler;

import org.vanadium.interfaces.ContenantFruit;
import org.vanadium.interfaces.Fruit;
import org.vanadium.model.ContenantFruitAbstract;
import org.vanadium.model.fruit.FruitItem;
import org.vanadium.model.panier.Panier;
import org.vanadium.model.panier.PanierPleinException;
import org.vanadium.view.ModifyFruitDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class ControllerPopMenuList implements ActionListener {

    private ContenantFruitAbstract m;
    private JList list;

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
                ModifyFruitDialog dialog = new ModifyFruitDialog((FruitItem) selectedFruits.get(0));
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
