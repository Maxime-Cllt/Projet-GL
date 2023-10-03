/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vanadium;

import org.vanadium.controler.ControleurMainWindow;
import org.vanadium.interfaces.VueG;
import org.vanadium.model.panier.Panier;
import org.vanadium.model.panier.PanierPleinException;
import org.vanadium.view.MainWindow;
import org.vanadium.view.VueConsole;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy BARRANCO
 * @author Julie PRIGENT
 */
public class App {
    private final VueG vueg;
    private final ControleurMainWindow controleur;

    public App() throws PanierPleinException {
        vueg = new MainWindow();
        controleur = new ControleurMainWindow();
        Panier modele = new Panier(1);
        VueConsole vuec = new VueConsole();

        controleur.setModele(modele);
        modele.addObserver(vueg);
        modele.addObserver(vuec);
        vueg.addControleur(controleur);
    }

    public static void main(String[] args) throws PanierPleinException {
        App test = new App();
    }
}
