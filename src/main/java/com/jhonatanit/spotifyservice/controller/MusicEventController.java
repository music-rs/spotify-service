package com.jhonatanit.spotifyservice.controller;

import com.jhonatanit.spotifyservice.model.MusicEvent;
import com.jhonatanit.spotifyservice.service.MusicEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/event")
public class MusicEventController {

    @Autowired
    private MusicEventService musicEventService;

    @GetMapping(value = {"", "/"}, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MusicEvent> getAllMusicEvent() {
        return musicEventService.getAllMusicEvent();
    }

    @GetMapping("/{id}")
    Mono<MusicEvent> getMusicEvent(@PathVariable Long id) {
        return musicEventService.getMusicEvent(id);
    }

    @PutMapping
    Mono<MusicEvent> createOrUpdateMusicEvent(@RequestBody MusicEvent musicEvent) {
        return musicEventService.createOrUpdateMusicEvent(musicEvent);
    }

    @DeleteMapping("/{id}")
    Mono<Void> deleteMusicEvent(@PathVariable Long id) {
        return musicEventService.deleteMusicEvent(id);
    }
}
