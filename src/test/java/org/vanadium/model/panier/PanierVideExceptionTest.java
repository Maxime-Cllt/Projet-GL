package org.vanadium.model.panier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PanierVideExceptionTest {

    @Test
    void testPanierVideException() {
        Panier panier = new Panier(1);
        assertThrows(PanierVideException.class, panier::retrait);
    }

}