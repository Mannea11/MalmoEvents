package com.MalmoConcerts.Demo.Model.Billetto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Data {
    @JsonProperty("object")
    private String objectType;

    @JsonProperty("data")
    private List<Event> data;
}