package org.vanadium.model.panier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.vanadium.interfaces.Fruit;
import org.vanadium.model.fruit.Banane;
import org.vanadium.model.fruit.Orange;
import org.vanadium.model.fruit.Pomme;
import java.util.AbstractMap;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PanierTest {

    @Mock
    Fruit fruit;

    @Test
    void getTaillePanier() throws PanierPleinException {
        Panier panier = new Panier(10);
        assertEquals(0, panier.getTailleContenant());
        panier.ajout(new AbstractMap.SimpleEntry<>(fruit, 1.0));
        assertEquals(1, panier.getTailleContenant());
        panier.retrait(fruit);
        assertEquals(0, panier.getTailleContenant());
    }

    @Test
    void estVide() throws PanierPleinException {
        Panier panier = new Panier(5);
        assertTrue(panier.estVide());
        panier.ajout(new AbstractMap.SimpleEntry<>(fruit, 1.0));
        assertFalse(panier.estVide());
        panier.retrait(fruit);
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
            panier.ajout(new AbstractMap.SimpleEntry<>(fruit, 1.0));
            assertEquals(1, panier.getTailleContenant());
        } catch (PanierPleinException e) {
            e.printStackTrace();
        }

    }

    @Test
    void retrait() throws PanierPleinException {
        Panier panier = new Panier(10);
        panier.ajout(new AbstractMap.SimpleEntry<>(fruit, 1.0));
        panier.retrait(fruit);
        assertEquals(0, panier.getTailleContenant());
    }

    @Test
    void testRetrait() throws PanierPleinException {
        Panier panier = new Panier(10);
        panier.ajout(new AbstractMap.SimpleEntry<>(fruit, 1.0));
        assertEquals(1, panier.getTailleContenant());
        panier.retrait(fruit);
        assertEquals(0, panier.getTailleContenant());
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