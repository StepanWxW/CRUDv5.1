package Servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.UserController;
import dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/user/*")
public class UserServlet extends HttpServlet {
    private final UserController userController = new UserController();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pathInfo = req.getPathInfo();
        String[] parts = pathInfo.split("/");
        if (parts.length == 0) {
            List<UserDTO> userDTOList = userController.getAllToDTO();
            String gsonStringList = gson.toJson(userDTOList);
            resp.setContentType("application/json; charset=UTF-8");
            resp.setStatus(200);
            PrintWriter out = resp.getWriter();
            out.write(gsonStringList);
        } else {
            String param1 = parts[1];

            Long userId = Long.parseLong(param1);

            req.setCharacterEncoding("UTF-8");

            UserDTO userDto = userController.getByIdToDto(userId);
            String gsonString = gson.toJson(userDto);

            resp.setContentType("application/json; charset=UTF-8");
            resp.setStatus(200);
            PrintWriter out = resp.getWriter();
            out.write(gsonString);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        StringBuffer jb = new StringBuffer();
        String line;
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null) {
            jb.append(line);
        }
        UserDTO userDTO = gson.fromJson(String.valueOf(jb), UserDTO.class);
        userController.createUserFromUserDTO(userDTO);
        resp.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pathInfo = req.getPathInfo();
        String[] parts = pathInfo.split("/");
        String param1 = parts[1];

        Long userId = Long.parseLong(param1);

        req.setCharacterEncoding("UTF-8");

        userController.deleteUserFromId(userId);
        resp.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String[] parts = pathInfo.split("/");
        String param1 = parts[1];

        Long userId = Long.parseLong(param1);

        StringBuffer jb = new StringBuffer();
        String line;
        req.setCharacterEncoding("UTF-8");
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null) {
            jb.append(line);
        }
        UserDTO userDTO = gson.fromJson(String.valueOf(jb), UserDTO.class);
        userDTO.setId(userId);
        userController.updateUserFromUserDTO(userDTO);
        resp.setStatus(200);
    }
    
}
