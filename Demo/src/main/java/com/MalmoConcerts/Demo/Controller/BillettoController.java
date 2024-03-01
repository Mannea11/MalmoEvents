package com.MalmoConcerts.Demo.Controller;


import com.MalmoConcerts.Demo.Client.BillettoClient;
import com.MalmoConcerts.Demo.DTO.Billetto.BillettoCompleteInfoDTO;
import com.MalmoConcerts.Demo.DTO.Billetto.BillettoInfoDTO;
import com.MalmoConcerts.Demo.Service.BillettoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/billetto")
public class BillettoController {
    private final BillettoServiceImpl billettoService;

    private final BillettoClient billettoClient;

    @Autowired
    public BillettoController(BillettoServiceImpl billettoService, BillettoClient billettoClient) {
        this.billettoService = billettoService;
        this.billettoClient = billettoClient;
    }

    @GetMapping("/all")
    public String getAllMalmo() {
        return billettoClient.getEvents();
    }


    @GetMapping("/event")
    public Flux<BillettoInfoDTO> getEvents(
            @RequestParam(defaultValue = "100") int limit
    ) {
        return billettoService.getAllEvents(limit);
    }

    @GetMapping("/category/{category}")
    public Flux<BillettoInfoDTO> getMusicEvents(
            @RequestParam(defaultValue = "100") int limit,
            @PathVariable String category
    ) {
        return billettoService.getEventByCategory(limit,category);
    }

    @GetMapping("/{eventId}")
    public Mono<BillettoCompleteInfoDTO> getEventInfo(@PathVariable String eventId) {
        return billettoService.getEventsById(eventId);
    }
}