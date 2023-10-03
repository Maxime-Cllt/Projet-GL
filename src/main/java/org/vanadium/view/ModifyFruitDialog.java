package org.vanadium.view;

import org.vanadium.factories.Factory;
import org.vanadium.interfaces.Fruit;
import org.vanadium.model.fruit.FruitItem;
import org.vanadium.model.fruit.Orange;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.net.URL;

public class ModifyFruitDialog extends JDialog {
    private FruitItem _new_fruit;
    private final FruitItem _old_fruit;

    private JComboBox<Fruit.Pays> _pays;
    private JComboBox<Fruit.Type> _type;
    private JSpinner _prix;

    private JSpinner _quantity;

    // img
    private JLabel _img;
    private JButton _ok;

    public ModifyFruitDialog(FruitItem fruit) {
        super((java.awt.Frame) null, true);
        _old_fruit = fruit;
        setTitle("Modifier un Fruit");
        setMinimumSize(new Dimension(500, 250));
        this.setResizable(true);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        this.initComponent();
    }

    private void initComponent() {
        JPanel pan = new JPanel();
        pan.setBorder(new EmptyBorder(10, 10, 10, 10));

        _pays = new JComboBox<>(Fruit.Pays.values());
        _pays.setSelectedItem(_old_fruit.getFruit().getOrigine());
        _type = new JComboBox<>(Fruit.Type.values());
        _type.setSelectedItem(Fruit.Type.getType(_old_fruit.getFruit()));
        _prix = new JSpinner(new SpinnerNumberModel(0.5, 0.0, 100.0, 0.1));
        _prix.setValue(_old_fruit.getFruit().getPrix());
        _quantity = new JSpinner(new SpinnerNumberModel(1, 0.1, 10, 0.1));
        _quantity.setValue(_old_fruit.getQuantity());

        _ok = new JButton("Modifier");

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
                        System.out.println(Fruit.imgType.get(_type.getSelectedItem()));
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
            Fruit f = Factory.createFruit((Fruit.Type) _type.getSelectedItem());
            f.setOrigine((Fruit.Pays) _pays.getSelectedItem());
            f.setPrix((double) _prix.getValue());
            _new_fruit = new FruitItem(f, (double) _quantity.getValue());
            dispose();
        });

    }

    /**
     * @return Map.Entry<Fruit, Double>
     * @brief Méthode qui permet de récupérer le fruit créé
     */
    public FruitItem getNewFruitItem() {
        if (_new_fruit == null) {
            return _old_fruit;
        }
        return _new_fruit;
    }

    public FruitItem getOldFruitItem() {
        return _old_fruit;
    }
}
