/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.spring.jersey;

import org.farrukh.example.spring.jersey.inbound.PostController;
import org.farrukh.example.spring.jersey.service.PostService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class PostControllerUnitTests {

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        PostService postService = Mockito.mock(PostService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new PostController(postService)).build();

    }

    @Test
    public void shouldReturnPostByGivenId() throws Exception {
        String path = "posts/1";
        String url = path;
        RequestBuilder request = MockMvcRequestBuilders.get(url);
        MvcResult mvcResult = mockMvc.perform(request).andReturn();

        int expectedStatusCode = HttpStatus.OK.value();
        Assert.assertEquals(expectedStatusCode, mvcResult.getResponse().getStatus());
    }

}
