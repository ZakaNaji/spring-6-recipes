package com.znaji.beanwrraper;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateEditor extends PropertyEditorSupport {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            setValue(format.parse(text));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
