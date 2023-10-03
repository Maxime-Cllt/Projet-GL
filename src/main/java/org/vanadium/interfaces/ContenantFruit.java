/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.vanadium.interfaces;

import java.util.HashMap;
import java.util.Map;
import org.vanadium.interfaces.Fruit;
import java.util.Observable;

import org.vanadium.model.panier.PanierPleinException;
import org.vanadium.model.panier.PanierVideException;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy Barranco
 * @author Julie Prigent
 */

public interface ContenantFruit {
    
    public HashMap<Fruit, Double> getFruits();
    
    public void setFruits(HashMap<Fruit, Double> fruits);
    
    public int getTailleContenant();

    public Fruit getFruit(int i);
    
    public void ajout(Map.Entry<Fruit, Double> fruitQuantity);
    
    public void retrait();
    
    public boolean estVide();
    
    public double getPrixTotal();
    
    public void boycotteOrigine(Fruit.Pays origine);
    
    public void retrait(Fruit o);
}
