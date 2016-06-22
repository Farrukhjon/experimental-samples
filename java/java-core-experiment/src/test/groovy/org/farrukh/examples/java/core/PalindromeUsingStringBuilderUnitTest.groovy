package org.farrukh.examples.java.core

import org.farrukh.examples.java.core.strings.palindrome.PalindromeUsingStringBuilder
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Unit level test for testing if passed string is palindrome.
 */
class PalindromeUsingStringBuilderUnitTest extends Specification {

    @Unroll
    def 'should returns true if #name is palindrome'() {
        given:
        def sut = new PalindromeUsingStringBuilder()

        when:
        result = sut.isPalindrome(name)

        then:
        result

        where:
        name    || result
        'aba'   || true
        'aziza' || true
    }

    @Unroll
    def 'should returns false if #name is not palindrome'() {
        given:
        def sut = new PalindromeUsingStringBuilder()

        when:
        result = sut.isPalindrome(name)

        then:
        !result

        where:
        name   || result
        'dodo' || true
        'ali'  || false
    }
}
