package com.pdi.EventMgmt.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class VenueResponse {

    private int venueId;
    private String venueName;
    private int venueCapacity;

}
