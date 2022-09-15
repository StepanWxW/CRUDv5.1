import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.UserController;
import dto.UserDTO;
import model.User;
import org.modelmapper.ModelMapper;
import repository.implementation.UserRepositoryImpl;

public class Start {
    public static void main(String[] args) {
        UserController userController = new UserController();

        UserDTO userDto = userController.getByIdToDto(1L);
//
//        try {
//            String jsonUser = new ObjectMapper().writeValueAsString(userDto);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        UserRepositoryImpl userRepository = new UserRepositoryImpl();
//        User user = userRepository.getById(1L);
//        System.out.println(user);
    }
}
