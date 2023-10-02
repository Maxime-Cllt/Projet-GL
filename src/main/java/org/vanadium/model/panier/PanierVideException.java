package org.vanadium.model.panier;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy BARRANCO
 * @author Julie PRIGENT
 */
public class PanierVideException extends Exception {

    /**
     * @brief Constructeur de l'exception PanierVideException sans paramètres
     */
    public PanierVideException() {
        super("Suppression impossible car le panier est vide !");
    }
}
