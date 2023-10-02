/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vanadium;

import org.vanadium.controler.ControleurBtn;
import org.vanadium.model.panier.Panier;
import org.vanadium.model.panier.PanierPleinException;
import org.vanadium.view.MainWindow;
import org.vanadium.view.VueConsole;
import org.vanadium.view.VueG;

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy Barranco
 * @author Julie Prigent
 */
public class App {
    private final VueG vueg;
    private final ControleurBtn controleur;

    public App() throws PanierPleinException {
        vueg = new MainWindow();
        controleur = new ControleurBtn();
        Panier modele = new Panier(100);
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
