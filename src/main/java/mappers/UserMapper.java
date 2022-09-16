package mappers;

import dto.EventDTO;
import dto.UserDTO;
import model.Event;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public UserDTO userToDTO (User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        List<EventDTO> eventDTOList = new ArrayList<>();
        List<Event> eventList = user.getEventList();
        for (Event event : eventList) {
            eventDTOList.add(new EventDTO(event.getId()));
        }
        userDTO.setEventDTOList(eventDTOList);
       return userDTO;
    }
}
