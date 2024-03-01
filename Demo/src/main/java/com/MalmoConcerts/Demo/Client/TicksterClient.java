package com.MalmoConcerts.Demo.Client;

import com.MalmoConcerts.Demo.Model.Tickster.Event;
import com.MalmoConcerts.Demo.Model.Tickster.EventInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TicksterClient {

    private static final String API_URL = "https://event.api.tickster.com/api/";
    private static final String API_VERSION = "v1.0";
    private static final String LANGUAGE_CODE = "sv";
    private String API_KEY;
    private WebClient webClient;

    @Autowired
    public TicksterClient(WebClient.Builder webClientBuilder, @Value("${tickster.api-key}") String apiKey) {
        this.API_KEY = apiKey;
        this.webClient = webClientBuilder.baseUrl(API_URL)
                .defaultHeader("x-api-key", API_KEY)
                .build();
    }

    public Mono<String> getAllEvents() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(API_VERSION + "/" + LANGUAGE_CODE + "/events")
                        .queryParam("query", "city:malmö")
                        .queryParam("take", 100)
                        .build())
                .retrieve()
                .bodyToMono(String.class);
    }

    public Flux<Event> getEvents() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(API_VERSION + "/" + LANGUAGE_CODE + "/events")
                        .queryParam("query", "city:malmö")
                        .queryParam("take", 100)
                        .build())
                .retrieve()
                .bodyToFlux(Event.class);
    }


    public Flux<Event> sortByCategory(String taggedCategory) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(API_VERSION + "/" + LANGUAGE_CODE + "/events")
                        .queryParam("query",taggedCategory + " city:Malmö")
                        .queryParam("take", 100)
                        .build())
                .retrieve()
                .bodyToFlux(Event.class);
    }

    public Mono<EventInfo> getEventsById(String id) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(API_VERSION + "/" + LANGUAGE_CODE + "/events/{id}")
                        .build(id))
                .retrieve()
                .bodyToMono(EventInfo.class);
    }

}

