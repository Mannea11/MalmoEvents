package com.MalmoConcerts.Demo.Client;

import com.MalmoConcerts.Demo.Model.Billetto.Data;
import com.MalmoConcerts.Demo.Model.Billetto.Event;
import com.MalmoConcerts.Demo.Model.Billetto.EventInfo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class BillettoClient {

    private String API_KEY;
    private String API_SECRET;

    private static final String API_URL = "https://billetto.se/api/v3/public/events";
    private final WebClient webClient;

    @Autowired
    public BillettoClient(WebClient.Builder webClientBuilder,
                          @Value("${billetto.api-key}") String apiKey,
                          @Value("${billetto.api-secret}") String apiSecret) {
        this.API_KEY = apiKey;
        this.API_SECRET = apiSecret;

        this.webClient = webClientBuilder.baseUrl(API_URL)
                .defaultHeader("Api-Keypair", API_KEY + ":" + API_SECRET)
                .build();
    }

    public String getEvents(){
        return webClient.get()
                .uri("?limit=100&city=Malmö")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public Flux<Event> getAllEvents(int limit){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("city", "Malmö")
                        .queryParam("limit", "100")
                        .build())
                .retrieve()
                .bodyToFlux(Data.class)
                .flatMapIterable(Data::getData);
    }

    public Flux<Event> getEventsByCategoryName(int limit, String category) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("limit", limit)
                        .queryParam("category", category)
                        .queryParam("city", "Malmö")
                        .build())
                .retrieve()
                .bodyToFlux(Data.class)
                .flatMapIterable(Data::getData);
    }

    public Mono<EventInfo>getEventInfoById(String id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(EventInfo.class);
    }

}
