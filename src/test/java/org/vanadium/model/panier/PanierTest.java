package org.vanadium.model.panier;

import org.junit.jupiter.api.Test;
import org.vanadium.model.fruit.Banane;
import org.vanadium.model.fruit.Orange;
import org.vanadium.model.fruit.Pomme;

import java.util.AbstractMap;

import static org.junit.jupiter.api.Assertions.*;

class PanierTest {

    @Test
    void getTaillePanier() throws PanierPleinException {
        Panier panier = new Panier(10);
        assertEquals(0, panier.getTaillePanier());
        Orange orange = new Orange();
        panier.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1, panier.getTaillePanier());
        panier.retrait(orange);
        assertEquals(0, panier.getTaillePanier());
    }

    @Test
    void estVide() throws PanierPleinException {
        Panier panier = new Panier(5);
        assertTrue(panier.estVide());
        Orange orange = new Orange();
        panier.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertFalse(panier.estVide());
        panier.retrait(orange);
        assertTrue(panier.estVide());
    }

    @Test
    void estPlein() {
        Panier panier = new Panier(3);
        for (int i = 0; i < 3; i++) {
            Orange orange = new Orange();
            try {
                panier.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
            } catch (PanierPleinException e) {
                e.printStackTrace();
            }
        }
        assertTrue(panier.estPlein());
    }

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
    void testRetrait() throws PanierPleinException {
        Panier panier = new Panier(10);
        Orange orange = new Orange();
        panier.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1, panier.getTaillePanier());
        panier.retrait(orange);
        assertEquals(0, panier.getTaillePanier());
    }

    @Test
    void getPrix() throws PanierPleinException {
        Panier panier = new Panier(10);
        Orange orange = new Orange();
        orange.setPrix(0.5);
        panier.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(0.5, panier.getPrixTotal());
        Banane banane = new Banane();
        banane.setPrix(1.0);
        panier.ajout(new AbstractMap.SimpleEntry<>(banane, 1.0));
        assertEquals(1.5, panier.getPrixTotal());
        Pomme pomme = new Pomme();
        pomme.setPrix(2.0);
        panier.ajout(new AbstractMap.SimpleEntry<>(pomme, 1.0));
        assertEquals(3.5, panier.getPrixTotal());
    }

    @Test
    void testEquals() {
        Panier panier = new Panier(10);
        Panier panier2 = new Panier(10);
        assertEquals(panier, panier2);
    }
}