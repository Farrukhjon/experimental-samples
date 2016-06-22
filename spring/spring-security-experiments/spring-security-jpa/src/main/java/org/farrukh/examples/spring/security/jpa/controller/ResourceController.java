package org.farrukh.examples.spring.security.jpa.controller;

import org.farrukh.examples.spring.security.jpa.domain.User;
import org.farrukh.examples.spring.security.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    private final UserRepository repository;

    @Autowired
    public ResourceController(final UserRepository repository) {
        this.repository = repository;
    }

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

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void createCredentials(@RequestBody final User user) {
        User save = repository.save(user);
        System.out.println(save);
    }

    @RequestMapping("/users")
    public ResponseEntity<Iterable<User>> getUsers() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    /*@RequestMapping("/users")
    public Iterable<User> getUsers() {
        return repository.findAll();
    }*/

}
