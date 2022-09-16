package controller;

import dto.UserDTO;
import mappers.UserMapper;
import repository.implementation.UserRepositoryImpl;

public class UserController {
    private final UserRepositoryImpl userRepository = new UserRepositoryImpl();
    private final UserMapper userMapper = new UserMapper();
    public UserDTO getByIdToDto (Long id){
        return userMapper.userToDTO(userRepository.getById(id));
    }
}
