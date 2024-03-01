package com.MalmoConcerts.Demo.Model.Billetto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Event {
    @JsonProperty("id")
    private String id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("image_link")
    private String image;
    @JsonProperty("organiser")
    private Organiser organiser;
    @JsonProperty("startdate")
    private String startDate;
    @JsonProperty("enddate")
    private String endDate;

    @Override
    public String toString() {
        return "EventInfo{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
