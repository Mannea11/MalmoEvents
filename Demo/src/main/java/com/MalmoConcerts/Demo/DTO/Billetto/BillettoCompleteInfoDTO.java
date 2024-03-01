package com.MalmoConcerts.Demo.DTO.Billetto;

import com.MalmoConcerts.Demo.Model.Billetto.Location;
import com.MalmoConcerts.Demo.Model.Billetto.MinimumPrice;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BillettoCompleteInfoDTO {

    private String title;

    private String description;

    private String image;

    private String locationObj;

    private String startDate;

    private String endDate;

    private int minPrice;

    private Double latitude;

    private Double longitude;

    private String url;

    public BillettoCompleteInfoDTO(String title, String description, String image, String locationObj, String startDate, String endDate, int minPrice, Double latitude, Double longitude, String url) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.locationObj = locationObj;
        this.startDate = startDate;
        this.endDate = endDate;
        this.minPrice = minPrice;
        this.latitude = latitude;
        this.longitude = longitude;
        this.url = url;
    }
}
