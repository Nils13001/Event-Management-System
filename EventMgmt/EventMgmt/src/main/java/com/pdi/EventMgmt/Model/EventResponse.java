package com.pdi.EventMgmt.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class EventResponse {

    private int eventId;
    private String eventName;
    private String description;
    private String date;
    private String time;
    private Double budget;
    private String categoryName;

}
