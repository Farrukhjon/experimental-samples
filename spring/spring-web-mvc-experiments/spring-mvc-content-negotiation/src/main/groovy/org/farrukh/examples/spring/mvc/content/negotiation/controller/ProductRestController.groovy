package org.farrukh.examples.spring.mvc.content.negotiation.controller

import org.farrukh.examples.spring.mvc.content.negotiation.dto.Product
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE

/**
 * Created by Farrukhjon on 5/19/2015.
 */
@RestController
@RequestMapping(value = '/products', produces = [APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE], consumes = [ APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE ])
class ProductRestController {

    @RequestMapping('/{id}')
    ResponseEntity<Product> getProductById(@PathVariable int id) {
        return new ResponseEntity<>(new Product(id:id, name: 'Computer'), HttpStatus.OK)
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(product, HttpStatus.CREATED)
    }


}
