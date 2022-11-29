package com.jhonatanit.spotifyservice.controller;

import com.jhonatanit.spotifyservice.model.User;
import com.jhonatanit.spotifyservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"", "/"}, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{id}")
    Mono<User> getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PutMapping
    Mono<User> createOrUpdateUser(@RequestBody User user) {
        return userService.createOrUpdateUser(user);
    }

    @DeleteMapping("/{id}")
    Mono<Void> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
