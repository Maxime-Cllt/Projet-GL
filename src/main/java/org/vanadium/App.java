/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vanadium;

import org.vanadium.controler.ControleurMainWindow;
import org.vanadium.interfaces.VueG;
import org.vanadium.model.ContenantFruitAbstract;
import org.vanadium.model.Jus.Jus;
import org.vanadium.model.Macedoine.Macedoine;
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

    public App() {
        vueg = new MainWindow();
        controleur = new ControleurMainWindow();
        ContenantFruitAbstract modele = new Macedoine();
        VueConsole vuec = new VueConsole();

        controleur.setModele(modele);
        modele.addObserver(vueg);
        modele.addObserver(vuec);
        vueg.addControleur(controleur);
    }

    public static void main(String[] args){
        App test = new App();
    }
}
