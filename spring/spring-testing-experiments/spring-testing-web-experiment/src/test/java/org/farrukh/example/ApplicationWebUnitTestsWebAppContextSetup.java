package org.farrukh.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.farrukh.example.controller.UserRestController;
import org.farrukh.example.domain.User;
import org.farrukh.example.service.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.mock;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Server-Side Integration Testing?
 * But I think it is still Unit level testing!
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationWebUnitTestsWebAppContextSetup {

    @Autowired
    private UserService userService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void checkUserService() {
        Assert.assertNotNull(userService);
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
