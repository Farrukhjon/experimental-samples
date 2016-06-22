package org.farrukh.examples.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectMatcherGroup {

    public static void main(String[] args) {
        String someString = "hello132  123456";
        String strRegex = "(\\w{5})(\\d{3})(\\s{2})(\\d{6})";
        Pattern pattern = Pattern.compile(strRegex);
        Matcher matcher = pattern.matcher(someString);
        int groupCount = matcher.groupCount();
        boolean resultMatches = matcher.matches();
        if (resultMatches) {
            System.out.println("Correct matching");
            for (int i = 0; i < groupCount; i++) {
                String group = matcher.group(i);
                System.out.println(group);
            }
        }
        System.out.println(groupCount);
    }

}
