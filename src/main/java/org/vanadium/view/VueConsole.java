/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vanadium.view;

import org.vanadium.model.panier.Panier;

import java.util.*;

/**
 *
 * @author celine
 */
public class VueConsole implements Observer{
    private String trace;
    
    /**
     * @return the trace
     */
    public String getTrace() {
        return trace;
    }

    /**
     * @param trace the trace to set
     */
    public void setTrace(String trace) {
        this.trace = trace;
    }
    
    public VueConsole(){
        trace = "Valeur initiale : " + 0;
        System.out.println(trace);
    }
    
    public void update(Observable m, Object panier){   //This method is called whenever the observed object is changed
        trace = "Nouvelle valeur : " + ((Panier) panier).getTaillePanier();

        System.out.println(trace);
    }
}
