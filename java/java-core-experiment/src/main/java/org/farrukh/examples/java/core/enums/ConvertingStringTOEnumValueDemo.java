package org.farrukh.examples.java.core.enums;

public class ConvertingStringTOEnumValueDemo {

    public static void main(String[] args) {
        Gender gender = null;
        try {
            gender = Gender.valueOf("BOY");
        } catch (Exception e) {
            System.out.println("Wrong gender string value");
        }
        final Person ali = new Person(gender, "Ali");
        System.out.println(ali);
    }

}
