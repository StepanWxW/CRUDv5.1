package dto;


import lombok.*;

import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private List<EventDTO> eventDTOList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EventDTO> getEventDTOList() {
        return eventDTOList;
    }

    public void setEventDTOList(List<EventDTO> eventDTOList) {
        this.eventDTOList = eventDTOList;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", eventDTOList=" + eventDTOList +
                '}';
    }
}
