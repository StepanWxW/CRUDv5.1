package dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import model.File;
import model.Status;

import java.sql.Timestamp;

@Getter
@Setter
@EqualsAndHashCode
public class EventDTO {
    private Long id;
    private Status status;
    private Timestamp create;
    private Timestamp update;
    private UserDTO userDTO;
    private FileDTO fileDTO;

    public EventDTO() {
    }

    public EventDTO(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "id=" + id +
                ", status=" + status +
                ", create=" + create +
                ", update=" + update +
                ", userDTO=" + userDTO +
                ", fileDTO=" + fileDTO +
                '}';
    }
}
