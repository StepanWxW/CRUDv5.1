package Servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
import repository.implementation.UserRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/user/*")
public class UserServlet extends HttpServlet {
    UserRepositoryImpl userRepository = new UserRepositoryImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String[] parts = pathInfo.split("/");
        String param1 = parts[1];

        Long userId = Long.parseLong(param1);

        req.setCharacterEncoding("UTF-8");

        User user = userRepository.getById(userId);
        String jsonUser = new ObjectMapper().writeValueAsString(user);

        resp.setContentType("application/json; charset=UTF-8");
        resp.setStatus(200);
        PrintWriter out = resp.getWriter();
        out.write(jsonUser);
    }
}
