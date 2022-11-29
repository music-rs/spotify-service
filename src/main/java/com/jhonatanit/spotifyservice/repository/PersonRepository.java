package com.jhonatanit.spotifyservice.repository;

import com.jhonatanit.spotifyservice.model.Person;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface PersonRepository extends ReactiveNeo4jRepository<Person, String> {
}
