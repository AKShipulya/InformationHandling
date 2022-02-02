package com.epam.informationhandling.parser;

import com.epam.informationhandling.parser.impl.ParagraphParser;
import com.epam.informationhandling.parser.impl.SentenceParser;
import com.epam.informationhandling.parser.impl.TextParser;

public class ParserBuilder {

    public Parser build() {
        return new TextParser(new ParagraphParser(new SentenceParser()));
    }
}
