package org.farrukh.examples.groovy.core.process

import static java.lang.System.*

class ExecuteShellCommandDemo {

    static void main(String[] args) {
        def process = "ssh --help".execute()
        process.consumeProcessOutput(out, err)
        //println process
    }
}
