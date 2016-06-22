package org.farrukh.examples.spring.mvc.interceptor.controller

import org.farrukh.examples.spring.mvc.interceptor.dto.Product
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/products')
class ProductRestController {

    @RequestMapping('/{id}')
    public HttpEntity<Product> getProduct(@PathVariable int id){
        def product = new Product(id: id, name: 'Computer')
        new ResponseEntity<>(product, HttpStatus.OK)
    }
}
