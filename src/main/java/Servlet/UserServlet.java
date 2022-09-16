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
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/user/*")
public class UserServlet extends HttpServlet {
    private final UserController userController = new UserController();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String[] parts = pathInfo.split("/");
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
