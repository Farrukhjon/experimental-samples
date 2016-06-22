package org.farrukh.examples.spring.mvc.content.negotiation.controller

import org.farrukh.examples.spring.mvc.content.negotiation.BaseIntegrationTest
import org.farrukh.examples.spring.mvc.content.negotiation.dto.Product
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.util.UriComponentsBuilder

/**
 * Created by Farrukhjon on 5/19/2015.
 */
class ProductRestControllerIntegrationTests extends BaseIntegrationTest {

    def EXPECTED_XML_CONTENT_TYPE = MediaType.parseMediaType('application/xml;charset=UTF-8')
    def EXPECTED_JSON_CONTENT_TYPE = MediaType.parseMediaType('application/json;charset=UTF-8')
    def BASE_URI = 'http://localhost'
    def productsPath = '/products/'

    def 'exercise get product by id in json format'(){
        given: 'a valid request'
        def uri = UriComponentsBuilder.fromUriString(BASE_URI).port(port).path(productsPath).path('1').build().toUri()

        and: 'set headers'
        HttpHeaders headers = new HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_JSON)
        headers.setAccept([MediaType.APPLICATION_JSON])
        HttpEntity entity = new HttpEntity(headers)

        when: 'call exchange request with response'
        def response = restTemplate.exchange(uri, HttpMethod.GET, entity, Product)

        then:
        response
        response.statusCode == HttpStatus.OK
        response.headers.getContentType() == EXPECTED_JSON_CONTENT_TYPE
        response.body.id == 1
        response.body.name == 'Computer'
    }

    def 'exercise get product by id in xml format'(){
        given: 'a valid request'
        def uri = UriComponentsBuilder.fromUriString(BASE_URI).port(port).path(productsPath).path('1').build().toUri()

        and: 'set headers'
        HttpHeaders headers = new HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_XML)
        headers.setAccept([MediaType.APPLICATION_XML])
        HttpEntity entity = new HttpEntity(headers)

        when: 'call exchange request with response'
        def response = restTemplate.exchange(uri, HttpMethod.GET, entity, Product)

        then:
        response
        response.statusCode == HttpStatus.OK
        response.headers.getContentType() == EXPECTED_XML_CONTENT_TYPE
        response.body.id == 1
        response.body.name == 'Computer'
    }

    def 'exercise post product in xml format'(){
        given: 'a valid request'
        def uri = UriComponentsBuilder.fromUriString(BASE_URI).port(port).path(productsPath).build().toUri()

        and: 'created the product'
        def product = new Product(id: 7, name: 'Router')

        and: 'set headers'
        HttpHeaders headers = new HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_XML)
        headers.setAccept([MediaType.APPLICATION_XML])
        HttpEntity entity = new HttpEntity(product, headers)

        when: 'call exchange request with response'
        def response = restTemplate.exchange(uri, HttpMethod.POST, entity, Product)

        then:
        response
        response.statusCode == HttpStatus.CREATED
        response.headers.getContentType() == EXPECTED_XML_CONTENT_TYPE
        response.body.id == 7
        response.body.name == 'Router'
    }

    def 'exercise post product in json format'(){
        given: 'a valid request'
        def uri = UriComponentsBuilder.fromUriString(BASE_URI).port(port).path(productsPath).build().toUri()

        and: 'created the product'
        def product = new Product(id: 10, name: 'Printer')

        and: 'set headers'
        HttpHeaders headers = new HttpHeaders()
        headers.setContentType(MediaType.APPLICATION_JSON)
        headers.setAccept([MediaType.APPLICATION_JSON])
        HttpEntity entity = new HttpEntity(product, headers)

        when: 'call exchange request with response'
        def response = restTemplate.exchange(uri, HttpMethod.POST, entity, Product)

        then:
        response
        response.statusCode == HttpStatus.CREATED
        response.headers.getContentType() == EXPECTED_JSON_CONTENT_TYPE
        response.body.id == 10
        response.body.name == 'Printer'
    }
}
