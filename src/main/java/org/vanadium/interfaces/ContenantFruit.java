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
    
    public abstract HashMap<Fruit, Double> getFruits();
    
    public abstract void setFruits(HashMap<Fruit, Double> fruits);
    
    public abstract int getTailleContenant();
    
    public abstract Fruit getFruit(int i);
    
    public abstract void ajout(Map.Entry<Fruit, Double> fruitQuantity);
    
    public abstract void retrait();
    
    public abstract double getPrixTotal();
    
    public abstract void boycotteOrigine(Fruit.Pays origine);
    
    
    
    
    
    
    
    
    
}
