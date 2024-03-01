package com.MalmoConcerts.Demo.Service;

import com.MalmoConcerts.Demo.DTO.Tickster.TicksterCompleteInfoDTO;
import com.MalmoConcerts.Demo.DTO.Tickster.TicksterInfoDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TicksterService {

    Flux<TicksterInfoDTO> getAllEvents();

    Flux<TicksterInfoDTO> getEventsByCategory(String taggedCategory);

    Mono<TicksterCompleteInfoDTO> getEventsById(String id);
}
