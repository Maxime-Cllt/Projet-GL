package org.vanadium.interfaces;

import org.vanadium.controler.ControleurBtn;

import java.util.Observable;
import java.util.Observer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Maxime Colliat
 * @author Yoan DUSOLEIL
 * @author Rahman YILMAZ
 * @author Rémy BARRANCO
 * @author Julie PRIGENT
 */
public interface VueG extends Observer {
    @Override
    void update(Observable m, Object o);

    void addControleur(ControleurBtn c);

}
