package org.vanadium.model.panier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class FruitTest {

    @Test
    void isSeedless() {
        assertFalse(new Banane().isSeedless());
        assertFalse(new Orange().isSeedless());
        assertFalse(new Pomme().isSeedless());
    }

    @Test
    void getPrix() {
        Banane banane = new Banane();
        Orange orange = new Orange();
        Pomme pomme = new Pomme();
        banane.setPrix(1.0);
        orange.setPrix(1.5);
        pomme.setPrix(2.0);
        assertEquals(1.0, banane.getPrix());
        assertEquals(1.5, orange.getPrix());
        assertEquals(2.0, pomme.getPrix());
    }

    @Test
    void getOrigine() {
        Banane banane = new Banane();
        Orange orange = new Orange();
        Pomme pomme = new Pomme();
        banane.setOrigine(Fruit.Pays.FRANCE);
        orange.setOrigine(Fruit.Pays.ESPAGNE);
        pomme.setOrigine(Fruit.Pays.PORTUGAL);
        assertEquals(Fruit.Pays.FRANCE, banane.getOrigine());
        assertEquals(Fruit.Pays.ESPAGNE, orange.getOrigine());
        assertEquals(Fruit.Pays.PORTUGAL, pomme.getOrigine());
    }

    @Test
    void testEquals() {
        Banane banane = new Banane();
        Orange orange = new Orange();
        Pomme pomme = new Pomme();
        banane.setOrigine(Fruit.Pays.FRANCE);
        orange.setOrigine(Fruit.Pays.ESPAGNE);
        pomme.setOrigine(Fruit.Pays.PORTUGAL);
        assertEquals(Fruit.Pays.FRANCE, banane.getOrigine());
        assertEquals(Fruit.Pays.ESPAGNE, orange.getOrigine());
        assertEquals(Fruit.Pays.PORTUGAL, pomme.getOrigine());
    }

    @Test
    void testToString() {
        Banane banane = new Banane();
        Orange orange = new Orange();
        Pomme pomme = new Pomme();
        banane.setOrigine(Fruit.Pays.FRANCE);
        orange.setOrigine(Fruit.Pays.ESPAGNE);
        pomme.setOrigine(Fruit.Pays.PORTUGAL);
        assertEquals(Fruit.Pays.FRANCE, banane.getOrigine());
        assertEquals(Fruit.Pays.ESPAGNE, orange.getOrigine());
        assertEquals(Fruit.Pays.PORTUGAL, pomme.getOrigine());
    }

    @Test
    void getImg() {
        Banane banane = new Banane();
        Orange orange = new Orange();
        Pomme pomme = new Pomme();
        banane.setOrigine(Fruit.Pays.FRANCE);
        orange.setOrigine(Fruit.Pays.ESPAGNE);
        pomme.setOrigine(Fruit.Pays.PORTUGAL);
        assertEquals(Fruit.Pays.FRANCE, banane.getOrigine());
        assertEquals(Fruit.Pays.ESPAGNE, orange.getOrigine());
        assertEquals(Fruit.Pays.PORTUGAL, pomme.getOrigine());
    }

}