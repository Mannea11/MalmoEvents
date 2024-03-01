package com.MalmoConcerts.Demo.Model.TicketMaster;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Price {
    private String type;
    private String currency;
    private Double min;
    private Double max;
}