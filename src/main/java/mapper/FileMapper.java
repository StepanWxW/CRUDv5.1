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
    public FileDTO fileDTOFromFile (File file) {
        FileDTO fileDTO = new FileDTO();
        fileDTO.setId(file.getId());
        fileDTO.setName(file.getName());
        fileDTO.setEvent(file.getEvent());
        return fileDTO;
    }
    public List<FileDTO> allFileDTOFromAllFile(List<File> fileList) {
        List<FileDTO> fileDTOList = new ArrayList<>();
        if (fileList != null) {
            for (File file : fileList) {
                fileDTOList.add(fileDTOFromFile(file));
            }
        }
        return fileDTOList;
    }
}
