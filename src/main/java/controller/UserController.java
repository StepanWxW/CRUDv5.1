package controller;

import dto.UserDTO;
import model.User;
import mapper.UserMapper;
import repository.implementation.UserRepositoryImpl;

public class UserController {
    private final UserRepositoryImpl userRepository = new UserRepositoryImpl();
    private final UserMapper userMapper = new UserMapper();
    public UserDTO getByIdToDto (Long id){
        return userMapper.userDTOFromUser(userRepository.getById(id));
    }
    public User createUserFromUserDTO (UserDTO userDTO){
        return userRepository.create(userMapper.userFromUserDTO(userDTO));
    }
    public void deleteUserFromId (Long id) {
        userRepository.remove(id);
    }

    public User updateUserFromUserDTO(UserDTO userDTO) {
        return userRepository.update(userMapper.userFromUserDTO(userDTO));
    }
}
