package org.farrukh.examples.groovy.core.process

class KillPidDemo {

    static void main(String[] args) {
        String[] pids = getPIDs()
        pids.each {
            "kill -9 ${it}".execute()
        }
        println pids
    }

    private static String[] getPIDs() {
        def process = 'pidof ssh'.execute()
        def out = new StringBuffer()
        process.consumeProcessOutputStream(out)
        def string = out.toString()
        def split = string.split(' ')
        split
    }

}
