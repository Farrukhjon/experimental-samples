package org.farrukh.examples.groovy.randomizer

import spock.lang.Specification

/**
 * The base unit test abject object.
 */
abstract class AbstractBaseUnitTest extends Specification {

    @Delegate
    Randomizer randomizer = new Randomizer()
}
