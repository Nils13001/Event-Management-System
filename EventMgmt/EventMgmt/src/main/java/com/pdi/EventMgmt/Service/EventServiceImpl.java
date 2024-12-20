package com.pdi.EventMgmt.Service;

import com.pdi.EventMgmt.Entity.CategoryEntity;
import com.pdi.EventMgmt.Entity.EventEntity;
import com.pdi.EventMgmt.Exception.CategoryNotFoundException;
import com.pdi.EventMgmt.Model.EventModel;
import com.pdi.EventMgmt.Model.EventResponse;
import com.pdi.EventMgmt.Repository.CategoryRepository;
import com.pdi.EventMgmt.Repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService{

    private final EventRepository eventRepository;
    private final CategoryRepository categoryRepository;

    public EventServiceImpl(EventRepository eventRepository, CategoryRepository categoryRepository) {
        this.eventRepository = eventRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public EventResponse createEvent(EventModel eventModel) {

        CategoryEntity category = categoryRepository.findByCategoryId(eventModel.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category with ID " + eventModel.getCategoryId() + " not found"));


        EventEntity event = new EventEntity();
        event.setEventName(eventModel.getEventName());
        event.setDescription(eventModel.getDescription());
        event.setDate(eventModel.getDate());
        event.setTime(eventModel.getTime());
        event.setBudget(eventModel.getBudget());
        event.setCategory(category);

        event = eventRepository.save(event);


        return mapToEventResponse(event);
    }
    @Override
    public List<EventResponse> getEventsByCategory(String categoryName) {
        List<EventEntity> events = eventRepository.findByCategoryCategoryName(categoryName);

        return events.stream()
                .map(this::mapToEventResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventResponse> getAllEvents() {
        List<EventEntity> events = eventRepository.findAll();

        return events.stream()
                .map(this::mapToEventResponse)
                .collect(Collectors.toList());
    }

    //Helper method
    private EventResponse mapToEventResponse(EventEntity event) {
        return new EventResponse(
                event.getEventId(),
                event.getEventName(),
                event.getDescription(),
                event.getDate(),
                event.getTime(),
                event.getBudget(),
                event.getCategory().getCategoryName()
        );
    }
}
