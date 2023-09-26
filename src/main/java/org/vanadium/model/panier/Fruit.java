package org.vanadium.model.panier;

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
}
