/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.vanadium.model.Jus;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import org.vanadium.interfaces.ContenantFruit;
import org.vanadium.interfaces.Fruit;
import static org.vanadium.model.Utils.round;
import org.vanadium.model.panier.PanierVideException;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy BARRANCO
 * @author Julie PRIGENT
 */
public class Jus extends Observable implements ContenantFruit{
    private HashMap<Fruit, Double> fruits;
        /**
     * @brief Constructeur de la classe Jus qui permet d'initialiser les attributs 
     */
    public Jus(){
        fruits = new HashMap<>();
    }
    
        /**
     * @return String
     * @brief Méthode toString de la classe jus qui permet d'afficher le contenu du jus
     */
    @Override
    public String toString() {
        return "Jus{" +
                "fruits=" + fruits +
                '}';
    }
    
    
    /**
     * @return HashMap<Fruit, Double>
     * @brief Méthode qui permet de récupérer les fruits du jus
     */
    @Override
    public HashMap<Fruit, Double> getFruits() {
        return fruits;
    }

        /**
     * @param fruits
     * @brief Méthode qui permet de modifier les fruits du jus
     */
    @Override
    public void setFruits(HashMap<Fruit, Double> fruits) {
        this.fruits = fruits;
    }

    
    /**
     * @return int
     * @brief Méthode qui permet de récupérer la taille du jus 
     */
    @Override
    public int getTailleContenant() {
        return fruits.size();
    }

    /**
     * @param i
     * @return Fruit
     * @brief Méthode qui permet de récupérer un fruit du jus
     */
    @Override
    public Fruit getFruit(int i) {
        return (Fruit) fruits.keySet().toArray()[i];
    }
    
     /**
     * @return boolean
     * @brief Méthode qui permet de savoir si le jus est vide
     */
    @Override
    public boolean estVide() {
        return fruits.isEmpty();
    }

    
    /**
     * @param fruitQuantity
     * @throws PanierPleinException
     * @brief Méthode qui permet d'ajouter un fruit dans le jus
     */
    @Override
    public void ajout(Map.Entry<Fruit, Double> fruitQuantity) {
        if (fruits.containsKey(fruitQuantity.getKey())) {
            return;
        }
        setChanged();
        notifyObservers(this);
    }

   /**
     * @throws PanierVideException
     * @brief Méthode qui permet de retirer un fruit du jus
     */
    @Override
    public void retrait() {
        if (fruits.isEmpty()) {
            throw new PanierVideException();
        }
        fruits.remove(fruits.keySet().toArray()[fruits.size() - 1]);
        setChanged();
        notifyObservers(this);
    }

     /**
     * @param o
     * @brief Méthode qui permet de retirer un fruit du jus
     */
    @Override
    public void retrait(Fruit o) {
        fruits.remove(o);
        setChanged();
        notifyObservers(this);
    }
    
     /**
     * @return double
     * @brief Méthode qui permet de calculer le prix du jus
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
        for (Map.Entry<Fruit, Double> fruitQuantity : fruits.entrySet()) {
            if (fruitQuantity.getKey().getOrigine() == origine) {
                fruits.remove(fruitQuantity.getKey());
            }
        }
    }
    
     /**
     * @param o
     * @return boolean
     * @brief Méthode qui permet de comparer deux jus de fruit
     */
    @Override
    public boolean equals(Object o) {
        if (o != null && getClass() == o.getClass()) {
            Jus j = (Jus) o;
            int compt = 0;
            if (j.fruits.size() == this.fruits.size()) {
                for (Map.Entry<Fruit, Double> fruitQuantity : fruits.entrySet()) {
                    if (j.fruits.containsKey(fruitQuantity.getKey())) {
                        compt++;
                    }
                }
                return compt == j.fruits.size();
            }
        }
        return false;
    }
    
    
}
