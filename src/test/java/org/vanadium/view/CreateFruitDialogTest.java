package org.vanadium.view;

import org.junit.jupiter.api.Test;
import org.vanadium.TestUtils;
import org.vanadium.interfaces.Fruit;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateFruitDialogTest {
    @Test
    void addFruit() {
        CreateFruitDialog dialog = new CreateFruitDialog();
        JButton button = (JButton) TestUtils.getChildNamed(dialog, "Ajouter");
        button.doClick();
        assertTrue(dialog.getFruitItem().getKey() instanceof Fruit);
    }
}
