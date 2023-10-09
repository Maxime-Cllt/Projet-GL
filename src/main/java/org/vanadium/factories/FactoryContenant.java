package org.vanadium.factories;

import org.vanadium.interfaces.ContenantFruit;
import org.vanadium.model.ContenantFruitAbstract;
import org.vanadium.model.Jus.Jus;
import org.vanadium.model.Macedoine.Macedoine;
import org.vanadium.model.panier.Panier;


/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy BARRANCO
 * @author Julie PRIGENT
 */

public class FactoryContenant {


    public static ContenantFruitAbstract createContenantFruit(ContenantFruit.TypeContenant type, int contenanceMax) {

        return switch (type) {
            case MACEDOINE -> new Macedoine();
            case PANIER -> new Panier(contenanceMax);
            default -> new Jus();
        };
    }

}