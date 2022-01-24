package com.epam.informationHandling.parser.impl;

import com.epam.informationHandling.entity.Composite;
import com.epam.informationHandling.entity.Lexeme;
import com.epam.informationHandling.exception.TextException;

public class SentenceParser extends AbstractTextParser {
    private static final String LEXEME_REGEXP = "(?:\\s(?=\\[)|(?<=\\])\\s)";
    private static final String REGEXP = "\\s";

    public SentenceParser() {
        super();
    }

    @Override
    public Composite parse(String text) throws TextException {
        if (text.isEmpty()) {
            throw new TextException("There is no text for parsing!");
        }
        Composite composite = new Composite();
        String[] lexemes = text.split(LEXEME_REGEXP);
        for (String lexeme : lexemes) {
            if (lexeme.contains("[")) {
                composite.add(Lexeme.expression(lexeme));
            } else {
                transformWordToComposite(lexeme, composite);
            }
        }
        return composite;
    }

    private void transformWordToComposite(String word, Composite composite) {
        String[] split = word.split(REGEXP);
        for (String string : split) {
            composite.add(Lexeme.word(string));
        }
    }
}
