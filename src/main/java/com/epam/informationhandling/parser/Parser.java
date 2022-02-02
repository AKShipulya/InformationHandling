package com.epam.informationhandling.parser;

import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.exception.TextException;

public interface Parser {

    Component parse(String text) throws TextException;
}
