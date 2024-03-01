package com.MalmoConcerts.Demo.Model.TicketMaster;

import com.MalmoConcerts.Demo.Model.TicketMaster.Dates;
import com.MalmoConcerts.Demo.Model.TicketMaster.Embedded;
import com.MalmoConcerts.Demo.Model.TicketMaster.Image;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Event {
    @JsonProperty("name")
    private String name;

    @JsonProperty("id")
    private String id;

    @JsonProperty("images")
    private List<Image> images;

    @JsonProperty("dates")
    private Dates dates;

    @JsonProperty("_embedded")
    private Embedded embedded;
}