package org.vanadium.model.Macedoine;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy BARRANCO
 * @author Julie PRIGENT
 */
public class MacedoineVideException extends RuntimeException {

    /**
     * @brief Constructeur de l'exception MacedoineVideException sans paramètres
     */
    public MacedoineVideException() {
        super("Suppression impossible car la macedoine est vide !");
    }
}
