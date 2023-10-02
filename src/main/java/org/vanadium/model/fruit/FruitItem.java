package org.vanadium.model.fruit;

import org.vanadium.interfaces.Fruit;

public class FruitItem {
    private Fruit fruit;
    private double quantity;

    /**
     * @param fruit
     * @param quantity
     * @brief Constructeur de FruitItem à partir d'un fruit et d'une quantité
     */
    public FruitItem(Fruit fruit, double quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return quantity + " kg de " + fruit.toString();
    }
}
