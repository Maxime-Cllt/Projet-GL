package org.vanadium.model.panier;

import java.util.*;

/**
  * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy Barranco
 */
public class Panier extends Observable {
    private ArrayList<Fruit> fruits;  //attribut pour stocker les fruits
    private int contenanceMax;        //nb maximum d'oranges que peut contenir le panier

    //groupe 1
    public Panier(int contenanceMax) {  //initialise un panier vide ayant une certaine contenance maximale (precisee en parametre)
        fruits = new ArrayList<Fruit>();
        this.contenanceMax = contenanceMax;
    }

    @Override
    public String toString() {  //affichage de ce qui est contenu dans le panier : liste des fruits presents
        return "";
    }

    //groupe 2
    public ArrayList<Fruit> getFruits() {  //accesseur du premier attribut
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) { //modificateur du premier attribut
        this.fruits = fruits;
    }

    public int getTaillePanier() {  //accesseur retournant la taille allouee pour l'attibut fruits
        return fruits.size();
    }

    public int getContenanceMax() {  //accesseur du second attribut
        return contenanceMax;
    }

    //groupe 3
    public Fruit getFruit(int i) {  //accesseur retournant le fruit contenu dans le panier a l'emplacement n°i ou null s'il n'y a rien a cet emplacement
        return fruits.get(i);
    }

    public void setFruit(int i, Fruit f) {  //modificateur du fruit contenu dans le panier a l'emplacement n°i par f (s'il y a bien deja un fruit a cet emplacement, ne rien faire sinon)
        fruits.set(i, f);
    }

    public boolean estVide() {  //predicat indiquant que le panier est vide
        return fruits.isEmpty();
    }

    public boolean estPlein() {  //predicat indiquant que le panier est plein
        return fruits.size() == contenanceMax;
    }

    //groupe 4
    public void ajout(Fruit o) throws PanierPleinException {  //ajoute le fruit o a la fin du panier si celui-ci n'est pas plein
        if (fruits.contains(o)) {
            return;
        }
        if (fruits.size() < contenanceMax) {
            fruits.add(o);
        } else {
            throw new PanierPleinException();
        }
        setChanged();
        notifyObservers(this);
    }

    //groupe 5
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

    //groupe 6
    public double getPrix() {  //calcule le prix du panier par addition des prix de tous les fruits contenus dedans

        double prix = 0;
        for (Fruit f : fruits) {
            prix += f.getPrix();
        }
        return prix;
    }

    //groupe 7
    public void boycotteOrigine(String origine) {  //supprime du panier tous les fruits provenant du pays origine
        for (Fruit f : fruits) {
            if (f.getOrigine().equals(origine)) {
                fruits.remove(f);
            }
        }
    }

    //groupe 8    
    @Override
    public boolean equals(Object o) {  ///predicat pour tester si 2 paniers sont equivalents : s'ils contiennent exactement les memes fruits
        if (o != null && getClass() == o.getClass()) {
            Panier p = (Panier) o;
            int compt = 0;
            if (p.fruits.size() == this.fruits.size()) {
                for (Fruit f : p.fruits) {
                    if (this.fruits.contains(f)) {
                        System.out.println(f);
                        compt++;
                    }
                }
                return compt == p.fruits.size();
            }
        }
        return false;
    }
}
