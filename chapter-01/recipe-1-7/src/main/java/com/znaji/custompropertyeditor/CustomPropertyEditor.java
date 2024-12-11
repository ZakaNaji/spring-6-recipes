package com.znaji.custompropertyeditor;

import com.znaji.Disc;

import java.beans.PropertyEditorSupport;

public class CustomPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || text.isEmpty()) {
            setValue(null);
        } else {
            String[] parts = text.split(",");
            Disc disc = new Disc(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]));
            setValue(disc);
        }
    }
}
