package com.znaji.recipe7;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;

import java.awt.*;
import java.util.Map;

public class PlainTextView implements View {
    @Override
    public String getContentType() {
        return MediaType.TEXT_PLAIN_VALUE;
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setContentType(getContentType());
        response.getWriter().write("THIS IS A SIMPLE PLAIN TEXT VIEW, generated on: " + model.get("today"));
    }
}
