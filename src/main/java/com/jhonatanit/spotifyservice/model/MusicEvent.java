package com.jhonatanit.spotifyservice.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Node("MusicEvent")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MusicEvent {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private LocalDateTime initialDateTime;

    private LocalDateTime endDateTime;

    private BigDecimal cost;

    private Integer estimatedAttendance;

    private Integer estimatedInterested;

    private Integer overallEvaluation;

    private String image;

    private String url;

    @Relationship(type = "PRODUCED_BY", direction = Relationship.Direction.OUTGOING)
    private Set<Organization> organizationList = new HashSet<>();

    @Relationship(type = "LOCATED_IN", direction = Relationship.Direction.OUTGOING)
    private Set<Location> locationList = new HashSet<>();

}
