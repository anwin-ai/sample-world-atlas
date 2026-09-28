package com.worldatlas.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;

@WebServlet("/admin/import")
@MultipartConfig
public class ImportServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part upload = request.getPart("file");
        try (InputStream in = upload.getInputStream()) {
            int imported = "snapshot".equals(request.getParameter("format"))
                    ? AppContext.imports().importSnapshot(in)
                    : AppContext.imports().importPopulationXml(in);
            writeText(response, "text/plain", "Imported " + imported + " countries");
        } catch (Exception e) {
            throw new ServletException("Import failed", e);
        }
    }
}
