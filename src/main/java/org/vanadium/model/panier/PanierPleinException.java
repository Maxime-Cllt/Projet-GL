package org.vanadium.model.panier;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy Barranco
 * @author Julie Prigent
 */
public class PanierPleinException extends Exception {

    /**
     * @brief Constructeur de l'exception PanierPleinException sans paramètres
     */
    public PanierPleinException() {
        super("Ajout impossible car le panier est plein !");
    }

}
