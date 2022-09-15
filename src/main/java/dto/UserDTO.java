package dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.Event;

import java.util.List;
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserDTO {
    private Long id;
    private String name;
    private List<EventDTO> eventDTOList;
}
