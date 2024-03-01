package com.MalmoConcerts.Demo.Model.TicketMaster;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {

    private String longitude;

    private String latitude;


}
