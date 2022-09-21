package controller;

import dto.FileDTO;
import dto.UserDTO;
import mapper.FileMapper;
import model.File;
import repository.implementation.FileRepositoryImpl;

import java.util.List;


public class FileController {
    private final FileRepositoryImpl file = new FileRepositoryImpl();
    private final FileMapper fileMapper = new FileMapper();
    public File createFileFromFileDTO (FileDTO fileDTO){
        return file.create(fileMapper.fileFromFileDTO(fileDTO));
    }
    public List<FileDTO> getAllToDTO() {
        return fileMapper.allFileDTOFromAllFile(file.getAll());
    }
    public FileDTO getByIdToDto (Long id){
        return fileMapper.fileDTOFromFile(file.getById(id));
    }
}
