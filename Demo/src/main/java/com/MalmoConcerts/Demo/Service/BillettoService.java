package com.MalmoConcerts.Demo.Service;

import com.MalmoConcerts.Demo.DTO.Billetto.BillettoCompleteInfoDTO;
import com.MalmoConcerts.Demo.DTO.Billetto.BillettoInfoDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BillettoService {

    Flux<BillettoInfoDTO> getEventByCategory(int limit, String category);

    Flux<BillettoInfoDTO> getAllEvents(int limit);

    Mono<BillettoCompleteInfoDTO> getEventsById(String id);
}
