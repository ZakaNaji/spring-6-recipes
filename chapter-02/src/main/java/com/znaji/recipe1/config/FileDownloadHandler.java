package com.znaji.recipe1.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.HttpRequestHandler;

import java.io.IOException;
import java.time.LocalDateTime;

public class FileDownloadHandler implements HttpRequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment; filename=\"example.txt\"");
        response.getWriter().write("THIS IS A TEST FILE? GENERATED ON: " + LocalDateTime.now());
    }
}
