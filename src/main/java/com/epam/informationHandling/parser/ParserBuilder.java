package com.epam.informationHandling.parser;

import com.epam.informationHandling.parser.impl.ParagraphParser;
import com.epam.informationHandling.parser.impl.SentenceParser;
import com.epam.informationHandling.parser.impl.TextParser;

public class ParserBuilder {

    public Parser build() {
        return new TextParser(new ParagraphParser(new SentenceParser()));
    }
}
