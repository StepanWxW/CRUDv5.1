package Servlet;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import controller.FileControllerImpl;

import dto.FileDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@WebServlet(urlPatterns = "/file/*")
@MultipartConfig(location = "C:/files")
public class FileServlet extends HttpServlet {
    private final FileControllerImpl fileControllerImpl = new FileControllerImpl();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        String[] parts = pathInfo.split("/");
        if (parts.length == 0) {
            List<FileDTO> fileDTOList = fileControllerImpl.getAllToDTO();
            String gsonStringList = gson.toJson(fileDTOList);
            resp.setContentType("application/json; charset=UTF-8");

            PrintWriter out = resp.getWriter();
            out.write(gsonStringList);
            resp.setStatus(200);
        } else {
            String param1 = parts[1];

            Long userId = Long.parseLong(param1);

            req.setCharacterEncoding("UTF-8");

            FileDTO fileDto = fileControllerImpl.getByIdToDTO(userId);
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
            fileControllerImpl.createFromDTO(new FileDTO(name));
        }
        resp.setStatus(200);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pathInfo = req.getPathInfo();
        String[] parts = pathInfo.split("/");
        String param1 = parts[1];

        Long fileId = Long.parseLong(param1);

        req.setCharacterEncoding("UTF-8");
        FileDTO fileDTO = fileControllerImpl.getByIdToDTO(fileId);
        String name = fileDTO.getName();
        Files.delete(Paths.get("C:/files/" + name));
        fileControllerImpl.deleteFromId(fileId);
        resp.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
            String pathInfo = req.getPathInfo();
            String[] parts = pathInfo.split("/");
            String param1 = parts[1];

            Long fileId = Long.parseLong(param1);
            FileDTO fileDTO = fileControllerImpl.getByIdToDTO(fileId);
            String name = fileDTO.getName();
            Files.delete(Paths.get("C:/files/" + name));
        for (Part part : req.getParts()) {
            String newName = part.getSubmittedFileName();
            part.write(newName);
            fileDTO.setName(newName);
            fileControllerImpl.updateFromDTO(fileDTO);
        }
            resp.setStatus(200);
        }
    }

