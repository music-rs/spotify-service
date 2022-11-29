package com.jhonatanit.spotifyservice.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node("Artist")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Artist {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @Relationship(type = "GIVE", direction = Relationship.Direction.OUTGOING)
    private Set<MusicEvent> musicEventList = new HashSet<>();

    @Relationship(type = "BELONG_TO", direction = Relationship.Direction.OUTGOING)
    private Set<Genre> genreList = new HashSet<>();

}
