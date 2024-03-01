package com.MalmoConcerts.Demo.Model.TicketMaster;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EventInfo {
    private String name;
    private String description;
    private List<Image> images;
    @JsonProperty("_embedded")
    private Embedded embedded;
    @JsonProperty("dates")
    private Dates dates;
    private List<Price> priceRanges;
    private Location location;
    private String url;
}
