package org.vanadium.view;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class MenuFruitList extends JPopupMenu {
    private JMenuItem deleteItem;
    private JMenuItem modifyItem;

    public MenuFruitList(MouseEvent e) {
        deleteItem = new JMenuItem("Supprimer");
        modifyItem = new JMenuItem("Modifier");
        add(deleteItem);
        add(modifyItem);
        addListeners();
    }

    public JMenuItem getDeleteItem() {
        return deleteItem;
    }

    public JMenuItem getModifyItem() {
        return modifyItem;
    }

    private void addListeners() {
        deleteItem.addActionListener(e -> {

        });
        modifyItem.addActionListener(e -> {
            // TODO
        });
    }
}
