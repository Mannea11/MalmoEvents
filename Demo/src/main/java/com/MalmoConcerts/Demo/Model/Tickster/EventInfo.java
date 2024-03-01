package com.MalmoConcerts.Demo.Model.Tickster;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class EventInfo {
    private String name;
    private Description description;
    private Venue venue;
    private String startUtc;
    private String endUtc;
    @JsonProperty("products")
    private List<Product> products;
    private String imageUrl;
    private String infoUrl;

    @Override
    public String toString() {
        return "EventInfo{" +
                "name='" + name + '\'' +
                ", description=" + description +
                ", venue=" + venue +
                ", startUtc='" + startUtc + '\'' +
                ", endUtc='" + endUtc + '\'' +
                ", products=" + products +
                ", imageUrl='" + imageUrl + '\'' +
                ", infoUrl='" + infoUrl + '\'' +
                '}';
    }
}
