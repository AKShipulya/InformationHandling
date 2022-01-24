package com.epam.informationHandling.parser.impl;

import com.epam.informationHandling.entity.Component;
import com.epam.informationHandling.entity.Composite;
import com.epam.informationHandling.exception.TextException;
import com.epam.informationHandling.parser.Parser;

public abstract class AbstractTextParser implements Parser {

    private final Parser successor;

    public AbstractTextParser(Parser successor) {
        this.successor = successor;
    }

    public AbstractTextParser() {
        successor = null;
    }

    protected Parser getSuccessor() {
        return successor;
    }

    protected Composite templateParse(String text, String regexp) throws TextException {
        if (text.isEmpty() && regexp.isEmpty()) {
            throw new TextException("There is no text for parsing!");
        }
        Composite result = new Composite();
        String[] splitText = text.split(regexp);
        for (String part : splitText) {
            Component composite = getSuccessor().parse(part);
            result.add(composite);
        }
        return result;
    }
}
