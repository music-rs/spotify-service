package com.jhonatanit.spotifyservice.controller;

import com.jhonatanit.spotifyservice.model.Location;
import com.jhonatanit.spotifyservice.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping(value = {"", "/"}, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Location> getAllLocation() {
        return locationService.getAllLocation();
    }

    @GetMapping("/{id}")
    Mono<Location> getLocation(@PathVariable Long id) {
        return locationService.getLocation(id);
    }

    @PutMapping
    Mono<Location> createOrUpdateLocation(@RequestBody Location location) {
        return locationService.createOrUpdateLocation(location);
    }

    @DeleteMapping("/{id}")
    Mono<Void> deleteLocation(@PathVariable Long id) {
        return locationService.deleteLocation(id);
    }
}
