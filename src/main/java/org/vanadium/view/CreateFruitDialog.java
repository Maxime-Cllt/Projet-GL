package org.vanadium.view;

import org.vanadium.model.panier.Fruit;
import org.vanadium.model.panier.Orange;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.PrimitiveIterator;

public class CreateFruitDialog extends JDialog {
    private Fruit _fruit;

    private JComboBox<Fruit.Pays> _pays;
    private JComboBox<Fruit.Type> _type;
    private JSpinner _prix;

    private JSpinner _quantity;

    // img
    private JLabel _img;
    private JButton _ok;

    public CreateFruitDialog(JFrame parent, String title, boolean modal) {
        super(parent, title, modal);
        this.setSize(500, 200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.initComponent();
    }

    private void initComponent() {
        JPanel pan = new JPanel();

        _pays = new JComboBox<>(Fruit.Pays.values());
        _type = new JComboBox<>(Fruit.Type.values());
        _prix = new JSpinner(new SpinnerNumberModel(0.5, 0.0, 100.0, 0.1));
        _quantity = new JSpinner(new SpinnerNumberModel(1, 0.1, 10, 0.1));
        _ok = new JButton("Ajouter");

        // icon
        ImageIcon img = new ImageIcon(new Orange().getImg());
        Image image = img.getImage(); // transform it
        Image newimg = image.getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        _img = new JLabel(new ImageIcon(newimg));
        System.out.println(System.getProperty("user.dir"));


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

        this.setVisible(true);

        // change img when type change
        _type.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Type changed");
                _img.setIcon(new ImageIcon(new Orange().getImg()));
            }
        });
    }

}
