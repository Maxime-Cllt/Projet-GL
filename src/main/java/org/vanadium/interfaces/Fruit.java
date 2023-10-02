package org.vanadium.interfaces;

import org.vanadium.model.fruit.Banane;
import org.vanadium.model.fruit.Orange;
import org.vanadium.model.fruit.Pomme;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy Barranco
 * @author Julie Prigent
 */
public interface Fruit {

    /**
     * @brief Map des images des fruits par classe de fruit
     */
    Map<Class<? extends Fruit>, String> imgClass = new HashMap<>(
            Map.of(
                    Orange.class, "orange.png",
                    Banane.class, "bananes.png",
                    Pomme.class, "pomme.png"
            )
    );

    /**
     * @brief Map des images des fruits par type de fruit
     */
    Map<Enum<? extends Fruit.Type>, String> imgType = new HashMap<>(
            Map.of(
                    Type.ORANGE, "orange.png",
                    Type.BANANE, "bananes.png",
                    Type.POMME, "pomme.png"
            )
    );

    boolean isSeedless();

    double getPrix();

    void setPrix(double prix);

    Pays getOrigine();

    void setOrigine(Pays origine);

    @Override
    boolean equals(Object o);

    @Override
    String toString();

    String getImg();


    enum Pays {
        FRANCE("France"),
        ESPAGNE("Espagne"),
        PORTUGAL("Portugal"),
        MAROC("Maroc"),
        ITALIE("Italie"),
        USA("USA"),
        INCONNU("Inconnu");

        private String name = "";

        /**
         * @param name
         * @brief Constructeur de l'enum Pays avec paramètre name du pays en question en String (ex: "France")
         */
        Pays(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    enum Type {
        ORANGE("Orange"),
        BANANE("Banane"),
        POMME("Pomme"),
        INCONNU("Inconnu");

        private String name = "";

        /**
         * @param name nom du type de fruit
         * @brief Constructeur de l'enum Type de fruit avec paramètre name
         */
        Type(String name) {
            this.name = name;
        }

        /**
         * @return
         * @brief Méthode qui permet de retourner le nom du type de fruit
         */
        public String toString() {
            return name;
        }
    }
}
