package com.worldatlas.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        render(request, response, "login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<String> token = AppContext.auth().signIn(request.getParameter("username"), request.getParameter("password"));
        if (token.isEmpty()) {
            request.setAttribute("error", "Unknown user or wrong password for " + request.getParameter("username"));
            render(request, response, "login");
            return;
        }
        Cookie session = new Cookie("ATLAS_SESSION", token.get());
        session.setPath("/");
        response.addCookie(session);
        response.sendRedirect(param(request, "returnTo", request.getContextPath() + "/countries"));
    }
}
