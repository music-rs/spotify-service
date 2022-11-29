package com.jhonatanit.spotifyservice.controller;

import com.jhonatanit.spotifyservice.model.Organization;
import com.jhonatanit.spotifyservice.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping(value = {"", "/"}, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Organization> getAllOrganization() {
        return organizationService.getAllOrganization();
    }

    @GetMapping("/{id}")
    Mono<Organization> getOrganization(@PathVariable Long id) {
        return organizationService.getOrganization(id);
    }

    @PutMapping
    Mono<Organization> createOrUpdateOrganization(@RequestBody Organization organization) {
        return organizationService.createOrUpdateOrganization(organization);
    }

    @DeleteMapping("/{id}")
    Mono<Void> deleteOrganization(@PathVariable Long id) {
        return organizationService.deleteOrganization(id);
    }
}
