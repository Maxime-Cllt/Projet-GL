package org.vanadium.view;

import org.vanadium.controler.ControleurMainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuBar extends JMenuBar {
    private final JMenu selectContenant;

    MainWindow parent;

    public MenuBar(MainWindow parent) {
        this.parent = parent;
        AbstractAction selectContenantAction = new AbstractAction("Select Contenant") {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectContenantDialog dialog = new SelectContenantDialog();
                dialog.setVisible(true);
                if (dialog.getContenantFruitAbstract() != null) {
                    ControleurMainWindow controleurMainWindow = new ControleurMainWindow();
                    controleurMainWindow.setModele(dialog.getContenantFruitAbstract());
                    parent.addControleur(controleurMainWindow);
                    controleurMainWindow.getModele().addObserver(parent);
                    controleurMainWindow.getModele().notifyObservers();
                }
            }
        };
        selectContenant = new JMenu("Changer de Contenant");
        selectContenant.add(selectContenantAction);
        add(selectContenant);
    }
}
