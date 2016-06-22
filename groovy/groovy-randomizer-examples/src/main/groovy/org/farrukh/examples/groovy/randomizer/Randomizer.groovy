package org.farrukh.examples.groovy.randomizer

import java.security.SecureRandom

/**
 * Randomizer object for various goals.
 */
class Randomizer {

    SecureRandom random = new SecureRandom()

    /**
     * Generates and returns random integer.
     * @return
     */
    int randomInteger() {
        random.nextInt()
    }

    /**
     * Generates and returns randomized list.
     * @param size - The size of the list.
     * @return random list.
     */
    List randomIntList(int size) {
        List randomList = []
        for (int i = 0; i < size; i++) {
            randomList[i] = random.nextInt(10)
        }
        randomList
    }

    /**
     * Generates and returns randomized bounded list.
     * @param size - the sizeof the list
     * @param bound - the bound of the list
     * @return random list
     */
    List randomIntList(int size, int bound) {
        List randomList = []
        for (int i = 0; i < size; i++) {
            randomList[i] = random.nextInt(bound)
        }
        randomList
    }

    List<Integer> randomizeList(List<Integer> aList) {
        Collections.shuffle(aList)
        aList
    }
}
