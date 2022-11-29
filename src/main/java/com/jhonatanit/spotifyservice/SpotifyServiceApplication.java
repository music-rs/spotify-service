package com.jhonatanit.spotifyservice;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class SpotifyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpotifyServiceApplication.class, args);
    }

}
