package com.MalmoConcerts.Demo.Controller;

import com.MalmoConcerts.Demo.Client.TicksterClient;
import com.MalmoConcerts.Demo.DTO.Tickster.TicksterCompleteInfoDTO;
import com.MalmoConcerts.Demo.DTO.Tickster.TicksterInfoDTO;
import com.MalmoConcerts.Demo.Service.TicksterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tickster")
public class TicksterController {

    private final TicksterClient ticksterClient;

    private final TicksterServiceImpl ticksterServiceImpl;

@Autowired
    public TicksterController(TicksterClient ticksterClient, TicksterServiceImpl ticksterServiceImpl) {
        this.ticksterClient = ticksterClient;
    this.ticksterServiceImpl = ticksterServiceImpl;
}

    @GetMapping("/allevents")
    public Mono<String> getAllEvents() {
        return ticksterClient.getAllEvents();
    }


    @GetMapping("/event")
    public Flux<TicksterInfoDTO> getEvents() {
        return ticksterServiceImpl.getAllEvents();
    }



    @GetMapping("/category/{categoryId}")
    public Flux<TicksterInfoDTO> getEventsByCategory(@PathVariable String categoryId) {
    return ticksterServiceImpl.getEventsByCategory(categoryId);
    }

    @GetMapping("/{id}")
    public Mono<TicksterCompleteInfoDTO> getEventById(@PathVariable String id) {
    return ticksterServiceImpl.getEventsById(id);
    }
}
