package org.vanadium.model.Macedoine;

import org.junit.jupiter.api.Test;
import org.vanadium.interfaces.Fruit;
import org.vanadium.model.fruit.Banane;
import org.vanadium.model.fruit.Inconnue;
import org.vanadium.model.fruit.Orange;
import org.vanadium.model.fruit.Pomme;

import java.util.AbstractMap;

import static org.junit.jupiter.api.Assertions.*;

class MacedoineTest {

    @Test
    void testToString() {
        Macedoine macedoine = new Macedoine();
        assertEquals("Macedoine{fruits={}}", macedoine.toString());
        Orange orange = new Orange();
        orange.setPrix(1.0);
        orange.setOrigine(Fruit.Pays.FRANCE);
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals("Macedoine{fruits={Orange de France a 1.0 euros=1.0}}", macedoine.toString());
    }

    @Test
    void getFruits() {
        Macedoine macedoine = new Macedoine();
        assertEquals(0, macedoine.getFruits().size());
        Orange orange = new Orange();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1, macedoine.getFruits().size());
    }

    @Test
    void setFruits() {
        Macedoine macedoine = new Macedoine();
        assertEquals(0, macedoine.getFruits().size());
        Orange orange = new Orange();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1, macedoine.getFruits().size());
    }

    @Test
    void getTailleContenant() {
        Macedoine macedoine = new Macedoine();
        assertEquals(0, macedoine.getTailleContenant());
        Orange orange = new Orange();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1, macedoine.getTailleContenant());
        Banane banane = new Banane();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(banane, 1.0));
        assertEquals(2, macedoine.getTailleContenant());
        Pomme pomme = new Pomme();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(pomme, 1.0));
        assertEquals(3, macedoine.getTailleContenant());
        Inconnue inconnue = new Inconnue();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(inconnue, 1.0));
        assertEquals(4, macedoine.getTailleContenant());
    }

    @Test
    void getFruit() {
        Macedoine macedoine = new Macedoine();
        assertEquals(0, macedoine.getTailleContenant());
        Orange orange = new Orange();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
    }

    @Test
    void estVide() {
        Macedoine macedoine = new Macedoine();
        assertEquals(0, macedoine.getTailleContenant());
        Orange orange = new Orange();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1, macedoine.getTailleContenant());
        macedoine.retrait(orange);
        assertEquals(0, macedoine.getTailleContenant());
    }

    @Test
    void ajout() {
        Macedoine macedoine = new Macedoine();
        assertEquals(0, macedoine.getTailleContenant());
        Orange orange = new Orange();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1, macedoine.getTailleContenant());
        Banane banane = new Banane();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(banane, 1.0));
        assertEquals(2, macedoine.getTailleContenant());
        Pomme pomme = new Pomme();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(pomme, 1.0));
        assertEquals(3, macedoine.getTailleContenant());
        Inconnue inconnue = new Inconnue();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(inconnue, 1.0));
        assertEquals(4, macedoine.getTailleContenant());
    }

    @Test
    void ajoutMacedoine() {
        //1ere macedoine
        Macedoine macedoine = new Macedoine();
        assertEquals(0, macedoine.getTailleContenant());
        Orange orange = new Orange();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1, macedoine.getTailleContenant());
        
        //2nd macedoine 
        Macedoine macedoineDeMacedoine = new Macedoine();
        assertEquals(0, macedoineDeMacedoine.getTailleContenant());
        Banane banane = new Banane();
        macedoineDeMacedoine.ajout(new AbstractMap.SimpleEntry<>(banane, 1.0));
        assertEquals(1, macedoineDeMacedoine.getTailleContenant());
    
        //Ajout de la 1ere macedoine à la seconde
        macedoineDeMacedoine.ajout(new AbstractMap.SimpleEntry<>(macedoine, 3.0));
        assertEquals(2, macedoineDeMacedoine.getTailleContenant());
        assertEquals(macedoineDeMacedoine.getFruit(0), macedoine);
    }

    @Test
    void retrait() {
        Macedoine macedoine = new Macedoine();
        assertEquals(0, macedoine.getTailleContenant());
        Orange orange = new Orange();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1, macedoine.getTailleContenant());
        macedoine.retrait(orange);
        assertEquals(0, macedoine.getTailleContenant());
    }

    @Test
    void getPrixTotal() {
        Macedoine macedoine = new Macedoine();
        assertEquals(0, macedoine.getPrixTotal());
        Orange orange = new Orange();
        orange.setPrix(1.0);
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1.0, macedoine.getPrixTotal());
        Banane banane = new Banane();
        banane.setPrix(1.0);
        macedoine.ajout(new AbstractMap.SimpleEntry<>(banane, 1.0));
        assertEquals(2.0, macedoine.getPrixTotal());
        Pomme pomme = new Pomme();
        pomme.setPrix(2.0);
        macedoine.ajout(new AbstractMap.SimpleEntry<>(pomme, 1.0));
        assertEquals(4.0, macedoine.getPrixTotal());
    }


    @Test
    void getPoidsTotal() {
        Macedoine macedoine = new Macedoine();
        assertEquals(0, macedoine.getPoidsTotal());
        Orange orange = new Orange();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1.0, macedoine.getPoidsTotal());
        Banane banane = new Banane();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(banane, 1.0));
        assertEquals(2.0, macedoine.getPoidsTotal());
        Pomme pomme = new Pomme();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(pomme, 1.0));
        assertEquals(3.0, macedoine.getPoidsTotal());
        Inconnue inconnue = new Inconnue();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(inconnue, 1.0));
        assertEquals(4.0, macedoine.getPoidsTotal());
    }


    @Test
    void testEquals() {
        Macedoine macedoine = new Macedoine();
        Macedoine macedoine2 = new Macedoine();
        assertEquals(macedoine, macedoine2);
        Orange orange = new Orange();
        Pomme pomme = new Pomme();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        macedoine2.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(macedoine, macedoine2);
        macedoine2.ajout(new AbstractMap.SimpleEntry<>(pomme, 1.0));
        assertNotEquals(macedoine, macedoine2);
        macedoine2.retrait(pomme);
        assertEquals(macedoine, macedoine2);
    }

    @Test
    void MacedoineVideException() {
        Macedoine macedoine = new Macedoine();
        assertThrows(MacedoineVideException.class, macedoine::retrait);
    }
    
    @Test
    void isSeedlesstrue(){
        Macedoine macedoine = new Macedoine();
        Banane banane = new Banane();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(banane, 1.0));
        assertEquals(Boolean.TRUE, macedoine.isSeedless());
    }
    
    @Test
    void isSeedlessFalse(){
        Macedoine macedoine = new Macedoine();
        Pomme pomme = new Pomme();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(pomme, 1.0));
        Orange orange = new Orange();
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(Boolean.FALSE, macedoine.isSeedless());
    }
}