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

    /**
     * @param contenanceMax
     * @brief Constructeur par défaut
     */
    public Panier(int contenanceMax) {
        fruits = new HashMap<>();
        this.contenanceMax = contenanceMax;
    }

    /**
     * @return String
     * @brief Méthode toString de la classe Panier qui affiche le contenu du panier et sa contenance maximale
     */
    @Override
    public String toString() {
        return "Panier{" +
                "fruits=" + fruits +
                ", contenanceMax=" + contenanceMax +
                '}';
    }

    //groupe 2
    public HashMap<Fruit,Double> getFruits() {  //accesseur du premier attribut
    /**
     * @return ArrayList<Fruit> la liste des fruits du panier
     * @brief Accesseur du premier attribut (nb d'oranges max dans le panier)
     */
    public ArrayList<Fruit> getFruits() {  //accesseur du premier attribut
        return fruits;
    }

    /**
     * @param fruits la nouvelle liste de fruits du panier
     * @brief Modificateur du premier attribut (nb d'oranges max dans le panier)
     */
    public void setFruits(HashMap<Fruit,Double> fruits) { //modificateur du premier attribut
        this.fruits = fruits;
    }

    /**
     * @return int la taille du panier
     * @brief Accesseur du second attribut (nb d'oranges max dans le panier)
     */
    public int getTaillePanier() {  //accesseur retournant la taille allouee pour l'attibut fruits
        return fruits.size();
    }

    /**
     * @return int la contenance maximale du panier
     * @brief Modificateur du second attribut
     */
    public int getContenanceMax() {  //accesseur du second attribut
        return contenanceMax;
    }

        /**
         * @param i la nouvelle contenance maximale du panier
         * @return boolean true si la contenance a pu etre modifiee, false sinon
         * @brief Modificateur du second attribut
         */
    public Fruit getFruit(int i) {
        return (Fruit) fruits.keySet().toArray()[i];
    }

    /**
     * @return boolean true si le panier est vide, false sinon
     * @brief Predicat indiquant que le panier est vide
     */
    public boolean estVide() {  //predicat indiquant que le panier est vide
        return fruits.isEmpty();
    }

    /**
     * @return boolean true si le panier est plein, false sinon
     * @brief Predicat indiquant que le panier est plein
     */
    public boolean estPlein() {  //predicat indiquant que le panier est plein
        return fruits.size() == contenanceMax;
    }

    public void ajout(Map.Entry<Fruit,Double> fruitQuantity) throws PanierPleinException {  //ajoute le fruit o a la fin du panier si celui-ci n'est pas plein
        if (fruits.containsKey(fruitQuantity.getKey())) {

    /**
     * @param o le fruit à ajouter au panier
     * @throws PanierPleinException si le panier est plein
     * @brief Ajoute le fruit o a la fin du panier si celui-ci n'est pas plein
     */
    public void ajout(Fruit o) throws PanierPleinException {  //ajoute le fruit o a la fin du panier si celui-ci n'est pas plein
        if (fruits.contains(o)) {
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

    /**
     * @throws PanierVideException si le panier est vide
     * @brief Retire le dernier fruit du panier si celui-ci n'est pas vide
     */
    public void retrait() throws PanierVideException { //retire le dernier fruit du panier si celui-ci n'est pas vide
        if (fruits.isEmpty()) {
            throw new PanierVideException();
        }
        fruits.remove(fruits.size() - 1);
        setChanged();
        notifyObservers(this);
    }

    /**
     * @param o le fruit à retirer du panier
     * @brief Retire le fruit o du panier s'il s'y trouve (on ne considère pas qu'il peut y en avoir plusieurs fois le meme fruit dans le panier)
     */
    public void retrait(Fruit o) { //retire le fruit o du panier s'il s'y trouve (on ne considère pas qu'il peut y en avoir plusieurs fois le meme fruit dans le panier)
        fruits.remove(o);
        setChanged();
        notifyObservers(this);
    }


    /**
     * @return double le prix du panier
     * @brief Retire du panier tous les fruits
     */
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
    /**
     * @param origine le pays à boycotter dans le panier
     * @brief Retire du panier tous les fruits provenant du pays origine
     */
    public void boycotteOrigine(String origine) {  //supprime du panier tous les fruits provenant du pays origine
        fruits.removeIf(f -> {
            f.getOrigine();
            return false;
        });
    }

    /**
     * @param o le panier a comparer
     * @return boolean true si les 2 paniers contiennent exactement les memes fruits, false sinon
     * @brief Compare 2 paniers de fruits et retourne true s'ils contiennent exactement les memes fruits, false sinon
     */
    @Override
    public boolean equals(Object o) {
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
