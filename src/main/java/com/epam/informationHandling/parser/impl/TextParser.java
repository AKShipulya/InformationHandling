package com.epam.informationHandling.parser.impl;

import com.epam.informationHandling.entity.Component;
import com.epam.informationHandling.entity.Composite;
import com.epam.informationHandling.parser.Parser;

public class TextParser extends AbstractTextParser {

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public Component parse(String text) {
        Component composite = new Composite();
        String[] parts = text.split("\n");
        for (String part : parts) {
            Component paragraph = getSuccessor().parse(part);
            composite.add(paragraph);
        }
        return composite;
    }
}
