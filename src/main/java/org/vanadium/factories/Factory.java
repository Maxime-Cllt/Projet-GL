package org.vanadium.factories;

import org.vanadium.interfaces.*;
import org.vanadium.model.ContenantFruitAbstract;
import org.vanadium.model.Jus.Jus;
import org.vanadium.model.Macedoine.Macedoine;
import org.vanadium.model.fruit.*;
import org.vanadium.model.panier.Panier;


/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy BARRANCO
 * @author Julie PRIGENT
 */

public class Factory {


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
            default -> new Inconnue();
        };
    }

    public static ContenantFruitAbstract createContenantFruit(ContenantFruit.TypeContenant type, int contenanceMax) {

        return switch (type) {
            case MACEDOINE -> new Macedoine();
            case PANIER -> new Panier(contenanceMax);
            default -> new Jus();
        };
    }

}