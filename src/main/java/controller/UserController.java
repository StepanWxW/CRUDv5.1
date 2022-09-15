package controller;

import dto.UserDTO;
import mappers.UserMapper;
import model.User;
import repository.implementation.UserRepositoryImpl;

public class UserController {
    private final UserRepositoryImpl userRepository= new UserRepositoryImpl();
    public UserDTO getByIdToDto (Long id){
        User user = userRepository.getById(id);
        return UserMapper.INSTANCE.toDto(user);
    }
}
