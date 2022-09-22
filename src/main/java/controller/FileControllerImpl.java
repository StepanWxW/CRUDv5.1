package controller;

import dto.FileDTO;
import mapper.FileMapper;
import model.File;
import repository.implementation.FileRepositoryImpl;

import java.util.List;


public class FileControllerImpl implements controller.inter.FileController {
    private final FileRepositoryImpl file = new FileRepositoryImpl();
    private final FileMapper fileMapper = new FileMapper();
    public File createFromDTO(FileDTO fileDTO){
        return file.create(fileMapper.fileFromFileDTO(fileDTO));
    }
    public List<FileDTO> getAllToDTO() {
        return fileMapper.allFileDTOFromAllFile(file.getAll());
    }
    public FileDTO getByIdToDTO(Long id){
        return fileMapper.fileDTOFromFile(file.getById(id));
    }
    public File updateFromDTO(FileDTO fileDTO) {
        return file.update(fileMapper.fileFromFileDTO(fileDTO));
    }
    public void deleteFromId(Long id) {
        file.remove(id);
    }
}
