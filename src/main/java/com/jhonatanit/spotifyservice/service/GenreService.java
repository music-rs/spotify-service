package com.jhonatanit.spotifyservice.service;

import com.jhonatanit.spotifyservice.model.Genre;
import com.jhonatanit.spotifyservice.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public Flux<Genre> getAllGenre() {
        return genreRepository.findAll().delayElements(Duration.ofSeconds(1)).log();
    }

    public Mono<Genre> getGenre(Long id) {
        return genreRepository.findById(id);
    }

    public Mono<Genre> createOrUpdateGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Mono<Void> deleteGenre(Long id) {
        return genreRepository.deleteById(id);
    }
}
