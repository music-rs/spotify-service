package com.jhonatanit.spotifyservice.repository;

import com.jhonatanit.spotifyservice.model.Location;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface LocationRepository extends ReactiveNeo4jRepository<Location, Long> {
}
