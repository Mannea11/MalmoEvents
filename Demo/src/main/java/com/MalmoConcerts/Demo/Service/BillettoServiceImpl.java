package com.MalmoConcerts.Demo.Service;

import com.MalmoConcerts.Demo.Client.BillettoClient;
import com.MalmoConcerts.Demo.DTO.Billetto.BillettoCompleteInfoDTO;
import com.MalmoConcerts.Demo.DTO.Billetto.BillettoInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BillettoServiceImpl implements BillettoService {

private final BillettoClient billettoClient;

    @Autowired
    public BillettoServiceImpl(BillettoClient billettoClient) {
        this.billettoClient = billettoClient;
    }

    @Cacheable(value = "eventsByCategoryCache", key = "#limit + '-' + #category")
    public Flux<BillettoInfoDTO> getEventByCategory(int limit, String category) {
        return billettoClient.getEventsByCategoryName(limit, category)
                      .map(eventInfo -> {
                                BillettoInfoDTO eventInfoDTO = new BillettoInfoDTO(
                                        eventInfo.getId(),
                                        eventInfo.getTitle(),
                                        eventInfo.getImage(),
                                        eventInfo.getOrganiser().getName(),
                                        eventInfo.getStartDate(),
                                        eventInfo.getEndDate()
                                );
                                return eventInfoDTO;
                });
    }
    @Cacheable(value = "allEventsCache", key = "#limit")
    public Flux<BillettoInfoDTO> getAllEvents(int limit) {
        return billettoClient.getAllEvents(limit)
                .map(eventInfo -> {
                    BillettoInfoDTO eventInfoDTO = new BillettoInfoDTO(
                            eventInfo.getId(),
                            eventInfo.getTitle(),
                            eventInfo.getImage(),
                            eventInfo.getOrganiser().getName(),
                            eventInfo.getStartDate(),
                            eventInfo.getEndDate()
                    );
                    return eventInfoDTO;
                });

    }
    @Cacheable(value = "eventInfoCache", key = "#id")
    public Mono<BillettoCompleteInfoDTO> getEventsById(String id) {
        return billettoClient.getEventInfoById(id)
                .map(eventInfo -> {
                    BillettoCompleteInfoDTO eventInfoCompleteDTO = new BillettoCompleteInfoDTO(
                            eventInfo.getTitle(),
                            eventInfo.getDescription(),
                            eventInfo.getImage(),
                            eventInfo.getLocation().getLocation(),
                            eventInfo.getStartDate(),
                            eventInfo.getEndDate(),
                            eventInfo.getMinPrice().getAmountInCents(),
                            eventInfo.getLocation().getCoordinates().getLongitude(),
                            eventInfo.getLocation().getCoordinates().getLatitude(),
                            eventInfo.getUrl()
                    );
                    return eventInfoCompleteDTO;
                });
}}
