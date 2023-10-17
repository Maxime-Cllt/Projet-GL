package org.vanadium.model.Jus;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.vanadium.interfaces.Fruit;

import java.util.AbstractMap;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

@ExtendWith(MockitoExtension.class)
public class JusTest {
    
    Jus jus;
    
    @Mock
    Fruit fruit;
    
    @BeforeEach
    void setup(){
        jus = new Jus();
    }

    @Test
    void getTailleContenant() {
        assertEquals(0, jus.getTailleContenant());
        jus.ajout(new AbstractMap.SimpleEntry<>(fruit, 1.0));
        assertEquals(1, jus.getTailleContenant());
        jus.retrait(fruit);
        assertEquals(0, jus.getTailleContenant());
    }

    @Test
    void estVide() {
        assertTrue(jus.estVide());
        jus.ajout(new AbstractMap.SimpleEntry<>(fruit, 1.0));
        assertFalse(jus.estVide());
        jus.retrait(fruit);
        assertTrue(jus.estVide());
    }

    @Test
    void ajout() {
        jus.ajout(new AbstractMap.SimpleEntry<>(fruit, 1.0));
        assertEquals(1, jus.getTailleContenant());
    }

    @Test
    void retrait() {
        jus.ajout(new AbstractMap.SimpleEntry<>(fruit, 1.0));
        jus.retrait(fruit);
        assertEquals(0, jus.getTailleContenant());
    }

    @Test
    void jusVideException() {
        assertThrows(JusVideException.class, () -> jus.retrait());
    }
}
