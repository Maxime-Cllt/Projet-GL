package org.vanadium.model.panier;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy Barranco
 */
public interface Fruit {
    public boolean isSeedless();

    public double getPrix();

    public Pays getOrigine();

    @Override
    public boolean equals(Object o);

    @Override
    public String toString();

    public String getImg();

    public enum Pays {
        FRANCE("France"),
        ESPAGNE("Espagne"),
        PORTUGAL("Portugal"),
        MAROC("Maroc"),
        ITALIE("Italie"),
        USA("USA"),
        INCONNU("Inconnu");

        private String name = "";

        //Constructeur
        Pays(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }


    public enum Type {
        ORANGE("Orange"),
        BANANE("Banane"),
        POMME("Pomme"),
        INCONNU("Inconnu");

        private String name = "";

        //Constructeur
        Type(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }


    static Map<Class<? extends Fruit>, String> imgClass = new HashMap<>(
            Map.of(
                    Orange.class, "orange.png"
//                    Banane.class, "bananes.png",
//                    Pomme.class, "pomme.png"
            )
    );

    static Map<Enum<? extends Fruit.Type>, String> imgType = new HashMap<>(
            Map.of(
                    Type.ORANGE, "orange.png"
//                    Type.BANANE, "bananes.png",
//                    Type.POMME, "pomme.png"
            )
    );

}
