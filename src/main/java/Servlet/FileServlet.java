package Servlet;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.FileController;

import dto.FileDTO;
import dto.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.List;

@WebServlet(urlPatterns = "/file/*")
@MultipartConfig(location = "C:/JavaCore1/CRUDv5.1")
public class FileServlet extends HttpServlet {
    private final FileController fileController = new FileController();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String[] parts = pathInfo.split("/");
        if (parts.length == 0) {
            List<FileDTO> fileDTOList = fileController.getAllToDTO();
            String gsonStringList = gson.toJson(fileDTOList);
            resp.setContentType("application/json; charset=UTF-8");

            PrintWriter out = resp.getWriter();
            out.write(gsonStringList);
            resp.setStatus(200);
        } else {
            String param1 = parts[1];

            Long userId = Long.parseLong(param1);

            req.setCharacterEncoding("UTF-8");

            FileDTO fileDto = fileController.getByIdToDto(userId);
            String gsonString = gson.toJson(fileDto);

            resp.setContentType("application/json; charset=UTF-8");
            resp.setStatus(200);
            PrintWriter out = resp.getWriter();
            out.write(gsonString);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Part part : req.getParts()) {
            String name = part.getSubmittedFileName();
            part.write(name);
            fileController.createFileFromFileDTO(new FileDTO(name));
        }
        resp.setStatus(200);
    }
}
