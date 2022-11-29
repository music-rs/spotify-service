package com.jhonatanit.spotifyservice.service;

import com.jhonatanit.spotifyservice.model.MusicEvent;
import com.jhonatanit.spotifyservice.repository.MusicEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class MusicEventService {

    @Autowired
    private MusicEventRepository musicEventRepository;

    public Flux<MusicEvent> getAllMusicEvent() {
        return musicEventRepository.findAll().delayElements(Duration.ofSeconds(1)).log();
    }

    public Mono<MusicEvent> getMusicEvent(Long id) {
        return musicEventRepository.findById(id);
    }

    public Mono<MusicEvent> createOrUpdateMusicEvent(MusicEvent musicEvent) {
        return musicEventRepository.save(musicEvent);
    }

    public Mono<Void> deleteMusicEvent(Long id) {
        return musicEventRepository.deleteById(id);
    }
}
