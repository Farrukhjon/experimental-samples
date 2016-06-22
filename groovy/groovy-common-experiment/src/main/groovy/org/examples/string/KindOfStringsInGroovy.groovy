package org.examples.string

class KindOfStringsInGroovy {

	static main(args) {
		def singleQuote = 'single quoted string';
		def doubleQuote = "double quoted string";
		def tripleQuote = ''' triple quoted string '''

		assert (singleQuote instanceof String) == true
		assert (doubleQuote instanceof String) == true
		assert (tripleQuote instanceof String) == true
		
		def gstring = "${doubleQuote}"
		assert(gstring instanceof GString) == true
	}
}
