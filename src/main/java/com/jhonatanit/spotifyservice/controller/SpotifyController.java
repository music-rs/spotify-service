package com.jhonatanit.spotifyservice.controller;

import com.jhonatanit.spotifyservice.bean.SpotifyBean;
import com.jhonatanit.spotifyservice.service.SpotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/spotify")
public class SpotifyController {

    @Autowired
    private SpotifyService spotifyService;

    @GetMapping("/album/{id}")
    Mono<SpotifyBean> getAlbumById(@PathVariable String id) {
        return spotifyService.getAlbumById(id);
    }
}
