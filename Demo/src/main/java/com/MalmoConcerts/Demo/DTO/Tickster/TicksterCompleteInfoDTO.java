package com.MalmoConcerts.Demo.DTO.Tickster;

import com.MalmoConcerts.Demo.Model.Tickster.Description;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicksterCompleteInfoDTO {

    private String name;

    private String venueName;

    private String description;

    private String startDate;

    private String endDate;

    private Double longitude;

    private Double latitude;

    private String image;

    private Double price;

    private String url;

    public TicksterCompleteInfoDTO(String name, String venueName, String description, String startDate, String endDate, Double longitude, Double latitude, String image, Double price, String url) {
        this.name = name;
        this.venueName = venueName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.longitude = longitude;
        this.latitude = latitude;
        this.image = image;
        this.price = price;
        this.url = url;
    }
}
