package org.vanadium.model.panier;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy Barranco
 */
public class Panier extends Observable {
    private HashMap<Fruit,Double> fruits;
    private final int contenanceMax;

    public Panier(int contenanceMax) {
        fruits = new HashMap<>();
        this.contenanceMax = contenanceMax;
    }

    @Override
    public String toString() {return "";}

    //groupe 2
    public HashMap<Fruit,Double> getFruits() {  //accesseur du premier attribut
        return fruits;
    }

    public void setFruits(HashMap<Fruit,Double> fruits) { //modificateur du premier attribut
        this.fruits = fruits;
    }

    public int getTaillePanier() {  //accesseur retournant la taille allouee pour l'attibut fruits
        return fruits.size();
    }

    public int getContenanceMax() {  //accesseur du second attribut
        return contenanceMax;
    }

    public Fruit getFruit(int i) {
        return (Fruit) fruits.keySet().toArray()[i];
    }

    public boolean estVide() {  //predicat indiquant que le panier est vide
        return fruits.isEmpty();
    }

    public boolean estPlein() {  //predicat indiquant que le panier est plein
        return fruits.size() == contenanceMax;
    }

    public void ajout(Map.Entry<Fruit,Double> fruitQuantity) throws PanierPleinException {  //ajoute le fruit o a la fin du panier si celui-ci n'est pas plein
        if (fruits.containsKey(fruitQuantity.getKey())) {
            return;
        }
        if (fruits.size() < contenanceMax) {
            fruits.put(fruitQuantity.getKey(),fruitQuantity.getValue());
        } else {
            throw new PanierPleinException();
        }
        setChanged();
        notifyObservers(this);
    }

    public void retrait() throws PanierVideException { //retire le dernier fruit du panier si celui-ci n'est pas vide
        if (fruits.size() == 0) {
            throw new PanierVideException();
        }
        fruits.remove(fruits.size() - 1);
        setChanged();
        notifyObservers(this);
    }

    public void retrait(Fruit o) { //retire le fruit o du panier s'il s'y trouve (on ne considere pas qu'il peut y en avoir plusieurs fois le meme fruit dans le panier)
        fruits.remove(o);
        setChanged();
        notifyObservers(this);
    }

    public double getPrix() {  //calcule le prix du panier par addition des prix de tous les fruits contenus dedans

        double prix = 0;
        for(Map.Entry<Fruit,Double> fruitQuantity : fruits.entrySet()) {
            prix += fruitQuantity.getKey().getPrix() * fruitQuantity.getValue();
        }
        return prix;
    }

    public void boycotteOrigine(Fruit.Pays origine) {  //supprime du panier tous les fruits provenant du pays origine
        for(Map.Entry<Fruit,Double> fruitQuantity : fruits.entrySet()) {
            if (fruitQuantity.getKey().getOrigine() == origine) {
                fruits.remove(fruitQuantity.getKey());
            }
        }
    }

    @Override
    public boolean equals(Object o) {  ///predicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
        if (o != null && getClass() == o.getClass()) {
            Panier p = (Panier) o;
            int compt = 0;
            if (p.fruits.size() == this.fruits.size()) {
                for(Map.Entry<Fruit,Double> fruitQuantity : fruits.entrySet()) {
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
