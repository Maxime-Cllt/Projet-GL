package org.vanadium.model.panier;

import org.junit.jupiter.api.Test;
import org.vanadium.model.fruit.Orange;

import java.util.AbstractMap;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PanierPleinExceptionTest {


    @Test
    void testPanierPleinException() {
        Panier panier = new Panier(0);
        Orange orange = new Orange();
        assertThrows(PanierPleinException.class, () -> panier.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0)));
    }

}