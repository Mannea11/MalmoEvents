package com.MalmoConcerts.Demo.Model.Billetto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MinimumPrice {
    @JsonProperty("amount_in_cents")
    private int amountInCents;

    private String currency;

}