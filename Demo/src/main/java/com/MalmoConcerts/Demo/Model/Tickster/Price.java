package com.MalmoConcerts.Demo.Model.Tickster;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Price {
    @JsonProperty("amount")
    private Double amount;
    private String currency;
}