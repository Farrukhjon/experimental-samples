package org.farrukh.examples.java.core.strings.palindrome;

public class InternedString {

    public static void main(String[] args) {
        String greeting = "Hello";
        String internOfGreeting = greeting.intern();

        System.out.printf("%s %s", "String interning is: ", greeting.equals(internOfGreeting));
        System.out.println();
        System.out.printf("%s %s", "String interning is: ", greeting == internOfGreeting);
        System.out.println();
        System.out.printf("%s %s", "String interning is: ", greeting.hashCode() == internOfGreeting.hashCode());

        System.out.println("Interning implicitly, by compiler:");

        String world1 = "World";

        String world2 = "World";

        System.out.printf("%s %s", "String interning is: ", world1.equals(world2));
        System.out.println();
        System.out.printf("%s %s", "String interning is: ", world1 == world2);
        System.out.println();
        System.out.printf("%s %s", "String interning is: ", world1.hashCode() == world2.hashCode());


    }

}
