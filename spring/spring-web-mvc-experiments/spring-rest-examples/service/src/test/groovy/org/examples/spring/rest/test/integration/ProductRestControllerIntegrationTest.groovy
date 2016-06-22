/**
 * 
 */
package org.examples.spring.rest.test.integration

import org.examples.spring.rest.controller.ProductRestController
import org.examples.spring.rest.test.BaseRestIntegrationTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.setup.MockMvcBuilders

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*

/**
 * @author Farrukhjon SATTOROV
 *
 */
class ProductRestControllerIntegrationTest extends BaseRestIntegrationTest {

	@Autowired
	ProductRestController productRestController

	private MockMvc mockMvc

	def setup(){
		mockMvc = MockMvcBuilders.standaloneSetup(productRestController).build()
	}

	def 'should test if not null'(){
		assert productRestController != null
	}

	def 'exercise get method in product controller'(){
		when:
		def response= mockMvc.perform(get("/products"))

		then:
		response.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
	}
}
