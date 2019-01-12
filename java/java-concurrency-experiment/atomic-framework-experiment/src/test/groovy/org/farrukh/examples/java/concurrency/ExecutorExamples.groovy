package org.farrukh.examples.java.concurrency

import spock.lang.Specification

import java.util.concurrent.Executors

class ExecutorExamples extends Specification {

    volatile int count

    def 'should test execute method'() {
        given: 'print greeting task'
        def greetingTask = new Runnable() {
            @Override
            void run() {
                synchronized (new Object()) {
                    count++
                    println "hello"
                }
            }
        }

        and:
        def threadPool = Executors.newFixedThreadPool(2)

        when:
        10.times {
            threadPool.execute(greetingTask)
        }
        //threadPool.shutdown()

        then:
        count == 1

    }

}
