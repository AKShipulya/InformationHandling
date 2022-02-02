package com.epam.informationhandling.parser;

import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.entity.Composite;
import com.epam.informationhandling.entity.Lexeme;
import com.epam.informationhandling.exception.TextException;
import com.epam.informationhandling.parser.impl.ParagraphParser;
import com.epam.informationhandling.parser.impl.SentenceParser;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class ParagraphParserTest {
    private static final String FIRST_SENTENCE = "Lorem ipsum dolor sit amet.";
    private static final String SECOND_SENTENCE = "At vero eos et accusam!";
    private static final String THIRD_SENTENCE = "Stet clita kasd gubergren?";
    private static final String FOURTH_SENTENCE = "Lorem ipsum...";

    private static final Component FIRST_SENTENCE_COMPOSITE =
            new Composite(Arrays.asList(Lexeme.word("Lorem"), Lexeme.word("ipsum"), Lexeme.word("dolor"), Lexeme.word("sit"), Lexeme.word("amet.")));
    private static final Component SECOND_SENTENCE_COMPOSITE =
            new Composite(Arrays.asList(Lexeme.word("At"), Lexeme.word("vero"), Lexeme.word("eos"), Lexeme.word("et"), Lexeme.word("accusam!")));
    private static final Component THIRD_SENTENCE_COMPOSITE =
            new Composite(Arrays.asList(Lexeme.word("Stet"), Lexeme.word("clita"), Lexeme.word("kasd"), Lexeme.word("gubergren?")));
    private static final Component FOURTH_SENTENCE_COMPOSITE =
            new Composite(Arrays.asList(Lexeme.word("Lorem"), Lexeme.word("ipsum...")));

    private static final String TEST_PARAGRAPH = FIRST_SENTENCE + " " + SECOND_SENTENCE + " " + THIRD_SENTENCE + " " + FOURTH_SENTENCE;

    private static final Component EXPECTED_COMPOSITE = new Composite(Arrays.asList(FIRST_SENTENCE_COMPOSITE, SECOND_SENTENCE_COMPOSITE, THIRD_SENTENCE_COMPOSITE, FOURTH_SENTENCE_COMPOSITE));

    @Test
    public void testParseShouldParseParagraph() throws TextException {
        //given
        Parser sentenceParser = Mockito.mock(SentenceParser.class);
        Mockito.when(sentenceParser.parse(FIRST_SENTENCE)).thenReturn(FIRST_SENTENCE_COMPOSITE);
        Mockito.when(sentenceParser.parse(SECOND_SENTENCE)).thenReturn(SECOND_SENTENCE_COMPOSITE);
        Mockito.when(sentenceParser.parse(THIRD_SENTENCE)).thenReturn(THIRD_SENTENCE_COMPOSITE);
        Mockito.when(sentenceParser.parse(FOURTH_SENTENCE)).thenReturn(FOURTH_SENTENCE_COMPOSITE);
        Parser paragraphParser = new ParagraphParser(sentenceParser);
        //when
        Component actualParagraphComposite = paragraphParser.parse(TEST_PARAGRAPH);
        //then
        Assert.assertEquals(EXPECTED_COMPOSITE, actualParagraphComposite);
    }

}
