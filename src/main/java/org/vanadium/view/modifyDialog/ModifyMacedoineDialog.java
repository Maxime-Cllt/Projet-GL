package org.vanadium.view.modifyDialog;

import org.vanadium.controler.ControleurMainWindow;
import org.vanadium.controler.ControllerPopMenuList;
import org.vanadium.interfaces.Fruit;
import org.vanadium.model.ContenantFruitAbstract;
import org.vanadium.model.fruit.FruitItem;
import org.vanadium.view.MenuFruitList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;

public class ModifyMacedoineDialog extends AbstractModifyDialog {
    private final FruitItem _old_fruit;
    private FruitItem _new_fruit;

    private JButton inc;
    private JButton dec;
    private JList list;

    public ModifyMacedoineDialog(FruitItem fruit) {
        super((java.awt.Frame) null, true);
        _old_fruit = fruit;
        setTitle("Modifier un Fruit");
        setMinimumSize(new Dimension(500, 250));
        this.setResizable(true);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        this.initComponent();
    }

    private void initComponent(){
        this.setMinimumSize(new Dimension(500, 500));
        inc = new JButton("+");
        dec = new JButton("-");
        list = new JList();
        add(inc, BorderLayout.EAST);
        add(dec, BorderLayout.WEST);
        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.SOUTH);
        scrollPane.setViewportView(list);

        inc.setName("Plus");
        dec.setName("Moins");
        this.pack();
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    public void addControleur(ActionListener c) {
        if(inc.getActionListeners().length > 0) {
            inc.removeActionListener(inc.getActionListeners()[0]);
            dec.removeActionListener(dec.getActionListeners()[0]);
            list.removeListSelectionListener(list.getListSelectionListeners()[0]);
            list.removeMouseListener(list.getMouseListeners()[0]);
        }

        inc.addActionListener(c);
        dec.addActionListener(c);

        new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
            }
        };
        list.addListSelectionListener(ListSelectionListener -> {
            for (Object f : list.getSelectedValuesList()) {
                ((ControleurMainWindow)c).selectedFruits.add(((FruitItem) f).getFruit());
            }
        });


        list.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
                    MenuFruitList menu = new MenuFruitList();
                    menu.addControleur(new ControllerPopMenuList(list, ((ControleurMainWindow)c).getModele()));
                    if (list.getSelectedValuesList().size() > 1) {
                        menu.setEnableMenu(MenuFruitList.MenuType.BOYCOTTE, false);
                        menu.setEnableMenu(MenuFruitList.MenuType.MODIFY, false);
                    } else {
                        if (list.getSelectedValuesList().isEmpty()) {
                            menu.setEnableMenu(MenuFruitList.MenuType.DELETE, false);
                            menu.setEnableMenu(MenuFruitList.MenuType.MODIFY, false);
                        }
                    }
                    menu.show(evt.getComponent(), evt.getX(), evt.getY());
                }
            }
        });
    }

    public void update(Observable m, Object contenant) {     //This method is called whenever the observed object is changed
        System.out.println("Observer notified");
        ArrayList<FruitItem> fruits = new ArrayList<>();
        for (Fruit f : ((ContenantFruitAbstract) contenant).getFruits().keySet()) {
            fruits.add(new FruitItem(f, ((ContenantFruitAbstract) contenant).getFruits().get(f)));
        }
        list.setListData(fruits.toArray());
    }

    /**
     * @return FruitItem
     * @brief Méthode qui permet de récupérer le fruit créé
     */
    public FruitItem getNewFruitItem() {
        if (_new_fruit == null) {
            return _old_fruit;
        }
        return _new_fruit;
    }

    /**
     * @return FruitItem
     * @brief Méthode qui permet de récupérer le fruit avant modification
     */
    public FruitItem getOldFruitItem() {
        return _old_fruit;
    }
}
