package com.epam.informationhandling.parser.impl;

import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.exception.TextException;
import com.epam.informationhandling.parser.Parser;

public class TextParser extends AbstractTextParser {
    private static final String REGEXP = "\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String text) throws TextException {
        return templateParse(text, REGEXP);
    }
}
