package org.farrukh.experiment.formatting;

import java.text.NumberFormat;
import java.util.Locale;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public String toCommaSeparated(String strNumber) {
        return NumberFormat.getNumberInstance(Locale.US).format(Double.valueOf(strNumber));
    }

}
