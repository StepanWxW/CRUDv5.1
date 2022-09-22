package mapper;

import dto.EventDTO;
import dto.UserDTO;
import model.Event;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public UserDTO userDTOFromUser (User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        List<EventDTO> eventDTOList = new ArrayList<>();
        List<Event> eventList = user.getEventList();
        if (eventList != null) {
            for (Event event : eventList) {
                eventDTOList.add(new EventDTO(event.getId()));
            }
        }
       return userDTO;

    }
    public User userFromUserDTO (UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        List<Event> eventList = new ArrayList<>();
        if (userDTO.getEventDTOList() != null) {
        List<EventDTO> eventDTOList = userDTO.getEventDTOList();
        for(EventDTO eventDTO : eventDTOList) {
            eventList.add(new Event(eventDTO.getId()));
        }
        }
        user.setEventList(eventList);
        return user;
    }
    public List<UserDTO> allUserDTOFromAllUser(List<User> userList) {
        List<UserDTO> userDTOList = new ArrayList<>();
        if (userList != null) {
            for (User user : userList) {
                userDTOList.add(userDTOFromUser(user));
            }
        }
        return userDTOList;
    }
}
