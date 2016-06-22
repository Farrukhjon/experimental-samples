package org.farrukh.examples.java.networking.inetAddress

import org.farrukh.examples.java.networking.BaseUnitTest

/**
 * Unit test for learning InetAddress.
 * InetAddress class represents an Internet Protocol (IP) address.
 */
class InetAddressTest extends BaseUnitTest {

    def 'should test creating IntedAddress using getByName method'() {
        given: 'host data for test'
        def host = 'localhost'

        when: 'get host by name is called'
        def localInetAddress = InetAddress.getByName(host)

        then: 'expected result is returned'
        localInetAddress
        localInetAddress.getHostName() == host
        localInetAddress.getHostAddress() == '127.0.0.1'
    }

    def 'should test creating IntedAddress using getLocalHost method'() {
        given: 'system name and ip address of current machine'
        def expectedHost = 'Asus'
        def expectedIPAddress = '10.102.15.132'

        when: 'get local host is called (from the system)'
        def localInetAddress = InetAddress.getLocalHost()

        then: 'expected result is returned'
        localInetAddress
        localInetAddress.getHostName() == expectedHost
        localInetAddress.getHostAddress() == expectedIPAddress
    }


}
