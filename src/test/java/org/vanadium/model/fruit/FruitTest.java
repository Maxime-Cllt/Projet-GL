package org.vanadium.model.fruit;

import org.junit.jupiter.api.Test;
import org.vanadium.interfaces.Fruit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class FruitTest {

    @Test
    void isSeedless() {
        assertFalse(new Banane().isSeedless());
        assertFalse(new Orange().isSeedless());
        assertFalse(new Pomme().isSeedless());
        assertFalse(new Inconnue().isSeedless());
    }

    @Test
    void getPrix() {
        Banane banane = new Banane();
        Orange orange = new Orange();
        Pomme pomme = new Pomme();
        Inconnue inconnue = new Inconnue();
        banane.setPrix(1.0);
        orange.setPrix(1.5);
        pomme.setPrix(2.0);
        inconnue.setPrix(2.0);
        assertEquals(1.0, banane.getPrix());
        assertEquals(1.5, orange.getPrix());
        assertEquals(2.0, pomme.getPrix());
        assertEquals(2.0, inconnue.getPrix());
    }

    @Test
    void getOrigine() {
        Banane banane = new Banane();
        Orange orange = new Orange();
        Pomme pomme = new Pomme();
        Inconnue inconnue = new Inconnue();
        banane.setOrigine(Fruit.Pays.FRANCE);
        orange.setOrigine(Fruit.Pays.ESPAGNE);
        pomme.setOrigine(Fruit.Pays.PORTUGAL);
        inconnue.setOrigine(Fruit.Pays.INCONNU);
        assertEquals(Fruit.Pays.FRANCE, banane.getOrigine());
        assertEquals(Fruit.Pays.ESPAGNE, orange.getOrigine());
        assertEquals(Fruit.Pays.PORTUGAL, pomme.getOrigine());
        assertEquals(Fruit.Pays.INCONNU, inconnue.getOrigine());
    }

    @Test
    void testEquals() {
        Banane banane = new Banane();
        Orange orange = new Orange();
        Pomme pomme = new Pomme();
        Inconnue inconnue = new Inconnue();
        banane.setOrigine(Fruit.Pays.FRANCE);
        orange.setOrigine(Fruit.Pays.ESPAGNE);
        pomme.setOrigine(Fruit.Pays.PORTUGAL);
        inconnue.setOrigine(Fruit.Pays.INCONNU);
        assertEquals(Fruit.Pays.FRANCE, banane.getOrigine());
        assertEquals(Fruit.Pays.ESPAGNE, orange.getOrigine());
        assertEquals(Fruit.Pays.PORTUGAL, pomme.getOrigine());
        assertEquals(Fruit.Pays.INCONNU, inconnue.getOrigine());
    }

    @Test
    void testToString() {
        Banane banane = new Banane();
        Orange orange = new Orange();
        Pomme pomme = new Pomme();
        Inconnue inconnue = new Inconnue();
        banane.setOrigine(Fruit.Pays.FRANCE);
        orange.setOrigine(Fruit.Pays.ESPAGNE);
        pomme.setOrigine(Fruit.Pays.PORTUGAL);
        inconnue.setOrigine(Fruit.Pays.INCONNU);
        assertEquals(Fruit.Pays.FRANCE, banane.getOrigine());
        assertEquals(Fruit.Pays.ESPAGNE, orange.getOrigine());
        assertEquals(Fruit.Pays.PORTUGAL, pomme.getOrigine());
        assertEquals(Fruit.Pays.INCONNU, inconnue.getOrigine());
    }

    @Test
    void getImg() {
        Banane banane = new Banane();
        Orange orange = new Orange();
        Pomme pomme = new Pomme();
        Inconnue inconnue = new Inconnue();
        banane.setOrigine(Fruit.Pays.FRANCE);
        orange.setOrigine(Fruit.Pays.ESPAGNE);
        pomme.setOrigine(Fruit.Pays.PORTUGAL);
        inconnue.setOrigine(Fruit.Pays.INCONNU);
        assertEquals(Fruit.Pays.FRANCE, banane.getOrigine());
        assertEquals(Fruit.Pays.ESPAGNE, orange.getOrigine());
        assertEquals(Fruit.Pays.PORTUGAL, pomme.getOrigine());
        assertEquals(Fruit.Pays.INCONNU, inconnue.getOrigine());
    }

}