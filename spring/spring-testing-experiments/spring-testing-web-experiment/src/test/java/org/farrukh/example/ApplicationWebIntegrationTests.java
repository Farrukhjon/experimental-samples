/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <firedandy@gmail.com>, May 2016.
 *
 */

package org.farrukh.example;

import org.farrukh.example.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpMethod.POST;

/**
 * Client-Side Web Integration Tests.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class ApplicationWebIntegrationTests {

    @Value("${local.server.port}")
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void shouldRegisterUserAndReturnsExpectedResponse() {
        User user = new User("Ali", "Valizoda", "ali@mail.com");
        String path = "/users";
        String url = buildUri(path);
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<User> requestEntity = new HttpEntity<>(user, header);
        ResponseEntity<User> responseEntity = restTemplate.exchange(url, POST, requestEntity, User.class);
        HttpStatus expectedStatusCode = HttpStatus.CREATED;
        User responseBody = responseEntity.getBody();

        assertEquals(expectedStatusCode, responseEntity.getStatusCode());
        assertEquals(user.getFirstName(), responseBody.getFirstName());
        assertEquals(user.getLastName(), responseBody.getLastName());
        assertEquals(user.getEmail(), responseBody.getEmail());
    }

    private String buildUri(final String path) {
        return UriComponentsBuilder.newInstance()
                                   .scheme("http")
                                   .host("localhost")
                                   .port(port)
                                   .path(path)
                                   .build()
                                   .toUriString();
    }

}
