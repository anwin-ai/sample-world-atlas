package com.worldatlas.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public abstract class BaseServlet extends HttpServlet {

    protected void render(HttpServletRequest request, HttpServletResponse response, String view)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/" + view + ".jsp").forward(request, response);
    }

    protected String param(HttpServletRequest request, String name, String fallback) {
        String value = request.getParameter(name);
        return value == null || value.isBlank() ? fallback : value;
    }

    protected void writeText(HttpServletResponse response, String contentType, String body) throws IOException {
        response.setContentType(contentType);
        response.getWriter().write(body);
    }
}
