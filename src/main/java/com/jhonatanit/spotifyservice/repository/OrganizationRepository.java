package com.jhonatanit.spotifyservice.repository;

import com.jhonatanit.spotifyservice.model.Organization;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface OrganizationRepository extends ReactiveNeo4jRepository<Organization, Long> {
}
