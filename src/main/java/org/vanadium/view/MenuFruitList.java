package org.vanadium.view;

import org.vanadium.controler.ControllerPopMenuList;
import org.vanadium.model.panier.Panier;

import javax.swing.*;

public class MenuFruitList extends JPopupMenu {
    private final JMenuItem deleteItem;
    private final JMenuItem modifyItem;

    private ControllerPopMenuList c;


    public MenuFruitList() {
        deleteItem = new JMenuItem("Supprimer");
        modifyItem = new JMenuItem("Modifier");
        add(deleteItem);
        add(modifyItem);
    }

    public JMenuItem getDeleteItem() {
        return deleteItem;
    }

    public JMenuItem getModifyItem() {
        return modifyItem;
    }

    public void addControleur(ControllerPopMenuList c) {
        this.c = c;
        deleteItem.addActionListener(c);
        modifyItem.addActionListener(c);
    }
}
