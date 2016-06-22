/**
 * 
 */
package org.farrukh.examples.spock.core

import spock.lang.Specification

/**
 * @author Farrukhjon SATTOROV
 *
 */
class FixtureMethods extends Specification {
	
	def setup() { // Like @Before in JUnit 
		println 'run before every fixture method'
	}
	
	def cleanup() { // Like @After in JUnit
		println 'run after every fixture method'
	}

	def setupSpec() { // Like @BeforeClass in JUnit
		println 'run before first fixture method'
	}

	def cleanupSpec() { // Like @AfterClass in JUnit
		println 'run after last fixture method'
	}

}
