package Servlet;


import controller.FileController;

import dto.FileDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet(urlPatterns = "/file/*")
public class FileServlet extends HttpServlet {

    private final FileController fileController = new FileController();
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
