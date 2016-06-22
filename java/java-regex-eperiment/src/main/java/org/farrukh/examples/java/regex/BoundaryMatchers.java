package org.farrukh.examples.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoundaryMatchers {

    public static void main(String[] args) {
        String str = "dsjakdsalkdnsaklhello!fsdkfhdsfdsjfhs";
        String boundRegex = "^hello!$";
        Pattern pattern = Pattern.compile(boundRegex);
        Matcher matcher = pattern.matcher(str);
        String s = matcher.toString();
        matcher.matches();
        System.out.println(s);
    }

}
