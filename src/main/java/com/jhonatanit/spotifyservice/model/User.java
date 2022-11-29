package com.jhonatanit.spotifyservice.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.Set;

@Node("User")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String lastname;

    private String username;

    private String password;

    private String email;

    private String descriptionUser;

    @Relationship(type = "INTERESTED_IN", direction = Relationship.Direction.OUTGOING)
    private Set<InterestedIn> musicEventList = new HashSet<>();

    @Relationship(type = "FAN_OF", direction = Relationship.Direction.OUTGOING)
    private Set<Artist> artistList = new HashSet<>();

    @Relationship(type = "LIKE", direction = Relationship.Direction.OUTGOING)
    private Set<Genre> genreList = new HashSet<>();
}
