package com.jhonatanit.spotifyservice.controller;

import com.jhonatanit.spotifyservice.model.Artist;
import com.jhonatanit.spotifyservice.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping(value = {"", "/"}, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Artist> getAllArtist() {
        return artistService.getAllArtist();
    }

    @GetMapping("/{id}")
    Mono<Artist> getArtist(@PathVariable Long id) {
        return artistService.getArtist(id);
    }

    @PutMapping
    Mono<Artist> createOrUpdateArtist(@RequestBody Artist artist) {
        return artistService.createOrUpdateArtist(artist);
    }

    @DeleteMapping("/{id}")
    Mono<Void> deleteArtist(@PathVariable Long id) {
        return artistService.deleteArtist(id);
    }
}
