package org.vanadium.model.panier;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

import static org.vanadium.model.Utils.round;


/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy Barranco
 * @author Julie Prigent
 */
public class Panier extends Observable {
    private final int contenanceMax;
    private HashMap<Fruit, Double> fruits;

    /**
     * @brief Constructeur de la classe Panier qui permet d'initialiser les attributs de la classe Panier
     */
    public Panier(int contenanceMax) {
        fruits = new HashMap<>();
        this.contenanceMax = contenanceMax;
    }

    /**
     * @return String
     * @brief Méthode toString de la classe Panier qui permet d'afficher le contenu du panier
     */
    @Override
    public String toString() {
        return "Panier{" +
                "fruits=" + fruits +
                ", contenanceMax=" + contenanceMax +
                '}';
    }

    /**
     * @return HashMap<Fruit, Double>
     * @brief Méthode qui permet de récupérer les fruits du panier
     */
    public HashMap<Fruit, Double> getFruits() {
        return fruits;
    }

    /**
     * @param fruits
     * @brief Méthode qui permet de modifier les fruits du panier
     */
    public void setFruits(HashMap<Fruit, Double> fruits) {
        this.fruits = fruits;
    }

    /**
     * @return int
     * @brief Méthode qui permet de récupérer la taille du panier
     */
    public int getTaillePanier() {
        return fruits.size();
    }

    /**
     * @return int
     * @brief Méthode qui permet de récupérer la contenance maximale du panier
     */
    public int getContenanceMax() {
        return contenanceMax;
    }

    /**
     * @param i
     * @return Fruit
     * @brief Méthode qui permet de récupérer un fruit du panier
     */
    public Fruit getFruit(int i) {
        return (Fruit) fruits.keySet().toArray()[i];
    }

    /**
     * @return boolean
     * @brief Méthode qui permet de savoir si le panier est vide
     */
    public boolean estVide() {
        return fruits.isEmpty();
    }

    /**
     * @return boolean
     * @brief Méthode qui permet de savoir si le panier est plein
     */
    public boolean estPlein() {
        return fruits.size() == contenanceMax;
    }

    /**
     * @param fruitQuantity
     * @throws PanierPleinException
     * @brief Méthode qui permet d'ajouter un fruit dans le panier
     */
    public void ajout(Map.Entry<Fruit, Double> fruitQuantity) throws PanierPleinException {
        if (fruits.containsKey(fruitQuantity.getKey())) {
            return;
        }
        if (fruits.size() < contenanceMax) {
            fruits.put(fruitQuantity.getKey(), fruitQuantity.getValue());
        } else {
            throw new PanierPleinException();
        }
        setChanged();
        notifyObservers(this);
    }

    /**
     * @throws PanierVideException
     * @brief Méthode qui permet de retirer un fruit du panier
     */
    public void retrait() throws PanierVideException {
        if (fruits.isEmpty()) {
            throw new PanierVideException();
        }
        fruits.remove(fruits.keySet().toArray()[fruits.size() - 1]);
        setChanged();
        notifyObservers(this);
    }

    /**
     * @param o
     * @brief Méthode qui permet de retirer un fruit du panier
     */
    public void retrait(Fruit o) {
        fruits.remove(o);
        setChanged();
        notifyObservers(this);
    }

    /**
     * @return double
     * @brief Méthode qui permet de calculer le prix du panier
     */
    public double getPrixTotal() {
        double prix = 0;
        for (Map.Entry<Fruit, Double> fruitQuantity : fruits.entrySet()) {
            prix += fruitQuantity.getKey().getPrix() * fruitQuantity.getValue();
        }
        return round(prix,2);
    }

    /**
     * @param origine
     * @brief Méthode qui permet de boycotter un fruit
     */
    public void boycotteOrigine(Fruit.Pays origine) {
        for (Map.Entry<Fruit, Double> fruitQuantity : fruits.entrySet()) {
            if (fruitQuantity.getKey().getOrigine() == origine) {
                fruits.remove(fruitQuantity.getKey());
            }
        }
    }

    /**
     * @param o
     * @return boolean
     * @brief Méthode qui permet de comparer deux paniers
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && getClass() == o.getClass()) {
            Panier p = (Panier) o;
            int compt = 0;
            if (p.fruits.size() == this.fruits.size()) {
                for (Map.Entry<Fruit, Double> fruitQuantity : fruits.entrySet()) {
                    if (p.fruits.containsKey(fruitQuantity.getKey())) {
                        compt++;
                    }
                }
                return compt == p.fruits.size();
            }
        }
        return false;
    }
}