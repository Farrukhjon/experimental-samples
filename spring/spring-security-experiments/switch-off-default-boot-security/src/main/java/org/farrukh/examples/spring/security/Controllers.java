package org.farrukh.examples.spring.security;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {

    @RequestMapping({"/", "home"})
    public String home() {
        return "Home page\n";
    }

    @RequestMapping("/user")
    public String user() {
        return "User\n";
    }

    @RequestMapping("/client")
    public String client() {
        return "Client\n";
    }

    @RequestMapping("/admin")
    public String getAdmin(){
        return "Admin home\n";
    }

    @RequestMapping("/db")
    public String db(){
        return "DB home\n";
    }

}
