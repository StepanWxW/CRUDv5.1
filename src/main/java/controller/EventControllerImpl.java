package controller;

import controller.inter.EventController;
import dto.EventDTO;
import mapper.EventMapper;
import model.Event;
import repository.implementation.EventRepositoryImpl;

import java.util.List;

public class EventControllerImpl implements EventController {
    private final EventRepositoryImpl eventRepository = new EventRepositoryImpl();
    private final EventMapper eventMapper = new EventMapper();
    @Override
    public Event createFromDTO(EventDTO eventDTO) {
        return eventRepository.create(eventMapper.eventFromEventDTO(eventDTO));
    }

    @Override
    public List<EventDTO> getAllToDTO() {
        return eventMapper.allEventDTOFromAllEvent(eventRepository.getAll());
    }

    @Override
    public EventDTO getByIdToDTO(Long id) {
        return eventMapper.eventDTOFromEvent(eventRepository.getById(id));
    }

    @Override
    public Event updateFromDTO(EventDTO eventDTO) {
        return eventRepository.update(eventMapper.eventFromEventDTO(eventDTO));
    }

    @Override
    public void deleteFromId(Long id) {
        eventMapper.allEventDTOFromAllEvent(eventRepository.getAll());
    }
}
