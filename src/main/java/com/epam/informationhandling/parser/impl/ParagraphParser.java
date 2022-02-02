package com.epam.informationhandling.parser.impl;

import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.exception.TextException;
import com.epam.informationhandling.parser.Parser;

public class ParagraphParser extends AbstractTextParser {
    private static final String REGEXP = "(?<=((\\.)|(!)|(\\?)))\\s+(?=[A-Z])";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String text) throws TextException {
        return templateParse(text, REGEXP);
    }
}
