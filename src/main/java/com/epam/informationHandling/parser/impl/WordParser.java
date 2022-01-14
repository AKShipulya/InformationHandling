package com.epam.informationHandling.parser.impl;

import com.epam.informationHandling.entity.Component;
import com.epam.informationHandling.entity.Composite;

public class WordParser extends AbstractTextParser {

    public WordParser() {
        super();
    }

    @Override
    public Component parse(String text) {
        Component composite = new Composite();
        String[] parts = text.split("\\s");
        for (String part : parts) {
            Component paragraph = getSuccessor().parse(part);
            composite.add(paragraph);
        }
        return composite;
    }
}
