package com.jhonatanit.spotifyservice.repository;

import com.jhonatanit.spotifyservice.model.Genre;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface GenreRepository extends ReactiveNeo4jRepository<Genre, Long> {
}
