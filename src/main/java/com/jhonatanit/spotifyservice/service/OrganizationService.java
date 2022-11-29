package com.jhonatanit.spotifyservice.service;

import com.jhonatanit.spotifyservice.model.Organization;
import com.jhonatanit.spotifyservice.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public Flux<Organization> getAllOrganization() {
        return organizationRepository.findAll().delayElements(Duration.ofSeconds(1)).log();
    }

    public Mono<Organization> getOrganization(Long id) {
        return organizationRepository.findById(id);
    }

    public Mono<Organization> createOrUpdateOrganization(Organization organization) {
        return organizationRepository.save(organization);
    }

    public Mono<Void> deleteOrganization(Long id) {
        return organizationRepository.deleteById(id);
    }
}
