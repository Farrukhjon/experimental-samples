/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <firedandy@gmail.com>, May 2016.
 *
 */

package org.farrukh.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.farrukh.example.controller.UserRestController;
import org.farrukh.example.domain.User;
import org.farrukh.example.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Pure web unit testing.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ApplicationWebUnitTestsStandalone {

    private UserService userService = mock(UserService.class);

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserRestController(userService)).build();
    }

    @Test
    public void shouldRegisterUserAndReturnsExpectedResponse() throws Exception {
        String user = new ObjectMapper().writeValueAsString(new User("Ali", "Valizoda", "ali@example.com"));
        RequestBuilder requestBuilder = post("/users")
                .content(user)
                .contentType(APPLICATION_JSON);
        mockMvc.perform(requestBuilder)
               .andExpect(status().isCreated());
    }

}
