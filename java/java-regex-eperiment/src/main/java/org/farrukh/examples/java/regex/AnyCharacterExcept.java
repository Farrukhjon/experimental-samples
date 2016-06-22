package org.farrukh.examples.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnyCharacterExcept {

    public static void main(String[] args) {
        String str = "HelloWorld!";
        String regEx = "^HelloWorld!$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        boolean matches = matcher.matches();
        System.out.println(matches);
    }

}
