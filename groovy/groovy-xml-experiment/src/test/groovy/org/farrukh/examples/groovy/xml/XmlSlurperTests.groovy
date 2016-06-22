package org.farrukh.examples.groovy.xml

import groovy.util.slurpersupport.GPathResult
import spock.lang.Specification

/**
 * Created by Farrukhjon on 5/20/2015.
 */
class XmlSlurperTests extends Specification {

    private final XmlSlurper xmlSlurper = new XmlSlurper()
    private final String xmlFileName = '/products.xml'

    def 'exercise xml parsing using xmlSlurper'(){
        given:
        def xmlFile = this.getClass().getResource(xmlFileName).file

        when:
        GPathResult parseResult = xmlSlurper.parse(xmlFile)

        then:
        parseResult
        parseResult.name() == 'products'
        parseResult.children().size() == 3
        parseResult.product.id.size() == 3
        parseResult.product[0].id == 1
        parseResult.product[2].name == 'Router'

        parseResult.children().every {
            it.sold.text() == 'true'
        }

    }
}
