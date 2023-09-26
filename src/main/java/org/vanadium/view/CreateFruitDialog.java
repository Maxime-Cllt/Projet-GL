package org.vanadium.view;

import org.vanadium.model.panier.Fruit;

import javax.swing.*;

public class CreateFruitDialog extends JDialog {
    private Fruit fruit;

    public CreateFruitDialog(JFrame parent, String title, boolean modal) {
        super(parent, title, modal);
        this.setSize(300, 80);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.initComponent();
    }

    private void initComponent() {

    }

}
