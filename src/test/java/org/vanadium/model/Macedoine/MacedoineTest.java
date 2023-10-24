package org.vanadium.model.Macedoine;

import org.junit.jupiter.api.Test;
import org.vanadium.interfaces.Fruit;
import org.vanadium.model.fruit.Banane;
import org.vanadium.model.fruit.Orange;
import org.vanadium.model.fruit.Pomme;

import java.util.AbstractMap;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MacedoineTest {
    
    @Mock
    Fruit fruit;
            
    Orange orange;
    Banane banane;
    Pomme pomme;
    Macedoine macedoine;
    
    @BeforeEach
    void setup(){
        macedoine = new Macedoine();
        
        orange = new Orange();
        orange.setPrix(1.0);
        orange.setOrigine(Fruit.Pays.FRANCE);
        
        banane = new Banane();
        banane.setPrix(1.0);
        banane.setOrigine(Fruit.Pays.FRANCE);
        
        pomme = new Pomme();
        pomme.setPrix(1.0);
        pomme.setOrigine(Fruit.Pays.FRANCE);
    }
    
    @Test
    void testToString() {
        assertEquals("Macedoine: ", macedoine.toString());
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));

        assertEquals("Macedoine: Orange: 1,", macedoine.toString());
    }

    @Test
    void getFruits() {
        macedoine.ajout(new AbstractMap.SimpleEntry<>(fruit, 1.0));
        assertEquals(1, macedoine.getFruits().size());
    }

    @Test
    void setFruits() {
        macedoine.ajout(new AbstractMap.SimpleEntry<>(fruit, 1.0));
        assertEquals(1, macedoine.getFruits().size());
    }

    @Test
    void getTailleContenant() {
        assertEquals(0, macedoine.getTailleContenant());
        macedoine.ajout(new AbstractMap.SimpleEntry<>(fruit, 1.0));
        assertEquals(1, macedoine.getTailleContenant());
        
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(2, macedoine.getTailleContenant());
        
        macedoine.ajout(new AbstractMap.SimpleEntry<>(banane, 1.0));
        assertEquals(3, macedoine.getTailleContenant());
        
        macedoine.ajout(new AbstractMap.SimpleEntry<>(pomme, 1.0));
        assertEquals(4, macedoine.getTailleContenant());
    }

    @Test
    void getFruit() {
        macedoine.ajout(new AbstractMap.SimpleEntry<>(fruit, 1.0));
    }

    @Test
    void estVide() {
        assertEquals(0, macedoine.getTailleContenant());
        macedoine.ajout(new AbstractMap.SimpleEntry<>(fruit, 1.0));
        assertEquals(1, macedoine.getTailleContenant());
        macedoine.retrait(fruit);
        assertEquals(0, macedoine.getTailleContenant());
    }

    @Test
    void ajout() {
        assertEquals(0, macedoine.getTailleContenant());
        
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1, macedoine.getTailleContenant());
        
        macedoine.ajout(new AbstractMap.SimpleEntry<>(banane, 1.0));
        assertEquals(2, macedoine.getTailleContenant());
        
        macedoine.ajout(new AbstractMap.SimpleEntry<>(pomme, 1.0));
        assertEquals(3, macedoine.getTailleContenant());

        macedoine.ajout(new AbstractMap.SimpleEntry<>(fruit, 1.0));
        assertEquals(4, macedoine.getTailleContenant());
    }

    @Test
    void ajoutMacedoine() {
        //1ere macedoine
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1, macedoine.getTailleContenant());

        //2nd macedoine
        Macedoine macedoineDeMacedoine = new Macedoine();
        assertEquals(0, macedoineDeMacedoine.getTailleContenant());
        macedoineDeMacedoine.ajout(new AbstractMap.SimpleEntry<>(banane, 1.0));
        assertEquals(1, macedoineDeMacedoine.getTailleContenant());

        //Ajout de la 1ere macedoine à la seconde
        macedoineDeMacedoine.ajout(new AbstractMap.SimpleEntry<>(macedoine, 3.0));
        assertEquals(2, macedoineDeMacedoine.getTailleContenant());
        assertTrue(macedoineDeMacedoine.getFruits().containsKey(macedoine));
    }

    @Test
    void retrait() {
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1, macedoine.getTailleContenant());
        macedoine.retrait(orange);
        assertEquals(0, macedoine.getTailleContenant());
    }

    @Test
    void getPrixTotal() {
        assertEquals(0, macedoine.getPrixTotal());
        
        orange.setPrix(1.0);
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1.0, macedoine.getPrixTotal());
        
        banane.setPrix(1.0);
        macedoine.ajout(new AbstractMap.SimpleEntry<>(banane, 1.0));
        assertEquals(2.0, macedoine.getPrixTotal());
        
        pomme.setPrix(2.0);
        macedoine.ajout(new AbstractMap.SimpleEntry<>(pomme, 1.0));
        assertEquals(4.0, macedoine.getPrixTotal());
    }


    @Test
    void getPoidsTotal() {
        assertEquals(0, macedoine.getPoidsTotal());
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(1.0, macedoine.getPoidsTotal());
        macedoine.ajout(new AbstractMap.SimpleEntry<>(banane, 1.0));
        assertEquals(2.0, macedoine.getPoidsTotal());
        macedoine.ajout(new AbstractMap.SimpleEntry<>(pomme, 1.0));
        assertEquals(3.0, macedoine.getPoidsTotal());
        macedoine.ajout(new AbstractMap.SimpleEntry<>(fruit, 1.0));
        assertEquals(4.0, macedoine.getPoidsTotal());
    }


    @Test
    void testEquals() {
        Macedoine macedoine2 = new Macedoine();
        assertEquals(macedoine, macedoine2);
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
        assertThrows(MacedoineVideException.class, macedoine::retrait);
    }
    
    @Test
    void isSeedlesstrue(){
        macedoine.ajout(new AbstractMap.SimpleEntry<>(banane, 1.0));
        assertEquals(Boolean.TRUE, macedoine.isSeedless());
    }
    
    @Test
    void isSeedlessFalse(){
        macedoine.ajout(new AbstractMap.SimpleEntry<>(pomme, 1.0));
        macedoine.ajout(new AbstractMap.SimpleEntry<>(orange, 1.0));
        assertEquals(Boolean.FALSE, macedoine.isSeedless());
    }
}