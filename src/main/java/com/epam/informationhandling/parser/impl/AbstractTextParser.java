package com.epam.informationhandling.parser.impl;

import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.entity.Composite;
import com.epam.informationhandling.exception.TextException;
import com.epam.informationhandling.parser.Parser;

public abstract class AbstractTextParser implements Parser {

    private final Parser successor;

    protected AbstractTextParser(Parser successor) {
        this.successor = successor;
    }

    protected AbstractTextParser() {
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
