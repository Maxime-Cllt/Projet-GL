package org.vanadium.view;

import org.junit.jupiter.api.Test;
import org.vanadium.TestUtils;
import org.vanadium.interfaces.Fruit;
import org.vanadium.model.fruit.FruitItem;
import org.vanadium.model.fruit.Orange;
import org.vanadium.model.fruit.Pomme;

import javax.swing.*;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ModifyFruitDialogTest {
    @Test
    void addFruit() {
        FruitItem item = new FruitItem(new Orange(), 1.0);
        ModifyFruitDialog dialog = new ModifyFruitDialog(item);

        JComboBox pays = (JComboBox) TestUtils.getChildNamed(dialog, "Pays");
        pays.setSelectedItem(Fruit.Pays.PORTUGAL);
        JComboBox type = (JComboBox) TestUtils.getChildNamed(dialog, "Type");
        type.setSelectedItem(Fruit.Type.POMME);
        JSpinner prix = (JSpinner) TestUtils.getChildNamed(dialog, "Prix");
        prix.setValue(2.0);
        JSpinner quantity = (JSpinner) TestUtils.getChildNamed(dialog, "Quantité");
        quantity.setValue(2.0);

        JButton button = (JButton) TestUtils.getChildNamed(dialog, "Modifier");
        button.doClick();
        assertTrue(dialog.getNewFruitItem().getFruit() instanceof Pomme);
        assertSame(dialog.getNewFruitItem().getFruit().getOrigine(), Fruit.Pays.PORTUGAL);
        assertEquals(2.0, dialog.getNewFruitItem().getFruit().getPrix());
        assertEquals(2.0, dialog.getNewFruitItem().getQuantity());
    }
}
