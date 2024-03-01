package com.MalmoConcerts.Demo.DTO.TicketMaster;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketMasterInfoDTO {
    private String title;
    private String id;
    private String image;
    private String dateTime;
    private String venueName;

    public TicketMasterInfoDTO(String title, String id, String image, String dateTime, String venueName) {
        this.title = title;
        this.id = id;
        this.image = image;
        this.dateTime = dateTime;
        this.venueName = venueName;
    }

}