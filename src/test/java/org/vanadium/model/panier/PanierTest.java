package org.vanadium.model.panier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PanierTest {

    @Test
    void getTaillePanier() throws PanierPleinException, PanierVideException {
        Panier panier = new Panier(5);
        assertEquals(0, panier.getTaillePanier());
        panier.ajout(new Orange());
        assertEquals(1, panier.getTaillePanier());
        panier.retrait();
        assertEquals(0, panier.getTaillePanier());
    }

    @Test
    void estVide() throws PanierPleinException, PanierVideException {
        Panier panier = new Panier(5);
        assertTrue(panier.estVide());
        panier.ajout(new Orange());
        assertFalse(panier.estVide());
        panier.retrait();
        assertTrue(panier.estVide());
    }

//    @Test
//    void estPlein() {
//        Panier panier = new Panier(5);
//        for (int i = 0; i < 6; i++) {
//            Orange orange = new Orange();
//            try {
//                panier.ajout(orange);
//            } catch (PanierPleinException e) {
//                e.printStackTrace();
//            }
//        }
//        assertTrue(panier.estPlein());
//    }

    @Test
    void ajout() throws PanierPleinException, PanierVideException {
        Panier panier = new Panier(10);
        panier.ajout(new Orange());
        assertEquals(1, panier.getTaillePanier());
    }

    @Test
    void retrait() throws PanierPleinException {
        Panier panier = new Panier(10);
        Orange orange = new Orange();
        panier.ajout(orange);
        panier.retrait(orange);
        assertEquals(0, panier.getTaillePanier());
    }

    @Test
    void testRetrait() throws PanierVideException, PanierPleinException {
        Panier panier = new Panier(10);
        Orange orange = new Orange();
        panier.ajout(orange);
        panier.retrait();
        assertEquals(0, panier.getTaillePanier());

    }

    @Test
    void getPrix() throws PanierPleinException {
        Panier panier = new Panier(10);
        Orange orange = new Orange();
        panier.ajout(orange);
        assertEquals(0.5, panier.getPrix());
    }

    @Test
    void testEquals() {
        Panier panier = new Panier(10);
        Panier panier2 = new Panier(10);
        assertEquals(panier, panier2);
    }
}