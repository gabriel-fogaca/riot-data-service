package com.riot.riot_api.services;

import com.riot.riot_api.dto.ChampionRotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;

@Service
public class ChampionRotationService {

    @Value("${riot.api.regional-url}")
    private String riotRegionalUrl;
    @Value("${riot.api.key}")
    private String xRiotToken;
    private RestTemplate restTemplate;

    @Autowired
    public ChampionRotationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ChampionRotation execute() {
        String fullUrl = riotRegionalUrl + "/lol/platform/v3/champion-rotations";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Riot-Token", xRiotToken);
        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<ChampionRotation> response = restTemplate.exchange(
            fullUrl,
            GET,
            entity,
            ChampionRotation.class
        );

        return response.getBody();
    }
}
