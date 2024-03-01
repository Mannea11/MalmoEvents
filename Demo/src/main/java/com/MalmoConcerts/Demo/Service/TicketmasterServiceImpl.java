package com.MalmoConcerts.Demo.Service;


import com.MalmoConcerts.Demo.Client.TicketMasterClient;
import com.MalmoConcerts.Demo.DTO.TicketMaster.TicketMasterCompleteInfoDTO;
import com.MalmoConcerts.Demo.DTO.TicketMaster.TicketMasterInfoDTO;
import com.MalmoConcerts.Demo.Model.TicketMaster.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TicketmasterServiceImpl implements TicketmasterService {

    private final TicketMasterClient ticketMasterClient;

    @Autowired
    public TicketmasterServiceImpl(TicketMasterClient ticketMasterClient) {
        this.ticketMasterClient = ticketMasterClient;
    }

//   @Cacheable(value = "ticketMasterAllEventsCache", key = "{#page, #size}")
    public Flux<TicketMasterInfoDTO> getAllEvents(int page, int size) {
        return ticketMasterClient.getEventsMalmo(page,size)
                .map(event -> {
                    String imageUrl = event.getImages().isEmpty() ? null : event.getImages().get(0).getUrl();
                    String localDate = event.getDates().getStart().getLocalDate();
                    String localTime = event.getDates().getStart().getLocalTime();
                    String dateTime = localDate + "T" + localTime;
                    String venueName = event.getEmbedded().getVenues().stream()
                            .findFirst()
                            .map(Venue::getName)
                            .orElse(null);
                    TicketMasterInfoDTO eventDTO = new TicketMasterInfoDTO(
                            event.getName(),
                            event.getId(),
                            imageUrl,
                            dateTime,
                            venueName
                    );
                    return eventDTO;
                });
    }

    @Cacheable(value = "ticketMasterEventsByCategoryCache", key = "{#page, #size, #classificationId}")
    public Flux<TicketMasterInfoDTO> getEventsByCategory(int page, int size, String classificationId) {
        return ticketMasterClient.getEventsByClassificationID(page,size,classificationId)
                .map(event -> {
                    String imageUrl = event.getImages().isEmpty() ? null : event.getImages().get(0).getUrl();
                    String localDate = event.getDates().getStart().getLocalDate();
                    String localTime = event.getDates().getStart().getLocalTime();
                    String dateTime = localDate + "T" + localTime;
                    String venueName = event.getEmbedded().getVenues().stream()
                            .findFirst()
                            .map(Venue::getName)
                            .orElse(null);
                    TicketMasterInfoDTO eventDTO = new TicketMasterInfoDTO(
                            event.getName(),
                            event.getId(),
                            imageUrl,
                            dateTime,
                            venueName
                    );
                    return eventDTO;
                });
    }

    @Cacheable(value = "ticketMasterEventByIdCache", key = "#id")
    public Mono<TicketMasterCompleteInfoDTO> getEventsById(String id) {
        return ticketMasterClient.getEventInfoById(id)
                .map(eventInfo -> {
                    String imageUrl = eventInfo.getImages().isEmpty() ? null : eventInfo.getImages().get(0).getUrl();
                    String venueName = eventInfo.getEmbedded().getVenues().stream()
                            .findFirst()
                            .map(Venue::getName)
                            .orElse(null);
                    String localDate = eventInfo.getDates().getStart().getLocalDate();
                    String localTime = eventInfo.getDates().getStart().getLocalTime();
                    String dateTime = localDate + "T" + localTime;
                    double price = eventInfo.getPriceRanges().isEmpty() ? null : eventInfo.getPriceRanges().get(0).getMin();
                    String longitude = eventInfo.getEmbedded().getVenues().get(0).getLocation().getLongitude();
                    String latitude = eventInfo.getEmbedded().getVenues().get(0).getLocation().getLatitude();
                    TicketMasterCompleteInfoDTO eventInfoCompleteDTO = new TicketMasterCompleteInfoDTO(
                            eventInfo.getName(),
                            eventInfo.getDescription(),
                            imageUrl,
                            venueName,
                            dateTime,
                            price,
                            longitude,
                            latitude,
                            eventInfo.getUrl()


                    );
                    return eventInfoCompleteDTO;
                });
    }}

