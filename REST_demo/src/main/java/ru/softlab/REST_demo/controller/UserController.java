package ru.softlab.REST_demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.softlab.REST_demo.domain.User;
import ru.softlab.REST_demo.repos.UserRepo;
import ru.softlab.REST_demo.service.UserService;


@RestController
@RequestMapping("rest/profile")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(LibraryController.class);

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserService userService;


    @GetMapping
    public ResponseEntity<Iterable<User>> findAll() {

        return userService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {

        return userService.findById(id);
    }

    @GetMapping("username/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String username) {

        return userService.findByUsername(username);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {

        return userService.create(user);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("auth")
    public ResponseEntity<String> auth(@RequestBody User user) {
        return userService.auth(user);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }
}
