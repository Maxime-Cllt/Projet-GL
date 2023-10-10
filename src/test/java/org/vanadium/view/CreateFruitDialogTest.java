package org.vanadium.view;

import org.junit.jupiter.api.Test;
import org.vanadium.TestUtils;
import org.vanadium.interfaces.Fruit;
import org.vanadium.model.fruit.Pomme;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class CreateFruitDialogTest {
    @Test
    void addFruit() {
        CreateFruitDialog dialog = new CreateFruitDialog();
        JComboBox pays = (JComboBox) TestUtils.getChildNamed(dialog, "Pays");
        pays.setSelectedItem(Fruit.Pays.PORTUGAL);
        JComboBox type = (JComboBox) TestUtils.getChildNamed(dialog, "Type");
        type.setSelectedItem(Fruit.Type.POMME);
        JSpinner prix = (JSpinner) TestUtils.getChildNamed(dialog, "Prix");
        prix.setValue(2.0);
        JSpinner quantity = (JSpinner) TestUtils.getChildNamed(dialog, "Quantité");
        quantity.setValue(2.0);


        JButton button = (JButton) TestUtils.getChildNamed(dialog, "Ajouter");
        button.doClick();
        assertTrue(dialog.getFruitItem().getKey() instanceof Pomme);
        assertSame(dialog.getFruitItem().getKey().getOrigine(), Fruit.Pays.PORTUGAL);
        assertEquals(2.0, dialog.getFruitItem().getKey().getPrix());
        assertEquals(2.0, dialog.getFruitItem().getValue());
    }
}
