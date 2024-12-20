package com.pdi.EventMgmt.Service;

import com.pdi.EventMgmt.Model.VenueModel;
import com.pdi.EventMgmt.Model.VenueResponse;

import java.util.List;

public interface VenueService {

    VenueResponse createVenue(VenueModel venueModel);
    List<VenueResponse> getAllVenues();

}
