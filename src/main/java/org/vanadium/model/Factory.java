package org.vanadium.model;

import org.vanadium.model.panier.Fruit;
import org.vanadium.model.panier.Orange;

public class Factory {



    public static Fruit createFruit(Fruit.Type type){
        switch (type){
            case ORANGE:
                return new Orange();
            case BANANE:
//                return new Banane();
//            case POMME:
//                return new Pomme();
            default:
                return null;
        }

    }

}