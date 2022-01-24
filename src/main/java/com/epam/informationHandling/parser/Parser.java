package com.epam.informationHandling.parser;

import com.epam.informationHandling.entity.Component;
import com.epam.informationHandling.exception.TextException;

public interface Parser {

    Component parse(String text) throws TextException;
}
