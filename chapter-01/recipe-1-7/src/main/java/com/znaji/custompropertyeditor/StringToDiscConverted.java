package com.znaji.custompropertyeditor;

import com.znaji.Disc;
import org.springframework.core.convert.converter.Converter;

public class StringToDiscConverted implements Converter<String, Disc> {
    @Override
    public Disc convert(String text) {
        if (text == null || text.isEmpty()) {
            return null;
        } else {
            String[] parts = text.split(",");
            return  new Disc(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]));
        }
    }
}
