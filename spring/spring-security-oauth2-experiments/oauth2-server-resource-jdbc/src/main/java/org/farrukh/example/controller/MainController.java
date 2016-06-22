package org.farrukh.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {

    @RequestMapping("/home")
    public String home() {
        return "Hello World";
    }

    @RequestMapping("/me")
    public Principal me(final Principal me) {
        return me;
    }

}
