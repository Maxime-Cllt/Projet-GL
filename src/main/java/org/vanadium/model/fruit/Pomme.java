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

public class Pomme implements Fruit {
    private double prix; //prix en euros
    private Pays origine; //pays d'origine

    /**
     * @brief Constructeur de la class Banane par défaut
     */
    public Pomme() {
        this.prix = 0.5;
        this.origine = Pays.INCONNU;
    }

    /**
     * @param prix    prix de la banane
     * @param origine origine de la banane
     * @brief Constructeur de la class Banane
     */
    public Pomme(double prix, Pays origine) {
        if (prix < 0)
            this.prix = -prix;
        else
            this.prix = prix;
        this.origine = origine;
    }

    public static Pays randomPays() {
        return Pays.values()[new java.util.Random().nextInt(Pays.values().length)];
    }

    /**
     * GETTERS AND SETTERS
     */

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
        return "Pomme de " + origine.toString() + " a " + round(prix, 2) + " euros";
    }

    @Override
    public String getImg() {
        return Fruit.imgClass.get(this.getClass());
    }

    /**
     * @param p Banane à comparer
     * @return true si les deux bananes sont identiques et false si elles sont différentes
     * @brief Compare deux bananes entre elles et retourne true si elles sont identiques et false si elles sont différentes
     */
    @Override
    public boolean equals(Object p) {
        if (p != null && getClass() == p.getClass()) {
            Pomme pomme = (Pomme) p;
            return (prix == pomme.getPrix() && origine.equals(pomme.getOrigine()));
        }
        return false;
    }

    /**
     * @return true si la banane n'a pas de pépins et false si elle en a.
     * @brief Indique si la banane a des pépins ou non
     */
    public boolean isSeedless() {  //predicat indiquant qu'une orange a des pepins
        return false;
    }
}

