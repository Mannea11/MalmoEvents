package com.MalmoConcerts.Demo.DTO.TicketMaster;

import com.MalmoConcerts.Demo.Model.Billetto.Location;
import com.MalmoConcerts.Demo.Model.Billetto.MinimumPrice;
import com.MalmoConcerts.Demo.Model.TicketMaster.Image;
import com.MalmoConcerts.Demo.Model.TicketMaster.Price;
import com.MalmoConcerts.Demo.Model.TicketMaster.Start;
import com.MalmoConcerts.Demo.Model.TicketMaster.Venue;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TicketMasterCompleteInfoDTO {
    private String name;
    private String description;
    private String imageUrl;
    private String venueName;
    private String startDate;
    private double minPrice;
    private String latitude;
    private String longitude;
    private String url;

    public TicketMasterCompleteInfoDTO(String name,String description,String imageUrl,String venueName,String startDate,double minPrice,String latitude, String longitude, String url) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.venueName = venueName;
        this.startDate = startDate;
        this.minPrice = minPrice;
        this.latitude = latitude;
        this.longitude = longitude;
        this.url = url;
    }

}
