package com.epam.informationHandling.parser.impl;

import com.epam.informationHandling.entity.Component;
import com.epam.informationHandling.exception.TextException;
import com.epam.informationHandling.parser.Parser;

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
