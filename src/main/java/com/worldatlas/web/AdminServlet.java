package com.worldatlas.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/population")
public class AdminServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("countries", AppContext.countries().listCountries());
        render(request, response, "admin");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        long population = Long.parseLong(request.getParameter("population"));
        AppContext.population().updatePopulation(code, population, param(request, "by", "anonymous"));
        response.sendRedirect(request.getContextPath() + "/countries?code=" + code);
    }
}
