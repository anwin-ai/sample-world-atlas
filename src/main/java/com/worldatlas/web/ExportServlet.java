package com.worldatlas.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/export")
public class ExportServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String file = request.getParameter("file");
        if (file != null) {
            response.setContentType("text/csv");
            response.getOutputStream().write(AppContext.exports().read(file));
            return;
        }
        String csv = AppContext.exports().toCsv(AppContext.countries().listCountries());
        AppContext.exports().save(param(request, "name", "countries.csv"), csv);
        writeText(response, "text/csv", csv);
    }
}
