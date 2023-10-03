package org.vanadium.view;

import org.vanadium.controler.ControllerPopMenuList;
import org.vanadium.model.panier.Panier;

import javax.swing.*;

public class MenuFruitList extends JPopupMenu {
    private final JMenuItem deleteItem;
    private final JMenuItem modifyItem;

    private final JMenuItem boycotteItem;

    private ControllerPopMenuList c;

    public enum MenuType {
        DELETE, MODIFY, BOYCOTTE
    }


    public MenuFruitList() {
        deleteItem = new JMenuItem("Supprimer");
        modifyItem = new JMenuItem("Modifier");
        boycotteItem = new JMenuItem("Boycotter");
        add(deleteItem);
        add(modifyItem);
        add(boycotteItem);
    }

    public void setEnableMenu(MenuType type,boolean disable) {
        switch (type) {
            case DELETE -> deleteItem.setEnabled(disable);
            case MODIFY -> modifyItem.setEnabled(disable);
            case BOYCOTTE -> boycotteItem.setEnabled(disable);
        }
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
        boycotteItem.addActionListener(c);
    }
}
