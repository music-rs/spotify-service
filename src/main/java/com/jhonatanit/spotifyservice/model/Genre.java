package com.jhonatanit.spotifyservice.model;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Genre")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Genre {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
