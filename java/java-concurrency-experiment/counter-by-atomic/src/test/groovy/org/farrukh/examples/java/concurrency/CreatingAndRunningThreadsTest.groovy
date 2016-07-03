package org.farrukh.examples.java.concurrency

import spock.lang.Specification
import thread.ThreadExtendsExample

/**
 * Created by Farrukhjon on 20-Sep-15.
 */
class CreatingAndRunningThreadsTest extends  Specification {

    def 'exercise creating a thread by extending from Thread class'() {

        when:
        ThreadExtendsExample extendsExample = new ThreadExtendsExample()

        then:
        extendsExample instanceof Thread

    }
}
