package com.jhonatanit.spotifyservice.repository;

import com.jhonatanit.spotifyservice.model.User;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface UserRepository extends ReactiveNeo4jRepository<User, Long> {
}
