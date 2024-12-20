package com.pdi.EventMgmt.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eventId;

    private String eventName;
    private String description;
    private String date;
    private String time;
    private Double budget;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId")
    private CategoryEntity category;

}
