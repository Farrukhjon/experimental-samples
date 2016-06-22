/**
 * 
 */
package org.examples.spring.rest.test.unit

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

import org.examples.spring.rest.controller.IProductRestController
import org.examples.spring.rest.dto.Product
import org.examples.spring.rest.dto.ProductResponse
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import spock.lang.Specification

/**
 * @author Farrukhjon SATTOROV
 *
 */
class ProductRestControllerUnitTest extends Specification {


	def 'exercise get products method in product controller'(){

		given:
		IProductRestController productRestController = Stub()

		and:
		HttpHeaders headers = new HttpHeaders()
		headers.setContentType(MediaType.APPLICATION_JSON)
		List<Product> products = Arrays.asList(new Product(1, "Apple"), new Product(2, "Orange"), new Product(3, "Banana"))
		ProductResponse response = new ProductResponse()
		response.setRoducts(products)
		response.setStatusCode(1)
		response.setStatusMessage("Success")
		response.setDetailedMessage("")

		when:
		HttpEntity result = productRestController.getProducts()

		then:
		productRestController.getProducts() >> new ResponseEntity<ProductResponse>(response, headers, HttpStatus.OK)
		result.getHeaders().getContentType() == MediaType.APPLICATION_JSON
	}
}
