package com.epam.informationHandling.parser;

import com.epam.informationHandling.parser.Parser;
import com.epam.informationHandling.parser.impl.ParagraphParser;
import com.epam.informationHandling.parser.impl.TextParser;
import com.epam.informationHandling.parser.impl.SentenceParser;

public class ParserBuilder {

    public Parser build() {
        return new TextParser(new ParagraphParser(new SentenceParser()));
    }
}
