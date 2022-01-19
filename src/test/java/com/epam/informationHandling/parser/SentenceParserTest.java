package com.epam.informationHandling.parser;

import com.epam.informationHandling.entity.Component;
import com.epam.informationHandling.entity.Composite;
import com.epam.informationHandling.entity.Lexeme;
import com.epam.informationHandling.parser.impl.SentenceParser;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SentenceParserTest {

    @Test
    public void testParseShouldParseASentenceWithBothExpressionsAndWords() {
        //given
        String testSentence = "Lorem ipsum dolor [8 2 7 4 + * -] sit amet, consetetur sadipscing elitr, sed diam nonumy.";
        Composite expectedComposite = new Composite(Arrays.asList(
                Lexeme.word("Lorem"),
                Lexeme.word("ipsum"),
                Lexeme.word("dolor"),
                Lexeme.expression("[8 2 7 4 + * -]"),
                Lexeme.word("sit"),
                Lexeme.word("amet,"),
                Lexeme.word("consetetur"),
                Lexeme.word("sadipscing"),
                Lexeme.word("elitr,"),
                Lexeme.word("sed"),
                Lexeme.word("diam"),
                Lexeme.word("nonumy.")));
        SentenceParser sentenceParser = new SentenceParser();
        //when
        Component actualSentenceComposite = sentenceParser.parse(testSentence);
        //then
        Assert.assertEquals(expectedComposite, actualSentenceComposite);
    }

}
