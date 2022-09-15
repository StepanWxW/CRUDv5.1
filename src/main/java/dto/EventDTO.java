package dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import model.File;
import model.Status;
import model.User;

import java.sql.Timestamp;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class EventDTO {
    private Long id;
    private Status status;
    private Timestamp create;
    private Timestamp update;
    private UserDTO userDTO;
    File file;
}
