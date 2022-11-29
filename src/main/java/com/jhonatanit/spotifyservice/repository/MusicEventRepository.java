package com.jhonatanit.spotifyservice.repository;

import com.jhonatanit.spotifyservice.model.MusicEvent;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface MusicEventRepository extends ReactiveNeo4jRepository<MusicEvent, Long> {
}
