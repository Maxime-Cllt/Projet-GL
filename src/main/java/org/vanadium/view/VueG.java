package org.vanadium.view;

import org.vanadium.controler.ControleurBtn;

import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author celine
 */
public interface VueG extends Observer {
    @Override
    public void update(Observable m, Object o);
    public void addControleur(ControleurBtn c);
    
}
