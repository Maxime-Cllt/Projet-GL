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
    
    public Jus(){
        fruits = new HashMap<>();
    }
    
    @Override
    public String toString() {
        return "Jus{" +
                "fruits=" + fruits +
                '}';
    }
    @Override
    public HashMap<Fruit, Double> getFruits() {
        return fruits;
    }

    @Override
    public void setFruits(HashMap<Fruit, Double> fruits) {
        this.fruits = fruits;
    }

    @Override
    public int getTailleContenant() {
        return fruits.size();
    }

    @Override
    public Fruit getFruit(int i) {
        return (Fruit) fruits.keySet().toArray()[i];
    }
    
    @Override
    public boolean estVide() {
        return fruits.isEmpty();
    }

    @Override
    public void ajout(Map.Entry<Fruit, Double> fruitQuantity) {
        if (fruits.containsKey(fruitQuantity.getKey())) {
            return;
        }
        setChanged();
        notifyObservers(this);
    }

    @Override
    public void retrait() {
        if (fruits.isEmpty()) {
            throw new PanierVideException();
        }
        fruits.remove(fruits.keySet().toArray()[fruits.size() - 1]);
        setChanged();
        notifyObservers(this);
    }

    @Override
    public double getPrixTotal() {
        double prix = 0;
        for (Map.Entry<Fruit, Double> fruitQuantity : fruits.entrySet()) {
            prix += fruitQuantity.getKey().getPrix() * fruitQuantity.getValue();
        }
        return round(prix, 2);

    }

    @Override
    public void boycotteOrigine(Fruit.Pays origine) {
        for (Map.Entry<Fruit, Double> fruitQuantity : fruits.entrySet()) {
            if (fruitQuantity.getKey().getOrigine() == origine) {
                fruits.remove(fruitQuantity.getKey());
            }
        }
    }

    @Override
    public void retrait(Fruit o) {
        fruits.remove(o);
        setChanged();
        notifyObservers(this);
    }
    
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