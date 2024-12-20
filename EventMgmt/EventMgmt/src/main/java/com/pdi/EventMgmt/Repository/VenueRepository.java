package com.pdi.EventMgmt.Repository;

import com.pdi.EventMgmt.Entity.VenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VenueRepository extends JpaRepository<VenueEntity, Integer> {
}
