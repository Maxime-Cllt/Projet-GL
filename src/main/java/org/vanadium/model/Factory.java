package org.vanadium.model;

import org.vanadium.model.panier.Banane;
import org.vanadium.model.panier.Fruit;
import org.vanadium.model.panier.Orange;
import org.vanadium.model.panier.Pomme;


/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy Barranco
 * @author Julie Prigent
 */

public class Factory {


    /**
     * @param type Type du fruit à créer
     * @return Fruit
     * @brief Méthode qui permet de créer un fruit en fonction de son type (orange, banane, pomme) et de le retourner (pattern factory)
     */
    public static Fruit createFruit(Fruit.Type type) {

        switch (type) {
            case ORANGE:
                return new Orange();
            case BANANE:
                return new Banane();
            case POMME:
                return new Pomme();
            default:
                return null;
        }

    }

}