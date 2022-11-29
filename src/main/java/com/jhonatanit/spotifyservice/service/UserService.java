package com.jhonatanit.spotifyservice.service;

import com.jhonatanit.spotifyservice.model.User;
import com.jhonatanit.spotifyservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Flux<User> getAllUser() {
        return userRepository.findAll().delayElements(Duration.ofSeconds(1)).log();
    }
    
    public Mono<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public Mono<User> createOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    public Mono<Void> deleteUser(Long id) {
        return userRepository.deleteById(id);
    }
}
