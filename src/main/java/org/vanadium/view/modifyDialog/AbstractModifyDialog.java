package org.vanadium.view.modifyDialog;

import org.vanadium.model.fruit.FruitItem;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Observer;

public abstract class AbstractModifyDialog extends JDialog implements Observer {
    public AbstractModifyDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
    }

    public abstract void addControleur(ActionListener c);

    public abstract FruitItem getNewFruitItem();

    public abstract FruitItem getOldFruitItem();
}
