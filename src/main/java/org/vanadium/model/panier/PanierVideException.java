package org.vanadium.model.panier;

/**
 *
  * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy Barranco
 */
public class PanierVideException extends Exception {
    public PanierVideException()
    {
	super("Suppression impossible car le panier est vide !");
    }
}
