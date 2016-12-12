package org.netty.server.experiment;

public enum ServerPort {

        ECHO(7),
        FTP(21),
        SSH(22),
        TELNET(23),
        SMTP(25),
        DNS(53),
        TFTP(69),
        HTTP(80),
        POP3(110),
        SFTP(115),
        SNMP(161),
        IRC(194),
        LDAP(389),
        HTTPS(443);

    private final int portNumber;

    public int value() {
        return portNumber;
    }

    private ServerPort(int value) {
        portNumber = value;
    }

}
