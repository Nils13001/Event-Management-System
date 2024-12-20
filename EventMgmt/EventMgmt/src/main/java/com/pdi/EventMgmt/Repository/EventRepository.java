package com.pdi.EventMgmt.Repository;

import com.pdi.EventMgmt.Entity.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Integer> {

    List<EventEntity> findByCategoryCategoryName(String categoryName);

}
