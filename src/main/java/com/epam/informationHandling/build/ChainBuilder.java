package com.epam.informationHandling.build;

import com.epam.informationHandling.parser.Parser;
import com.epam.informationHandling.parser.impl.ParagraphParser;
import com.epam.informationHandling.parser.impl.TextParser;
import com.epam.informationHandling.parser.impl.WordParser;

public class ChainBuilder {

    public Parser build() {
        return new TextParser(new ParagraphParser(new WordParser()));
    }
}
