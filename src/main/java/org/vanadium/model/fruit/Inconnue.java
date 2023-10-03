package org.vanadium.model.fruit;

import org.vanadium.interfaces.Fruit;

import static org.vanadium.model.Utils.round;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy BARRANCO
 * @author Julie PRIGENT
 */

public class Inconnue implements Fruit {
    private double prix;
    private Pays origine;

    /**
     * @brief Constructeur de la class Inconnue par défaut
     */
    public Inconnue() {
        this.prix = 0.0;
        this.origine = Pays.INCONNU;
    }

    /**
     * @param prix
     * @param origine
     * @brief Constructeur de la class Inconnue avec paramètres prix et origine
     */
    public Inconnue(double prix, Pays origine) {
        if (prix < 0)
            this.prix = -prix;  //une solution possible pour interdire les prix negatifs
        else
            this.prix = prix;
        this.origine = origine;
    }

    public static Pays randomPays() {
        int pick = new java.util.Random().nextInt(Pays.values().length);
        return Pays.values()[pick];
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Pays getOrigine() {
        return origine;
    }

    public void setOrigine(Pays origine) {
        this.origine = origine;
    }

    @Override
    public String toString() {
        return "Fruit inconnue de " + origine.toString() + " a " + round(prix, 2) + " euros";
    }

    @Override
    public String getImg() {
        return Fruit.imgClass.get(this.getClass());
    }

    /**
     * @param i Objet à comparer
     * @return true si les Inconnues sont équivalentes, false sinon
     * @brief Redéfinition de la méthode equals pour les Inconnues
     */
    @Override
    public boolean equals(Object i) {
        if (i != null && getClass() == i.getClass()) {
            Inconnue inconnue = (Inconnue) i;
            return (prix == inconnue.prix && origine.equals(inconnue.origine));
        }
        return false;
    }

    /**
     * @return false
     * @brief Redéfinition de la méthode isSeedless pour les Inconnues
     */
    public boolean isSeedless() {
        return false;
    }
}
