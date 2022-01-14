package com.epam.informationHandling.parser.impl;

import com.epam.informationHandling.parser.Parser;

public abstract class AbstractTextParser implements Parser {

    private Parser successor;

    public AbstractTextParser() {
    }

    public AbstractTextParser(Parser successor) {
        this.successor = successor;
    }

    protected Parser getSuccessor() {
        return successor;
    }
}
