package org.vanadium.view;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VueConsoleTest {

    @Test
    void getTrace() {
        VueConsole vueConsole = new VueConsole();
        String expected = "Valeur initiale : " + 0;
        assertEquals(expected, vueConsole.getTrace());
    }

    @Test
    void setTrace() {
        VueConsole vueConsole = new VueConsole();
        String expected = "Nouvelle valeur : " + 1;
        vueConsole.setTrace(expected);
        assertEquals(expected, vueConsole.getTrace());
    }

}