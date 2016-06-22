package org.farrukh.examples.spring.database.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @RequestMapping("/")
    public String home() {
        return "Welcome to the Home page!";
    }

    @RequestMapping("/main")
    public String main() {
        return "Welcome to the Main page!";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "Welcome to the Admin page!";
    }

}
