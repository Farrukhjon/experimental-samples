package org.farrukh.examples.java.networking.inetAddress

import org.farrukh.examples.java.networking.BaseUnitTest

/**
 * Unit level test for learning InetSocketAddressTest class.
 * InetSocketAddressTest implements IP Socket Address (IP address + port number).
 */
class InetSocketAddressTest extends BaseUnitTest {

    def 'should test create InetSocketAddress by InetAddress and port'() {
        given:
        def localHost = 'localhost'
        def mysqlPort = 3306

        and:
        def inetAddress = InetAddress.getByName(localHost)

        when: 'sut is created'
        def inetSocketAddress = new InetSocketAddress(inetAddress, mysqlPort)

        then: 'expected result is returned'
        inetSocketAddress.getPort() == mysqlPort
        inetSocketAddress.getHostName() == localHost
    }
}
