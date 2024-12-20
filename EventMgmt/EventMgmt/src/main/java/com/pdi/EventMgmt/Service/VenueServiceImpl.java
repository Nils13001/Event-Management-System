package com.pdi.EventMgmt.Service;

import com.pdi.EventMgmt.Entity.VenueEntity;
import com.pdi.EventMgmt.Model.VenueModel;
import com.pdi.EventMgmt.Model.VenueResponse;
import com.pdi.EventMgmt.Repository.VenueRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenueServiceImpl implements VenueService{

    private final VenueRepository venueRepository;

    public VenueServiceImpl(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }


    @Override
    public VenueResponse createVenue(VenueModel venueModel) {
        VenueEntity venue = new VenueEntity();
        venue.setVenueName(venueModel.getVenueName());
        venue.setVenueCapacity(venueModel.getVenueCapacity());
        venue = venueRepository.save(venue);
        return new VenueResponse(venue.getVenueId(), venue.getVenueName(), venue.getVenueCapacity());
    }

    @Override
    public List<VenueResponse> getAllVenues() {
        return venueRepository.findAll().stream()
                .map(venueEntity -> new VenueResponse(venueEntity.getVenueId(), venueEntity.getVenueName(), venueEntity.getVenueCapacity()))
                .collect(Collectors.toList());
    }
}
