package com.MalmoConcerts.Demo.Model.TicketMaster;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class Dates {
    @JsonProperty("start")
    private Start start;

}