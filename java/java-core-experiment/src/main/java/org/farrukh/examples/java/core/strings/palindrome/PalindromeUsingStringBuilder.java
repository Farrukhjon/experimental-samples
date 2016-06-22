package org.farrukh.examples.java.core.strings.palindrome;


public class PalindromeUsingStringBuilder {

    public boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return reversed.equals(str);
    }

}
