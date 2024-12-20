package com.pdi.EventMgmt.Controller;

import com.pdi.EventMgmt.Model.ApiResponse;
import com.pdi.EventMgmt.Model.EventModel;
import com.pdi.EventMgmt.Model.EventResponse;
import com.pdi.EventMgmt.Service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController  {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping  //write
    public ResponseEntity<ApiResponse<EventResponse>> createEvent(@RequestBody EventModel eventModel) {
        EventResponse eventResponse = eventService.createEvent(eventModel);
        return new ResponseEntity<>(new ApiResponse<>(true, "Event created successfully", eventResponse), HttpStatus.CREATED);
    }

    @GetMapping  //Read
    public ResponseEntity<ApiResponse<List<EventResponse>>> getAllEvents() {
        List<EventResponse> events = eventService.getAllEvents();
        return new ResponseEntity<>(new ApiResponse<>(true, "Events fetched successfully", events), HttpStatus.OK);
    }

    @GetMapping("/category/{categoryName}")  //Read
    public ResponseEntity<ApiResponse<List<EventResponse>>> getEventsByCategory(@PathVariable String categoryName) {
        List<EventResponse> events = eventService.getEventsByCategory(categoryName);
        return new ResponseEntity<>(new ApiResponse<>(true, "Events fetched successfully", events), HttpStatus.OK);
    }

    //get(categoryId)
    //Get()
    //put
    //delete
}
