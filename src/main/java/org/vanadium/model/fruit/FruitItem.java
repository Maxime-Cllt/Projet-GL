package org.vanadium.model.fruit;

import org.vanadium.interfaces.Fruit;

public class FruitItem {
    private final Fruit fruit;
    private final double quantity;

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

    public double getQuantity() {
        return quantity;
    }

    public String toString() {
        return quantity + " kg de " + fruit.toString();
    }
}
