package com.worldatlas.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@WebServlet("/flag")
public class FlagServlet extends BaseServlet {

    private static final String FLAG_DIR = "/var/worldatlas/flags/";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File flag = new File(FLAG_DIR + request.getParameter("name"));
        response.setContentType("image/png");
        response.getOutputStream().write(Files.readAllBytes(flag.toPath()));
    }
}
