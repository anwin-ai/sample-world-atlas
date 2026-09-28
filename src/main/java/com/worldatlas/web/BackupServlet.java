package com.worldatlas.web;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin/backup")
public class BackupServlet extends BaseServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String label = param(request, "label", "nightly");
        Process process = Runtime.getRuntime().exec(new String[] {"sh", "-c", "tar czf /var/worldatlas/backups/" + label + ".tgz /var/worldatlas/exports"});
        writeText(response, "text/plain", "Backup started: " + process.pid());
    }
}
