package org.vanadium.model;

public class Utils {

    /**
     * @param value  nombre à arrondir
     * @param places nombre de chiffres après la virgule
     * @return double
     * @brief Arrondi un nombre à un nombre de chiffres après la virgule
     */
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
