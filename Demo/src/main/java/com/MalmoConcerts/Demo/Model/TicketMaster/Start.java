package com.MalmoConcerts.Demo.Model.TicketMaster;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Start {
    @JsonProperty("localDate")
    private String localDate;

    @JsonProperty("localTime")
    private String localTime;

}