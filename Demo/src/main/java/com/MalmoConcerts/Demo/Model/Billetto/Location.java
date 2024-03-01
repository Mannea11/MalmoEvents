package com.MalmoConcerts.Demo.Model.Billetto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class Location {

    @JsonProperty("location_name")
    private String location;

    @JsonProperty("address_line")
    private String addressLine;

    @JsonProperty("coordinates")
    private Coordinates coordinates;
}