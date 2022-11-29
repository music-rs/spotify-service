package com.jhonatanit.spotifyservice.service;

import com.jhonatanit.spotifyservice.bean.SpotifyBean;
import lombok.extern.log4j.Log4j2;
import org.apache.hc.core5.http.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.credentials.ClientCredentials;
import se.michaelthelin.spotify.model_objects.specification.Album;
import se.michaelthelin.spotify.requests.authorization.client_credentials.ClientCredentialsRequest;
import se.michaelthelin.spotify.requests.data.albums.GetAlbumRequest;

import java.io.IOException;

@Service
@ConfigurationProperties
@Log4j2
public class SpotifyService {

    @Value("${spotify.client.id}")
    private String clientId;

    @Value("${spotify.client.secret}")
    private String clientSecret;

    public Mono<SpotifyBean> getAlbumById(String id) {

        Mono<SpotifyBean> spotifyBeanMono = Mono.empty();

        try {

            SpotifyApi spotifyApi = new SpotifyApi.Builder().setClientId(clientId).setClientSecret(clientSecret).build();
            ClientCredentialsRequest clientCredentialsRequest = spotifyApi.clientCredentials().build();
            ClientCredentials clientCredentials = clientCredentialsRequest.execute();

            // Set access token for further "spotifyApi" object usage
            spotifyApi.setAccessToken(clientCredentials.getAccessToken());

            try {
                GetAlbumRequest getAlbumRequest = spotifyApi.getAlbum(id).build();
                Album album = getAlbumRequest.execute();

                log.info("Name: {}", album.toString());
                spotifyBeanMono = Mono.just(new SpotifyBean(album.getName(), album.toString()));

            } catch (IOException | SpotifyWebApiException | ParseException e) {
                log.error("Error: {}", e.getMessage());
            }

            log.info("Expires in: {}", clientCredentials.getExpiresIn());
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            log.error("Error: {}", e.getMessage());
        }

        return spotifyBeanMono;
    }

}
