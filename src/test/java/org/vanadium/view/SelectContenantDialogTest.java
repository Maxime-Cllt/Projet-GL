package org.vanadium.view;

import org.junit.jupiter.api.Test;
import org.vanadium.TestUtils;
import org.vanadium.interfaces.ContenantFruit;
import org.vanadium.model.Macedoine.Macedoine;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;


public class SelectContenantDialogTest {

    @Test
    public void selectContenant(){
        SelectContenantDialog dialog = new SelectContenantDialog();

        JComboBox contenant = (JComboBox) TestUtils.getChildNamed(dialog, "Contenant");
        contenant.setSelectedItem(ContenantFruit.TypeContenant.MACEDOINE);

        JButton button = (JButton) TestUtils.getChildNamed(dialog, "OK");
        button.doClick();

        assertTrue(dialog.getContenantFruitAbstract() instanceof Macedoine);
    }

}
