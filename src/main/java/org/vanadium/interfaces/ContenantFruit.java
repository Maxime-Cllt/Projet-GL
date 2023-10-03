/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.vanadium.interfaces;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy Barranco
 * @author Julie Prigent
 */

public interface ContenantFruit {

    HashMap<Fruit, Double> getFruits();

    void setFruits(HashMap<Fruit, Double> fruits);

    int getTailleContenant();

    Fruit getFruit(int i);

    void ajout(Map.Entry<Fruit, Double> fruitQuantity);

    void ajout(Fruit f, Double quantity);

    void retrait();

    void retrait(Fruit o);

    boolean estVide();

    double getPrixTotal();

    void boycotteOrigine(Fruit.Pays origine);


}
