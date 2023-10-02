package org.vanadium.model.panier;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PanierTest {

    @Test
    void getTaillePanier() throws PanierPleinException, PanierVideException {
        Panier panier = new Panier(10);
        assertEquals(0, panier.getTaillePanier());
        Orange orange = new Orange();
        panier.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1, panier.getTaillePanier());
        panier.retrait();
        assertEquals(0, panier.getTaillePanier());
    }

    @Test
    void estVide() throws PanierPleinException, PanierVideException {
        Panier panier = new Panier(5);
        assertTrue(panier.estVide());
        Orange orange = new Orange();
        panier.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
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
    void ajout() {
        try {
            Panier panier = new Panier(10);
            Orange orange = new Orange();
            panier.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
            assertEquals(1, panier.getTaillePanier());
        } catch (PanierPleinException e) {
            e.printStackTrace();
        }

    }

    @Test
    void retrait() throws PanierPleinException {
        Panier panier = new Panier(10);
        Orange orange = new Orange();
        panier.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        panier.retrait(orange);
        assertEquals(0, panier.getTaillePanier());
    }

    @Test
    void testRetrait() throws PanierVideException, PanierPleinException {
        Panier panier = new Panier(10);
        panier.ajout((Map.Entry<Fruit, Double>) new Orange());
        panier.retrait();
        assertEquals(0, panier.getTaillePanier());

    }

    @Test
    void getPrix() throws PanierPleinException {
        Panier panier = new Panier(10);
        Orange orange = new Orange();
        panier.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(0.5, panier.getPrix());
    }

    @Test
    void testEquals() {
        Panier panier = new Panier(10);
        Panier panier2 = new Panier(10);
        assertEquals(panier, panier2);
    }
}