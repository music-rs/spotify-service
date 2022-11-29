package com.jhonatanit.spotifyservice.model;


import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InterestedIn {

    @Id
    @GeneratedValue
    private Long id;

    private Integer interestedCount;

    private Integer visitedCount;

    private Integer evaluation;

    @TargetNode
    private MusicEvent musicEvent;
}
