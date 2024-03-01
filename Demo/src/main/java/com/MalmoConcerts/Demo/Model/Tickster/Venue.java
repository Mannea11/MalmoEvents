package com.MalmoConcerts.Demo.Model.Tickster;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Venue {
    private String id;
    private String name;
    private String address;
    private Geo geo;
}
