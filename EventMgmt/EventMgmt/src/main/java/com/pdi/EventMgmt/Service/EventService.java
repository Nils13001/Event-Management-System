package com.pdi.EventMgmt.Service;


import com.pdi.EventMgmt.Model.EventModel;
import com.pdi.EventMgmt.Model.EventResponse;

import java.util.List;

public interface EventService {
    EventResponse createEvent(EventModel eventModel);

    List<EventResponse> getEventsByCategory(String categoryName);

    List<EventResponse> getAllEvents();
}