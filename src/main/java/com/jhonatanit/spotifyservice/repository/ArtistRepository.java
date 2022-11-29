package com.jhonatanit.spotifyservice.repository;

import com.jhonatanit.spotifyservice.model.Artist;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface ArtistRepository extends ReactiveNeo4jRepository<Artist, Long> {
}
