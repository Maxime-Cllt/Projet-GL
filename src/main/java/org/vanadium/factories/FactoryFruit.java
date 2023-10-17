package org.vanadium.factories;

import org.vanadium.interfaces.Fruit;
import org.vanadium.model.Macedoine.Macedoine;
import org.vanadium.model.fruit.Banane;
import org.vanadium.model.fruit.Inconnue;
import org.vanadium.model.fruit.Orange;
import org.vanadium.model.fruit.Pomme;


/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy BARRANCO
 * @author Julie PRIGENT
 */

public class FactoryFruit {


    /**
     * @param type Type du fruit à créer
     * @return Fruit
     * @brief Méthode qui permet de créer un fruit en fonction de son type (orange, banane, pomme) et de le retourner (pattern factory)
     */
    public static Fruit createFruit(Fruit.Type type) {

        return switch (type) {
            case ORANGE -> new Orange();
            case BANANE -> new Banane();
            case POMME -> new Pomme();
            case MACEDEOINE -> new Macedoine();
            default -> new Inconnue();
        };
    }
}