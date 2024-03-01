package com.MalmoConcerts.Demo.DTO.Tickster;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicksterInfoDTO {

    private String title;

    private String id;

    private String image;

    private String startDate;

    private String endDate;

    private String venueName;

    public TicksterInfoDTO(String title, String id, String image, String startDate,String endDate, String venueName) {
        this.title = title;
        this.id = id;
        this.image = image;
        this.startDate = startDate;
        this.endDate = endDate;
        this.venueName = venueName;
    }
}
