package mapper;

import dto.EventDTO;
import model.Event;
import model.File;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class EventMapper {
    UserMapper userMapper = new UserMapper();
    FileMapper fileMapper = new FileMapper();
    public EventDTO eventDTOFromEvent (Event event) {
        EventDTO eventDTO = new EventDTO();
        eventDTO.setId(event.getId());
        eventDTO.setStatus(event.getStatus());
        eventDTO.setCreate(event.getCreate());
        eventDTO.setUpdate(event.getUpdate());
        eventDTO.setUserDTO(userMapper.userDTOFromUser(new User(event.getUser().getId())));
        eventDTO.setFileDTO(fileMapper.fileDTOFromFile(new File(event.getFile().getId())));
        return eventDTO;
    }
    public Event eventFromEventDTO (EventDTO eventDTO) {
        Event event = new Event();
        event.setId(eventDTO.getId());
        event.setStatus(eventDTO.getStatus());
        event.setCreate(eventDTO.getCreate());
        event.setUpdate(eventDTO.getUpdate());
        event.setUser(userMapper.userFromUserDTO(eventDTO.getUserDTO()));
        event.setFile(fileMapper.fileFromFileDTO(eventDTO.getFileDTO()));
        return event;
    }
    public List<EventDTO> allEventDTOFromAllEvent(List<Event> eventList) {
        List<EventDTO> eventDTOList = new ArrayList<>();
        if (eventList != null) {
            for (Event event : eventList) {
                eventDTOList.add(eventDTOFromEvent(event));
            }
        }
        return eventDTOList;
    }
}
