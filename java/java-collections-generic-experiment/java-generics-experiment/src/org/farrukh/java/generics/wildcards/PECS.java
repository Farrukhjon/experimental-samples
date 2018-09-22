package org.farrukh.java.generics.wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PECS {

    public static void main(String[] args) {

        List<Wolf> wolfs = new ArrayList<>();
        wolfs.add(new Wolf());

        List<? extends Animal> animals = wolfs;

        for (Animal animal : animals) {
            System.out.println(animal);
        }

        // animals.add(new WildAnimal()); //Compile-time error: capture#1 of ?

        List<? super Wolf> allTypeOfWolfs = wolfs;

        allTypeOfWolfs.add(new Wolf());
        allTypeOfWolfs.add(new SiberianWolf());

        for (Object wolf : allTypeOfWolfs) {
            System.out.println(wolf);
        }


    }


}

class Animal {

    public String toString() {
        return "I'm an animal";
    }

}


class WildAnimal extends Animal {
    public String toString() {
        return "I'm a wild animal";
    }
}

class Wolf extends WildAnimal {

    public String toString() {
        return "I'm a wolf";
    }

}


class SiberianWolf extends Wolf {

    public String toString() {
        return "I'm a Siberian wolf";
    }

}