package com.MalmoConcerts.Demo.Service;

import com.MalmoConcerts.Demo.DTO.TicketMaster.TicketMasterCompleteInfoDTO;
import com.MalmoConcerts.Demo.DTO.TicketMaster.TicketMasterInfoDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TicketmasterService {

    Flux<TicketMasterInfoDTO> getAllEvents(int page, int size);

    Flux<TicketMasterInfoDTO> getEventsByCategory(int page, int size, String classificationId);

    Mono<TicketMasterCompleteInfoDTO> getEventsById(String id);
}
