package com.MalmoConcerts.Demo.Model.TicketMaster;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Embedded {
    @JsonProperty("events")
    private List<Event> events;

    @JsonProperty("venues")
    private List<Venue> venues;

}
