package mapper;

import dto.EventDTO;
import dto.FileDTO;
import dto.UserDTO;
import model.Event;
import model.File;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class FileMapper {
    public File fileFromFileDTO (FileDTO fileDTO) {
        File file = new File();
        file.setId(fileDTO.getId());
        file.setName(fileDTO.getName());
        file.setEvent(fileDTO.getEvent());
        return file;
    }
}
