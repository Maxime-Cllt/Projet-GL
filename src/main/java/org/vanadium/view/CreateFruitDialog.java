package org.vanadium.view;

import org.vanadium.factories.FactoryFruit;
import org.vanadium.interfaces.Fruit;
import org.vanadium.model.fruit.Orange;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.net.URL;
import java.util.Map;

public class CreateFruitDialog extends JDialog {
    private Fruit _fruit;

    private JComboBox<Fruit.Pays> _pays;
    private JComboBox<Fruit.Type> _type;
    private JSpinner _prix;
    private JSpinner _quantity;
    private JLabel _img;
    private JButton _ok;

    public CreateFruitDialog() {
        super((java.awt.Frame) null, true);
        setTitle("Ajouter un Fruit");
        setMinimumSize(new Dimension(500, 250));
        this.setResizable(true);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        this.initComponent();
    }

    private void initComponent() {
        JPanel pan = new JPanel();
        pan.setBorder(new EmptyBorder(10, 10, 10, 10));

        _pays = new JComboBox<>(Fruit.Pays.values());
        _type = new JComboBox<>(Fruit.Type.values());
        _prix = new JSpinner(new SpinnerNumberModel(0.5, 0.0, 100.0, 0.1));
        _quantity = new JSpinner(new SpinnerNumberModel(1, 0.1, 10, 0.1));
        _ok = new JButton("Ajouter");
        _ok.setName("Ajouter");

        // icon
        URL imageURL = getClass().getClassLoader().getResource(new Orange().getImg());

        if (imageURL != null) {
            ImageIcon img = new ImageIcon(imageURL);
            Image image = img.getImage(); // transform it
            Image newimg = image.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            _img = new JLabel(new ImageIcon(newimg));

            // Add _img to your Swing UI component as needed
        } else {
            System.err.println("Image not found: " + new Orange().getImg());
        }


        // for type, pays, and prix add jlabel
        JLabel typeLabel = new JLabel("Type : ");
        JLabel paysLabel = new JLabel("Pays : ");
        JLabel prixLabel = new JLabel("Prix(eur) : ");
        JLabel quantityLabel = new JLabel("Quantité(kg) : ");

        BoxLayout boxLayout = new BoxLayout(pan, BoxLayout.Y_AXIS);
        pan.setLayout(boxLayout);

        JPanel typePanel = new JPanel();
        JPanel paysPanel = new JPanel();
        JPanel prixPanel = new JPanel();
        JPanel quantityPanel = new JPanel();

        typePanel.setLayout(new BoxLayout(typePanel, BoxLayout.X_AXIS));
        paysPanel.setLayout(new BoxLayout(paysPanel, BoxLayout.X_AXIS));
        prixPanel.setLayout(new BoxLayout(prixPanel, BoxLayout.X_AXIS));
        quantityPanel.setLayout(new BoxLayout(quantityPanel, BoxLayout.X_AXIS));

        typePanel.add(typeLabel);
        typePanel.add(_type);

        paysPanel.add(paysLabel);
        paysPanel.add(_pays);

        prixPanel.add(prixLabel);
        prixPanel.add(_prix);

        quantityPanel.add(quantityLabel);
        quantityPanel.add(_quantity);

        pan.add(typePanel);
        pan.add(paysPanel);
        pan.add(prixPanel);
        pan.add(quantityPanel);
        pan.add(_img);
        pan.add(_ok);

        this.setContentPane(pan);

        // change img when type change
        _type.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                URL img1url = getClass().getClassLoader().getResource(Fruit.imgType.get(_type.getSelectedItem()));

                if (img1url != null) {
                    ImageIcon img = new ImageIcon(img1url);
                    Image image = img.getImage(); // transform it
                    Image newimg = image.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
                    _img.setIcon(new ImageIcon(newimg));

                    // Add _img to your Swing UI component as needed
                } else {
                    System.err.println("Image not found: " + new Orange().getImg());
                }
            }
        });


        _ok.addActionListener(e -> {
            _fruit = FactoryFruit.createFruit((Fruit.Type) _type.getSelectedItem());
            _fruit.setOrigine((Fruit.Pays) _pays.getSelectedItem());
            _fruit.setPrix((double) _prix.getValue());
            dispose();
        });

    }

    /**
     * @return Map.Entry<Fruit, Double>
     * @brief Méthode qui permet de récupérer le fruit créé
     */
    public Map.Entry<Fruit, Double> getFruit() {
        return Map.entry(_fruit, (double) _quantity.getValue());
    }
}
