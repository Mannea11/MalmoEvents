package com.MalmoConcerts.Demo.Controller;

import com.MalmoConcerts.Demo.Client.TicketMasterClient;
import com.MalmoConcerts.Demo.DTO.TicketMaster.TicketMasterCompleteInfoDTO;
import com.MalmoConcerts.Demo.DTO.TicketMaster.TicketMasterInfoDTO;
import com.MalmoConcerts.Demo.Service.TicketmasterServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ticketmaster")
public class TicketMasterController {

    private final TicketmasterServiceImpl ticketmasterServiceImpl;

    private final TicketMasterClient ticketMasterClient;

    @Autowired
    public TicketMasterController(TicketmasterServiceImpl ticketmasterServiceImpl, TicketMasterClient ticketMasterClient) {
        this.ticketmasterServiceImpl = ticketmasterServiceImpl;
        this.ticketMasterClient = ticketMasterClient;
    }

    @GetMapping("/event")
    public Flux<TicketMasterInfoDTO> getAllEvents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "100") int size
    ) {
        Logger logger = LoggerFactory.getLogger(this.getClass());

        return ticketmasterServiceImpl.getAllEvents(page, size)
                .doOnError(ex -> logger.error("Error fetching events: {}", ex.getMessage(), ex))
                .onErrorResume(ex -> Flux.empty());
    }

    @GetMapping("category/{categoryId}")
    public Flux<TicketMasterInfoDTO>getEventByCategory(
            @PathVariable String categoryId,
            @RequestParam(defaultValue = "100") int size,
            @RequestParam(defaultValue = "0") int page) {
        return ticketmasterServiceImpl.getEventsByCategory(page,size,categoryId);
    }

    @GetMapping("/all")
    public String getAll() {
        return ticketMasterClient.getAll();
    }

    @GetMapping("/{eventId}")
    public Mono<TicketMasterCompleteInfoDTO> getEventInfo(@PathVariable String eventId) {
        return ticketmasterServiceImpl.getEventsById(eventId);
    }

}