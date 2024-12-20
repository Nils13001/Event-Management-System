package com.pdi.EventMgmt.Controller;


import com.pdi.EventMgmt.Model.ApiResponse;
import com.pdi.EventMgmt.Model.VenueModel;
import com.pdi.EventMgmt.Model.VenueResponse;
import com.pdi.EventMgmt.Service.VenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/venue")
public class VenueController {

    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @PostMapping
    // public ResponseEntity<Event>
    //public ResponseEntity<VenueResponse>
    //Standard Format

    public ResponseEntity<ApiResponse<VenueResponse>> createVenue(@RequestBody VenueModel venueModel) {
        VenueResponse venueResponse = venueService.createVenue(venueModel);
        return new ResponseEntity<>(new ApiResponse<>(true, "Venue created successfully", venueResponse), HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<ApiResponse<List<VenueResponse>>> getAllVenues() {
        List<VenueResponse> categories = venueService.getAllVenues();
        return new ResponseEntity<>(new ApiResponse<>(true, "Venues fetched successfully", categories), HttpStatus.OK);
    }
}
