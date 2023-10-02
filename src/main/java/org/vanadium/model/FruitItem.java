package org.vanadium.model;

import org.vanadium.model.panier.Fruit;

public class FruitItem {
    private Fruit fruit;

    public Fruit getFruit() {
        return fruit;
    }

    public double getQuantity() {
        return quantity;
    }

    private double quantity;

    public FruitItem(Fruit fruit, double quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public String toString() {
        return quantity + " kg de " + fruit.toString();
    }
}
