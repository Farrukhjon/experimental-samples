package org.farrukh.examples.groovy.core.process

import static java.lang.System.err
import static java.lang.System.out

class SSHDynamicPortForwarding {

    String localhost
    int port
    String remoteHost
    String remoteUsername
    String remotePassword

//sshpass ssh -nfN -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null -D <local ip>:<local random port> <ssh user>@<ssh host> <<< '<ssh pass>'
    void executeSocks5() {
        def string = "sshpass -p ${remotePassword} ssh -nfN -o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null -D ${localhost}:${port} ${remoteUsername}@${remoteHost}"
        def process = string.execute()
        process.consumeProcessOutput(out, err)
    }

    static void main(String[] args) {
        def portForwarding = new SSHDynamicPortForwarding(
                localhost: '127.0.0.1',
                port: 1212,
                remoteUsername: 'root',
                remoteHost: '74.122.199.115',
                remotePassword: '8FvGgC6AQY'
        )
        portForwarding.executeSocks5()
    }
}
