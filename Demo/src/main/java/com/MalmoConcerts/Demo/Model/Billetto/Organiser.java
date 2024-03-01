package com.MalmoConcerts.Demo.Model.Billetto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Organiser {
    @JsonProperty("name")
    private String name;
}
