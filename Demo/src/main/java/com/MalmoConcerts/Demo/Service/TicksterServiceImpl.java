package com.MalmoConcerts.Demo.Service;

import com.MalmoConcerts.Demo.Client.TicksterClient;
import com.MalmoConcerts.Demo.DTO.Tickster.TicksterCompleteInfoDTO;
import com.MalmoConcerts.Demo.DTO.Tickster.TicksterInfoDTO;
import com.MalmoConcerts.Demo.Model.Tickster.Event;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TicksterServiceImpl implements TicksterService {

    private final TicksterClient ticksterClient;

    public TicksterServiceImpl(TicksterClient ticksterClient) {
        this.ticksterClient = ticksterClient;
    }

    @Cacheable(value = "ticksterAllEventsCache", key = "'allEvents'")
    public Flux<TicksterInfoDTO> getAllEvents() {
        return ticksterClient.getEvents()
                .flatMapIterable(Event::getItems)
                .filter(eventItem -> !eventItem.getStartUtc().startsWith("2020"))
                .filter(eventItem -> !eventItem.getStartUtc().startsWith("2023"))
                .map(eventItem -> {
                    TicksterInfoDTO ticksterInfoDTO = new TicksterInfoDTO(
                            eventItem.getName(),
                            eventItem.getId(),
                            null,
                            eventItem.getStartUtc(),
                            eventItem.getEndUtc(),
                            eventItem.getVenue().getName());

                    return ticksterInfoDTO;
                });
    }
    @Cacheable(value = "ticksterEventsByCategoryCache", key = "#taggedCategory")
    public Flux<TicksterInfoDTO> getEventsByCategory(String taggedCategory) {
        return ticksterClient.sortByCategory(taggedCategory)
                .flatMapIterable(Event::getItems)
                .filter(eventItem -> !eventItem.getStartUtc().startsWith("2020"))
                .filter(eventItem -> !eventItem.getStartUtc().startsWith("2023"))
                .map(eventItem -> {
                    TicksterInfoDTO ticksterInfoDTO = new TicksterInfoDTO(
                            eventItem.getName(),
                            eventItem.getId(),
                            null,
                            eventItem.getStartUtc(),
                            eventItem.getEndUtc(),
                            eventItem.getVenue().getName());

                    return ticksterInfoDTO;
                });
    }

 //   @Cacheable(value = "ticksterEventByIdCache", key = "#id")
    public Mono<TicksterCompleteInfoDTO> getEventsById(String id) {
        return ticksterClient.getEventsById(id)
                .map(eventInfo -> {
                    Double price = (eventInfo.getProducts() != null && !eventInfo.getProducts().isEmpty())
                            ? eventInfo.getProducts().get(0).getPrice().getAmount()
                            : null;
                    String cleanedDescription = eventInfo.getDescription().getMarkdown().replaceAll("\\r\\n|\\\\", "");
                    TicksterCompleteInfoDTO ticksterCompleteInfoDTO = new TicksterCompleteInfoDTO(
                            eventInfo.getName(),
                            eventInfo.getVenue().getName(),
                            cleanedDescription,
                            eventInfo.getStartUtc(),
                            eventInfo.getEndUtc(),
                            eventInfo.getVenue().getGeo().getLongitude(),
                            eventInfo.getVenue().getGeo().getLatitude(),
                            eventInfo.getImageUrl(),
                            price,
                            eventInfo.getInfoUrl());

                    return ticksterCompleteInfoDTO;
                });
    }
    }


