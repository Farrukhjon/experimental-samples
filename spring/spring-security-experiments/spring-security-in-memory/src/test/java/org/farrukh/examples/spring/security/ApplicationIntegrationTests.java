package org.farrukh.examples.spring.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest(randomPort = true)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationIntegrationTests {

    private TestRestTemplate restTemplate = new TestRestTemplate();

    @Value("${local.server.port}")
    private int port;

    @Test
    public void contextLoads() {
        HttpStatus expectedStatusCode = HttpStatus.OK;
        ResponseEntity<String> entity = restTemplate.getForEntity(getUrl("/"), String.class);
        HttpHeaders headers = entity.getHeaders();
        assertEquals(expectedStatusCode, entity.getStatusCode());
    }

    private String getUrl(final String path) {
        return UriComponentsBuilder.newInstance()
                                   .scheme("http")
                                   .host("localhost")
                                   .port(port)
                                   .path(path)
                                   .toUriString();
    }

}
