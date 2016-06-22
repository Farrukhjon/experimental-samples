package org.farrukh.examples.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressMatching {

    public static void main(String[] args) {
        String ipString = "192.168.1.2";
        String ipRegEx = "\\b(?:[0-9]{1,3}\\.){3}[0-9]{1,3}\\b";
        Pattern pattern = Pattern.compile(ipRegEx);
        Matcher matcher = pattern.matcher(ipString);
        boolean resultMatching = matcher.matches();
        if (resultMatching) {
            System.out.println("The " + ipString + " is correct ipString address");
        } else {
            System.out.println("The " + ipString + " is not correct ipString address");
        }
    }

}
