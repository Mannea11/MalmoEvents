package com.MalmoConcerts.Demo.Model.Billetto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventInfo {
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("image_link")
    private String image;
    @JsonProperty("location")
    //nedan är addressen INTE location..
    private Location location;
    @JsonProperty("startdate")
    private String startDate;
    @JsonProperty("enddate")
    private String endDate;
    @JsonProperty("description")
    private String description;

    @JsonProperty("minimum_price")
    private MinimumPrice minPrice;
    @JsonProperty("url")
    private String url;
}
