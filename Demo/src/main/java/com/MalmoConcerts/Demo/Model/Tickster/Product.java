package com.MalmoConcerts.Demo.Model.Tickster;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Product {
    private String name;
    private String productType;
    private String description;
    private String mainImageUrl;
    private Price price;
    private List<Variant> variants;
}