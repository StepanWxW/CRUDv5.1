package Servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.EventControllerImpl;
import dto.EventDTO;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(urlPatterns = "/event/*")
public class EventServlet extends HttpServlet {
    private final EventControllerImpl eventController = new EventControllerImpl();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String[] parts = pathInfo.split("/");
        if (parts.length == 0) {
            List<EventDTO> eventDTOList = eventController.getAllToDTO();
            String gsonStringList = gson.toJson(eventDTOList);
            resp.setContentType("application/json; charset=UTF-8");
            resp.setStatus(200);
            PrintWriter out = resp.getWriter();
            out.write(gsonStringList);
        } else {
            String param1 = parts[1];

            Long eventId = Long.parseLong(param1);

            req.setCharacterEncoding("UTF-8");

            EventDTO eventDTO = eventController.getByIdToDTO(eventId);
            String gsonString = gson.toJson(eventDTO);

            resp.setContentType("application/json; charset=UTF-8");
            resp.setStatus(200);
            PrintWriter out = resp.getWriter();
            out.write(gsonString);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer jb = new StringBuffer();
        String line;
        BufferedReader reader = req.getReader();
        while ((line = reader.readLine()) != null) {
            jb.append(line);
        }
        EventDTO eventDTO = gson.fromJson(String.valueOf(jb), EventDTO.class);
        eventController.createFromDTO(eventDTO);
        resp.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String[] parts = pathInfo.split("/");
        String param1 = parts[1];

        Long eventId = Long.parseLong(param1);

        req.setCharacterEncoding("UTF-8");

        eventController.deleteFromId(eventId);
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
        EventDTO eventDTO = gson.fromJson(String.valueOf(jb), EventDTO.class);
        eventDTO.setId(userId);
        eventController.updateFromDTO(eventDTO);
        resp.setStatus(200);
    }
}
