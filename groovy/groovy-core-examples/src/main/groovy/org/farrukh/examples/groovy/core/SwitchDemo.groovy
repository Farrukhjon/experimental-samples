package org.farrukh.examples.groovy.core

class SwitchDemo {

    public static void main(String[] args) {
        def message = '''Warning: Permanently added '94.23.41.214' (RSA) to the list of known hosts.
Permission denied, please try again.
'''
        switch (message) {
            case ~/.*\nPermission denied, please try again.\n/:
                println message
                break;
            default:
                println "Hello"
        }
    }

}
