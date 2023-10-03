/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vanadium.view;

import org.vanadium.controler.ControleurMainWindow;
import org.vanadium.controler.ControllerPopMenuList;
import org.vanadium.interfaces.Fruit;
import org.vanadium.interfaces.VueG;
import org.vanadium.model.fruit.FruitItem;
import org.vanadium.model.panier.Panier;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy BARRANCO
 * @author Julie PRIGENT
 */
public class MainWindow extends JFrame implements VueG {
    private JButton inc;
    private JButton dec;
    private JLabel nb_fruits;
    private JLabel prix_total;

    private JLabel contenant_size;

    private JList list;

    public MainWindow() {
        super("Fruit");
        // set Mini size
        this.setMinimumSize(new Dimension(500, 500));
        inc = new JButton("+");
        dec = new JButton("-");
        list = new JList();
        add(inc, BorderLayout.EAST);
        add(dec, BorderLayout.WEST);
        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.SOUTH);
        scrollPane.setViewportView(list);
        createCentralPan();

        inc.setName("Plus");
        dec.setName("Moins");
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addControleur(ControleurMainWindow c) {
        getInc().addActionListener(c);
        getDec().addActionListener(c);
        new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
            }
        };
        list.addListSelectionListener(ListSelectionListener -> {
            for (Object f : list.getSelectedValuesList()) {
                c.selectedFruits.add(((FruitItem) f).getFruit());
            }
        });


        list.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
                    MenuFruitList menu = new MenuFruitList();
                    menu.addControleur(new ControllerPopMenuList(list, c.getModele()));
                    if(list.getSelectedValuesList().size() > 1){
                        menu.setEnableMenu(MenuFruitList.MenuType.BOYCOTTE, false);
                        menu.setEnableMenu(MenuFruitList.MenuType.MODIFY, false);
                    }
                    else{
                        if(list.getSelectedValuesList().isEmpty()){
                            menu.setEnableMenu(MenuFruitList.MenuType.DELETE, false);
                            menu.setEnableMenu(MenuFruitList.MenuType.MODIFY, false);
                        }
                    }
                    menu.show(evt.getComponent(), evt.getX(), evt.getY());
                }
            }
        });
        contenant_size.setText(c.getModele().getContenanceMax() + "");
    }

    @Override
    public void update(Observable m, Object panier) {     //This method is called whenever the observed object is changed
        prix_total.setText(((Panier) panier).getPrixTotal() + "€");
        nb_fruits.setText(((Panier) panier).getFruits().size() + "");
        ArrayList<FruitItem> fruits = new ArrayList<>();
        for (Fruit f : ((Panier) panier).getFruits().keySet()) {
            fruits.add(new FruitItem(f, ((Panier) panier).getFruits().get(f)));
        }
        list.setListData(fruits.toArray());
    }


    public JButton getInc() {
        return inc;
    }


    public void setInc(JButton inc) {
        this.inc = inc;
    }


    public JButton getDec() {
        return dec;
    }


    public void setDec(JButton dec) {
        this.dec = dec;
    }


    public void setList(JList list) {
        this.list = list;
    }

    private void createCentralPan() {
        JPanel pan = new JPanel();
        pan.setLayout(new GridLayout(3, 2));
        pan.setBorder(BorderFactory.createTitledBorder("Panier"));
        prix_total = new JLabel("0€");
        nb_fruits = new JLabel("0");
        contenant_size = new JLabel("0");

        JLabel prix_total_label = new JLabel("Prix total : ");

        pan.add(prix_total_label);
        pan.add(prix_total);

        JLabel nb_fruits_label = new JLabel("Nombre de fruits : ");

        pan.add(nb_fruits_label);
        pan.add(nb_fruits);

        JLabel contenant_size_label = new JLabel("Taille du contenant : ");

        pan.add(contenant_size_label);
        pan.add(contenant_size);

        add(pan, BorderLayout.CENTER);
    }

}
