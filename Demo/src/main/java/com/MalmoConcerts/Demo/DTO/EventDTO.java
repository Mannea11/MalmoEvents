package com.MalmoConcerts.Demo.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventDTO {


    private String name;
    private String id;
    private String imageUrl;
    private String startDate;
    private String venueName;

    public EventDTO(String name, String id, String imageUrl, String startDate, String venueName) {
        this.name = name;
        this.id = id;
        this.imageUrl = imageUrl;
        this.startDate = startDate;
        this.venueName = venueName;
    }}