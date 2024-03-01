package com.MalmoConcerts.Demo.Model.Tickster;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EventItem {
    private String id;
    private String name;
    private String startUtc;
    private String endUtc;
    private Organizer organizer;
    private Venue venue;
    private List<Link> _links;

}
