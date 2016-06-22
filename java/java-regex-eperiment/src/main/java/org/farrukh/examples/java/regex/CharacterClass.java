package org.farrukh.examples.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterClass {

    // [] - the character class

    public static void main(String[] args) {
        // matching any one of several character
        String[] strings = {"seperate", "separate", "separete"};
        String regex = "sep[ea]r[ea]te";
        Pattern compile = Pattern.compile(regex);
        for (int i = 0; i < strings.length; i++) {
            Matcher matcher = compile.matcher(strings[i]);
            boolean result = matcher.matches();
            System.out.println(result);
        }

    }

}
