package com.jhonatanit.spotifyservice.service;

import com.jhonatanit.spotifyservice.model.Location;
import com.jhonatanit.spotifyservice.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public Flux<Location> getAllLocation() {
        return locationRepository.findAll().delayElements(Duration.ofSeconds(1)).log();
    }

    public Mono<Location> getLocation(Long id) {
        return locationRepository.findById(id);
    }

    public Mono<Location> createOrUpdateLocation(Location location) {
        return locationRepository.save(location);
    }

    public Mono<Void> deleteLocation(Long id) {
        return locationRepository.deleteById(id);
    }
}
