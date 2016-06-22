package org.farrukh.examples.spring.handling.exceptions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;

import org.farrukh.examples.spring.handling.exceptions.controller.ProductRestController;
import org.farrukh.examples.spring.handling.exceptions.dto.ProductDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class SpringMvcHandlingExceptionsExamplesUnitTests {

	MockMvc mockMvc;

	String expectedContentType = ProductDTO.JSON_CONTENT_TYPE;

	URI uri = UriComponentsBuilder.fromUriString("/products")
		.path("/1")
		.build()
		.toUri();

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(new ProductRestController()).build();
	}

	@Test
	public void shouldTestsWhenThrownNotAcceptableException() throws Exception {
		mockMvc.perform(get(uri).accept("unsupported/unsupported")
			.contentType(expectedContentType))
			.andExpect(status().is(HttpStatus.NOT_ACCEPTABLE.value()));
	}

	@Test
	public void shouldTestsWhenThrownNotSupportedException() throws Exception {
		mockMvc.perform(get(uri).accept(expectedContentType)
			.contentType("unsupported/unsupported"))
			.andExpect(status().is(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()))
			.andDo(print());
	}

}
