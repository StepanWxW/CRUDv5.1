package controller;

import controller.inter.UserController;
import dto.UserDTO;
import model.User;
import mapper.UserMapper;
import repository.implementation.UserRepositoryImpl;

import java.util.List;

public class UserControllerImpl implements UserController {
    private final UserRepositoryImpl userRepository = new UserRepositoryImpl();
    private final UserMapper userMapper = new UserMapper();
    public UserDTO getByIdToDTO(Long id){
        return userMapper.userDTOFromUser(userRepository.getById(id));
    }
    public User createFromDTO(UserDTO userDTO){
        return userRepository.create(userMapper.userFromUserDTO(userDTO));
    }
    public void deleteFromId(Long id) {
        userRepository.remove(id);
    }

    public User updateFromDTO(UserDTO userDTO) {
        return userRepository.update(userMapper.userFromUserDTO(userDTO));
    }

    public List<UserDTO> getAllToDTO() {
        return userMapper.allUserDTOFromAllUser(userRepository.getAll());
    }
}
