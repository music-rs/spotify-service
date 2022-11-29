package com.jhonatanit.spotifyservice.service;

import com.jhonatanit.spotifyservice.model.Artist;
import com.jhonatanit.spotifyservice.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ArtistService {

    @Autowired
    private ArtistRepository artistRepository;

    public Flux<Artist> getAllArtist() {
        return artistRepository.findAll().delayElements(Duration.ofSeconds(1)).log();
    }

    public Mono<Artist> getArtist(Long id) {
        return artistRepository.findById(id);
    }

    public Mono<Artist> createOrUpdateArtist(Artist artist) {
        return artistRepository.save(artist);
    }

    public Mono<Void> deleteArtist(Long id) {
        return artistRepository.deleteById(id);
    }
}
