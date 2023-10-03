package org.vanadium.view;

import org.vanadium.factories.Factory;
import org.vanadium.interfaces.ContenantFruit;
import org.vanadium.model.ContenantFruitAbstract;

import javax.swing.*;
import java.awt.*;

public class SelectContenantDialog extends JDialog {
    private ContenantFruitAbstract contenantFruitAbstract;


    public SelectContenantDialog() {
        super(new Frame(),"Choisissez votre contenant", true);
        this.setSize(300, 150);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.initComponent();
    }

    private void initComponent(){
        JPanel pan = new JPanel();
        pan.setBorder(BorderFactory.createTitledBorder("Veuillez choisir un contenant"));
        pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));

        JComboBox<ContenantFruit.TypeContenant> contenant = new JComboBox<>(ContenantFruit.TypeContenant.values());
        pan.add(contenant);

        JPanel control = new JPanel();
        JButton okBouton = new JButton("OK");

        control.add(okBouton);

        this.getContentPane().add(pan, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);


        okBouton.addActionListener(e -> {
            contenantFruitAbstract = Factory.createContenantFruit((ContenantFruit.TypeContenant) contenant.getSelectedItem(), 10);
            dispose();
        });
    }


    public ContenantFruitAbstract getContenantFruitAbstract() {
        return contenantFruitAbstract;
    }
}
