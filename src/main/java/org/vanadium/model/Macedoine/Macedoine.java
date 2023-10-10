/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.vanadium.model.Macedoine;

import org.vanadium.interfaces.Fruit;
import org.vanadium.model.ContenantFruitAbstract;
import org.vanadium.model.panier.PanierVideException;

import java.util.HashMap;
import java.util.Map;

import static org.vanadium.model.Utils.round;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy BARRANCO
 * @author Julie PRIGENT
 */

public class Macedoine extends ContenantFruitAbstract {
    private HashMap<Fruit, Double> fruits;

    /**
     * @brief Constructeur de la classe Macedoine qui permet d'initialiser les attributs
     */
    public Macedoine() {
        fruits = new HashMap<>();

    }

    /**
     * @return String
     * @brief Méthode toString de la classe Macedoine qui permet d'afficher le contenu de la macedoine
     */
    @Override
    public String toString() {
        return "Macedoine{" +
                "fruits=" + fruits +
                '}';
    }


    /**
     * @return HashMap<Fruit, Double>
     * @brief Méthode qui permet de récupérer les fruits de la macedoine
     */
    @Override
    public HashMap<Fruit, Double> getFruits() {
        return fruits;
    }

    /**
     * @param fruits
     * @brief Méthode qui permet de modifier les fruits de la macedoine
     */
    @Override
    public void setFruits(HashMap<Fruit, Double> fruits) {
        this.fruits = fruits;
    }

    /**
     * @return int
     * @brief Méthode qui permet de récupérer la taille de la macedoine
     */
    @Override
    public int getTailleContenant() {
        return fruits.size();
    }

    /**
     * @param i
     * @return Fruit
     * @brief Méthode qui permet de récupérer un fruit de la macedoine
     */
    @Override
    public Fruit getFruit(int i) {
        return (Fruit) fruits.keySet().toArray()[i];
    }

    /**
     * @return boolean
     * @brief Méthode qui permet de savoir si la macedoine est vide
     */
    @Override
    public boolean estVide() {
        return fruits.isEmpty();
    }

    /**
     * @param fruitQuantity
     * @brief Méthode qui permet d'ajouter un fruit dans la macedoine
     */
    @Override
    public void ajout(Map.Entry<Fruit, Double> fruitQuantity) {
        if (fruits.containsKey(fruitQuantity.getKey())) {
            return;
        }
        fruits.put(fruitQuantity.getKey(), fruitQuantity.getValue());
        setChanged();
        notifyObservers(this);
    }

    /**
     * @param f
     * @param quantity
     * @brief Méthode qui permet d'ajouter un fruit dans la macedoine
     */
    @Override
    public void ajout(Fruit f, Double quantity) {
        Map.Entry<Fruit, Double> fruitQuantity = Map.entry(f, quantity);
        ajout(fruitQuantity);
    }

    /**
     * @throws PanierVideException
     * @brief Méthode qui permet de retirer un fruit de la macedoine
     */
    @Override
    public void retrait() {
        if (fruits.isEmpty()) {
            throw new MacedoineVideException();
        }
        fruits.remove(fruits.keySet().toArray()[fruits.size() - 1]);
        setChanged();
        notifyObservers(this);
    }

    /**
     * @param o
     * @brief Méthode qui permet de retirer un fruit de la macedoine
     */
    @Override
    public void retrait(Fruit o) {
        fruits.remove(o);
        setChanged();
        notifyObservers(this);
    }

    /**
     * @return double
     * @brief Méthode qui permet de calculer le prix de la macedoine
     */
    @Override
    public double getPrixTotal() {
        double prix = 0;
        for (Map.Entry<Fruit, Double> fruitQuantity : fruits.entrySet()) {
            prix += fruitQuantity.getKey().getPrix() * fruitQuantity.getValue();
        }
        return round(prix, 2);

    }

    /**
     * @param origine
     * @brief Méthode qui permet de boycotter un fruit
     */
    @Override
    public void boycotteOrigine(Fruit.Pays origine) {
        fruits.entrySet().removeIf(item -> item.getKey().getOrigine() == origine);
        setChanged();
        notifyObservers(this);
    }

    @Override
    public double getPoidsTotal() {
        double poidsTotal = 0;
        for (Map.Entry<Fruit, Double> fruitQuantity : fruits.entrySet()) {
            poidsTotal += fruitQuantity.getValue();
        }
        return round(poidsTotal, 2);
    }

    public void notifier() {
        setChanged();
        notifyObservers(this);
    }

    /**
     * @param o
     * @return boolean
     * @brief Méthode qui permet de comparer deux macedoines
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && getClass() == o.getClass()) {
            Macedoine m = (Macedoine) o;
            int compt = 0;
            if (m.fruits.size() == this.fruits.size()) {
                for (Map.Entry<Fruit, Double> fruitQuantity : fruits.entrySet()) {
                    if (m.fruits.containsKey(fruitQuantity.getKey())) {
                        compt++;
                    }
                }
                return compt == m.fruits.size();
            }
        }
        return false;
    }


}
