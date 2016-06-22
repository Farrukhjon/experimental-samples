package org.farrukh.examples.groovy.xml

import spock.lang.Specification

/**
 * Created by Farrukhjon on 5/20/2015.
 */
class XmlParserTests extends Specification {

    private final XmlParser xmlParser = new XmlParser()
    private final String xmlFileName = '/products.xml'

    def 'exercise xml parser using sequential assert'(){
        given:
        def xml = this.getClass().getResource(xmlFileName).file

        when:
        def parseResult = xmlParser.parse(xml)

        then:
        parseResult.name() == 'products'
        parseResult.children()[0].name.text() == 'Computer'
        parseResult.children()[1].name.text() == 'Printer'
        parseResult.children()[2].name.text() == 'Router'
    }

    def 'exercise xml parser using iteration assert'(){
        given:
        def xml = this.getClass().getResource(xmlFileName).file

        when:
        def parseResult = xmlParser.parse(xml)

        then:
        parseResult.name() == 'products'
        parseResult.each {
          assert it.name() == 'product'
        }
        parseResult.children().every {
            it.sold.text() == 'yes'
        }
    }

    def 'exercise xml parse using parse text method'() {
        given:
        String xml = this.getClass().getResource(xmlFileName).text

        when:
        def parseResult = xmlParser.parseText(xml)

        then:
        parseResult.every {
            it.name() == 'product'
        }
    }
}
