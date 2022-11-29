package com.jhonatanit.spotifyservice.controller;

import com.jhonatanit.spotifyservice.model.Genre;
import com.jhonatanit.spotifyservice.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping(value = {"", "/"}, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Genre> getAllGenre() {
        return genreService.getAllGenre();
    }

    @GetMapping("/{id}")
    Mono<Genre> getGenre(@PathVariable Long id) {
        return genreService.getGenre(id);
    }

    @PutMapping
    Mono<Genre> createOrUpdateGenre(@RequestBody Genre genre) {
        return genreService.createOrUpdateGenre(genre);
    }

    @DeleteMapping("/{id}")
    Mono<Void> deleteGenre(@PathVariable Long id) {
        return genreService.deleteGenre(id);
    }
}
