package com.MalmoConcerts.Demo.Client;


import com.MalmoConcerts.Demo.Model.TicketMaster.ApiResponse;
import com.MalmoConcerts.Demo.Model.TicketMaster.Event;
import com.MalmoConcerts.Demo.Model.TicketMaster.EventInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TicketMasterClient {

    private final String API_KEY;
    private final String API_URL = "https://app.ticketmaster.com/discovery/v2/";
    private final WebClient webClient;

    @Autowired
    public TicketMasterClient(WebClient.Builder webClientBuilder, @Value("${ticketmaster.api-key}") String apiKey) {
        this.API_KEY = apiKey;
        this.webClient = webClientBuilder.baseUrl(API_URL)
                .defaultHeader("apikey", API_KEY)
                .build();
    }
    public String getAll(){
        return webClient.get()
                .uri("events.json?apikey=" + API_KEY +"&city=Malmo&locale=sv-se")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public Flux<Event> getEventsMalmo(int page, int size) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("events.json")
                        .queryParam("apikey", API_KEY)
                        .queryParam("city", "Malmo")
                        .queryParam("locale", "sv-se")
                        .queryParam("page", page)
                        .queryParam("size", size)
                        .build())

                .retrieve()
                .bodyToFlux(ApiResponse.class)
                .flatMapIterable(response -> response.getEmbedded().getEvents());
    }

    public Flux<Event> getEventsByClassificationID(int page, int size, String classificationId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("events.json")
                        .queryParam("apikey", API_KEY)
                        .queryParam("city", "Malmo")
                        .queryParam("locale", "sv-se")
                        .queryParam("page", page)
                        .queryParam("size", size)
                        .queryParam("classificationId", classificationId)
                        .build())

                .retrieve()
                .bodyToFlux(ApiResponse.class)
                .flatMapIterable(response -> response.getEmbedded().getEvents());
    }

    public Mono<EventInfo> getEventInfoById(String eventId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .pathSegment("events", "{eventId}.json")
                        .queryParam("apikey", API_KEY)
                        .queryParam("locale", "sv-se")
                        .build(eventId))
                .retrieve()
                .bodyToMono(EventInfo.class);
    }


//    public List<ConcertInfo> getAllEventsInMalmo(int page) {
//        String url = apiEventUrl + "?apikey=" + API_KEY + "&city=Malmö&locale=*&page=" + page;
//        return webClient.get()
//                .uri(url)
//                .retrieve()
//                .bodyToFlux(ConcertInfo.class)
//                .collectList()
//                .block();
//    }
//
//    public String getAllInMalmo() {
//        String url = apiAttractionUrl + "?apikey=" + apiKey + "&city=Malmö";
//        return webClient.get()
//                .uri(url)
//                .retrieve()
//                .bodyToMono(String.class)
//                .block();
//    }
//
//    public EventDetails getEventById(String eventId) {
//        String url = apiEventDetailsUrl + "?apikey=" + apiKey;
//        return webClient.get()
//                .uri(url, eventId)
//                .retrieve()
//                .bodyToMono(EventDetails.class)
//                .block();
//    }

}
