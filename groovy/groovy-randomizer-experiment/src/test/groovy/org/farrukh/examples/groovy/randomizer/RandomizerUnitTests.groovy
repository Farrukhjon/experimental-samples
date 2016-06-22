package org.farrukh.examples.groovy.randomizer
/**
 * Unit-level test for the Randomizer object.
 */
class RandomizerUnitTests extends AbstractBaseUnitTest {

    def 'exercise random integer'() {
        when: 'random integer is called'
        def result = randomInteger()

        then: 'expected result is returned'
        result
    }

    def 'exercise random list'() {
        when: 'for a random list is called'
        def randomList = randomIntList(7)

        then: 'expected random list is returned'
        randomList
        randomList.size() == 7
    }

    def 'exercise random list with bound'() {
        given: 'size and bound of the list'
        def size = 10
        def bound = 10
        when: 'for a random list is called'
        def randomList = randomIntList(size, bound)

        then: 'expected random list is returned'
        randomList
        randomList.size() == size
        randomList.every {
            it < bound
        }
    }

    def 'exercise randomizing a list'() {
        given: 'an ordered list'
        List<Integer> aList = [0, 1, 2, 3, 4, 5, 6, 7]

        when: 'randomList is called'
        def result = randomizeList(aList)

        then: 'result list should be randomized'
        result
        result != aList
    }

}
