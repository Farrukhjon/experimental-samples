package org.farrukh.examples.groovy.core.process

import static java.lang.System.err
import static java.lang.System.out

class PipeAndFilterFromGroovyDemo {

    static void main(String[] args) {
        def listCommand = "ls -la".execute()

        def sortCommand = "sort -r".execute()

        def treeCommand = "tree".execute()
        listCommand | sortCommand | treeCommand

        treeCommand.consumeProcessOutput(out, err)

    }

}
