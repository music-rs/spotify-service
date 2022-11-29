package com.jhonatanit.spotifyservice.controller;

import com.jhonatanit.spotifyservice.model.Movie;
import com.jhonatanit.spotifyservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping(value = {"", "/"}, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/by-title")
    Mono<Movie> byTitle(@RequestParam String title) {
        return movieRepository.findOneByTitle(title);
    }

    @PutMapping
    Mono<Movie> createOrUpdateMovie(@RequestBody Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable String id) {
        return movieRepository.deleteById(id);
    }
}