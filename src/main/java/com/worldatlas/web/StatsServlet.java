package com.worldatlas.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/stats")
public class StatsServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String source = request.getParameter("source");
        String body = source != null
                ? AppContext.stats().fetch(source)
                : AppContext.stats().latestFor(param(request, "country", "IN"));
        writeText(response, "application/json", body);
    }
}
