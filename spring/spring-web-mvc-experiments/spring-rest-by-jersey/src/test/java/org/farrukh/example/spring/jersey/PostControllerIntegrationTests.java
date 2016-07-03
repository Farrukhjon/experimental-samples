/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.spring.jersey;

import io.restassured.RestAssured;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Random;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class PostControllerIntegrationTests {

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;

    }

    private String getUrl(final String path) {
        return UriComponentsBuilder.newInstance()
                                   .scheme("http")
                                   .host("localhost")
                                   .port(port)
                                   .path("posts/")
                                   .path(path)
                                   .build()
                                   .toUriString();
    }

    @Test
    public void shouldReturnPostByGivenId() throws Exception {
        int randomPostId = new Random().ints(1, 10).findAny().getAsInt();
        String url = getUrl(String.valueOf(randomPostId));
        RequestEntity<Void> request = RequestEntity.get(URI.create(url)).build();
        ResponseEntity<?> entity = restTemplate.exchange(request, String.class);
        HttpStatus expectedStatus = HttpStatus.OK;
        Assert.assertEquals(expectedStatus, entity.getStatusCode());
        MediaType expectedContentType = MediaType.APPLICATION_JSON_UTF8;
        Assert.assertEquals(expectedContentType, entity.getHeaders().getContentType());
    }

    @Test
    public void shouldReturnPostByGivenIdWithRestAssured() throws Exception {
        int randomPostId = new Random().ints(1, 10).findAny().getAsInt();
        int expectedStatus = org.apache.http.HttpStatus.SC_OK;
        String expectedContentType = MediaType.APPLICATION_JSON_UTF8_VALUE;

        when()
                .get("/posts/{postId}", randomPostId)
        .then()
                .statusCode(expectedStatus)
                .contentType(expectedContentType)
                .body("body.id", is(randomPostId))
                .body("body.userId", notNullValue())
                .body("body.title", notNullValue())
                .body("body.body", notNullValue());
    }

}
