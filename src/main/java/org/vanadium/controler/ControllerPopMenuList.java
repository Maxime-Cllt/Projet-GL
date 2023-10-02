package org.vanadium.controler;

import org.vanadium.interfaces.Fruit;
import org.vanadium.model.fruit.FruitItem;
import org.vanadium.model.panier.Panier;
import org.vanadium.model.panier.PanierPleinException;
import org.vanadium.view.ModifyFruitDialog;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerPopMenuList implements ActionListener {

    private Panier m;
    private JList list;

    public ControllerPopMenuList(JList list, Panier m) {
        this.list = list;
        this.m = m;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (m == null) return;
        FruitItem f_item = ((FruitItem) list.getSelectedValue());
        Fruit f = f_item.getFruit();
        switch (e.getActionCommand()) {
            case "Supprimer":
                m.retrait(f);
                break;
            case "Modifier":
                ModifyFruitDialog dialog = new ModifyFruitDialog(f_item);
                dialog.setVisible(true);
                try {
                    m.retrait(dialog.getOldFruitItem().getFruit());
                    m.modifierFruit(f_item.getFruit(), f_item.getQuantity());
                } catch (PanierPleinException ex) {
                    throw new RuntimeException(ex);
                }
                break;
        }


    }

    public void setPanier(Panier m) {
        this.m = m;
    }
}
