package org.farrukh.examples.groovy.xml

import spock.lang.Specification

/**
 * Created by Farrukhjon on 5/20/2015.
 */
class ParsingComapanyTests extends Specification {

    def 'exercise company parsing'() {
        given:
        def xmlFile = this.getClass().getResource('/data/Companies.xml').file

        when:
        def companies = new XmlParser().parse(xmlFile)

        then:
        companies.name() == 'companies'
        companies.children().eachWithIndex { it, i ->
            it.name() == 'company'
            switch (i) {
                case 0:
                    it.children().eachWithIndex { item, index ->
                        switch (index) {
                            case 0:
                                assert item.name() == 'name'
                                assert item.value() == ['Coca cola']
                                break
                            case 1:
                                assert item.name() == 'employees'
                                assert item.value() == ['10000']
                                break
                            case 2:
                                assert item.name() == 'departments'
                                item.children().every {
                                    assert it.name() == 'department'
                                    it.children().eachWithIndex { dep, idx ->
                                        switch (idx) {
                                            case 0:
                                                assert dep.name() == 'name'
                                                assert dep.value() == ['IT']
                                                break
                                            case 1:
                                                assert dep.name() == 'employees'
                                                assert dep.value() == ['100']
                                                break
                                        }
                                    }
                                }
                                break
                        }
                    }
            }
        }
    }
}