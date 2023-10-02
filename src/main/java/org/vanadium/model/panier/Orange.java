package org.vanadium.model.panier;

import org.vanadium.model.Utils;

import static org.vanadium.model.Utils.round;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy Barranco
 * @author Julie Prigent
 */

public class Orange implements Fruit {
    private double prix;
    private Pays origine;

    /**
     * @brief Constructeur de la class Orange par défaut
     */
    public Orange() {
        this.prix = 0.5;
        this.origine = Pays.INCONNU;
    }

    /**
     * @param prix
     * @param origine
     * @brief Constructeur de la class Orange avec paramètres prix et origine
     */
    public Orange(double prix, Pays origine) {
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
        return "Orange de " + origine.toString() + " a " + round(prix,2) + " euros";
    }

    @Override
    public String getImg() {
        return System.getProperty("user.dir") + "/ressources/" + Fruit.imgClass.get(this.getClass());
    }

    /**
     * @param o Objet à comparer
     * @return true si les oranges sont équivalentes, false sinon
     * @brief Redéfinition de la méthode equals pour les oranges
     */
    @Override
    public boolean equals(Object o) {  //predicat pour tester si 2 oranges sont equivalentes
        if (o != null && getClass() == o.getClass()) {
            Orange or = (Orange) o;
            return (prix == or.prix && origine.equals(or.origine));
        }
        return false;
    }

    /**
     * @return false
     * @brief Redéfinition de la méthode isSeedless pour les oranges
     */
    public boolean isSeedless() {  //predicat indiquant qu'une orange a des pepins
        return false;
    }
}
