package com.pdi.EventMgmt.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class VenueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int venueId;

    private String venueName;

    private int venueCapacity;

}
