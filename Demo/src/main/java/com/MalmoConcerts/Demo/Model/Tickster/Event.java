package com.MalmoConcerts.Demo.Model.Tickster;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Event {

    private int totalItems;
    private int skipped;
    private List<EventItem> items;

}