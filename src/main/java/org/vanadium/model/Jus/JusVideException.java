package org.vanadium.model.Jus;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy BARRANCO
 * @author Julie PRIGENT
 */
public class JusVideException extends RuntimeException {

    /**
     * @brief Constructeur de l'exception JusVideException sans paramètres
     */
    public JusVideException() {
        super("Suppression impossible car le Jus est vide !");
    }
}
