package com.MalmoConcerts.Demo.DTO.CommonDTO;

import com.MalmoConcerts.Demo.Model.Billetto.Location;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class CommonInfoDTO {

    private String id;
    private String title;
    private String image;
    private String location;
    private String dateTime;
    private String venueName;
    private String startDate;
    private String endDate;

    public CommonInfoDTO(String name, String id, Object o, String date) {
    }

    public CommonInfoDTO(String name, String id, String imageUrl, String dateTime, String venueName) {
    }

    public CommonInfoDTO(String id, String title, String image, String locationObj, String startDate, String endDate) {
    }

    public CommonInfoDTO() {

    }
}