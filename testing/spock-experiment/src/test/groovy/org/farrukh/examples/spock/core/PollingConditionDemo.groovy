package org.farrukh.examples.spock.core

import spock.lang.Specification
import spock.util.concurrent.PollingConditions

/**
 * Created by Farrukhjon SATTOROV.
 */
class PollingConditionDemo extends Specification {

    def 'exercising polling condition feature'() {
        given:
        def t = new Task()

        when: 'tasks is created and ran'
        def result = t.resolved

        then: 'poll if resolved became true'
        new PollingConditions(timeout: 10, delay: 1).eventually {
            result
        }
    }

    static class Task extends Thread {
        boolean resolved

        Task() {
            def t1 = new Thread(new Runnable() {
                @Override
                void run() {
                    while (true) {
                        isResolved(true)
                        if (isInterrupted()) {
                            break
                        }
                    }
                }
            })

            def t2 = new Thread(new Runnable() {
                @Override
                void run() {
                    while (true) {
                        isResolved(false)
                        if (isInterrupted()) {
                            break
                        }
                    }
                }
            })

            t1.start()
            t2.start()

            sleep(25 * 100)
            t1.interrupt()
            t2.interrupt()
        }

        synchronized boolean isResolved(aResolved) {
            resolved = aResolved
            resolved
        }
    }
}
