package dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Event;
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class FileDTO {
    private Long id;
    private String name;
    private Event event;

    public FileDTO(String name) {
        this.name = name;
    }
}
