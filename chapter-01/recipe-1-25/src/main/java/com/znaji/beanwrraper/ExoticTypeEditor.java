package com.znaji.beanwrraper;

import java.beans.PropertyEditorSupport;

public class ExoticTypeEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new ExoticType(text));
    }

}
