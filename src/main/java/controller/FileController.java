package controller;

import dto.FileDTO;
import dto.UserDTO;
import mapper.FileMapper;
import model.File;
import repository.implementation.FileRepositoryImpl;


public class FileController {
    private final FileRepositoryImpl file = new FileRepositoryImpl();
    private final FileMapper fileMapper = new FileMapper();
    public File createFileFromFileDTO (FileDTO fileDTO){
        return file.create(fileMapper.fileFromFileDTO(fileDTO));
    }

}
