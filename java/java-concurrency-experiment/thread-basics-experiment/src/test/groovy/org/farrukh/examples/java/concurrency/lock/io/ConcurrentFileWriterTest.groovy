package org.farrukh.examples.java.concurrency.lock.io

import spock.lang.Specification
import util.concurrent.lock.io.ConcurrentFileWriter
import util.concurrent.lock.io.PersonData

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

/**
 * Unit test for ConcurrentFileWriter.
 */
class ConcurrentFileWriterTest extends Specification {

    def 'should concurrently writes persons data to the file'() {
        given:
        def file = new File('persons.txt');
        file.createNewFile();

        and:
        def persons = [new PersonData('Ali', 30), new PersonData('Vali', 33), new PersonData('Sami', 23)]

        and:
        def sut = new ConcurrentFileWriter(file, persons)

        when:
        def pool = Executors.newFixedThreadPool(3)
        for (int i = 0; i < 10; i++) {
            sut.setPerson(new PersonData(UUID.randomUUID().toString(), new Random().nextInt()));
            pool.execute(sut);
        }

        TimeUnit.SECONDS.sleep(10)
        then:
        true
    }
}
