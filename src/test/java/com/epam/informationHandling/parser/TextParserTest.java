package com.epam.informationHandling.parser;

import com.epam.informationHandling.entity.Component;
import com.epam.informationHandling.entity.Composite;
import com.epam.informationHandling.entity.Lexeme;
import com.epam.informationHandling.exception.TextException;
import com.epam.informationHandling.parser.impl.ParagraphParser;
import com.epam.informationHandling.parser.impl.TextParser;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

public class TextParserTest {
    private static final String FIRST_PARAGRAPH = "Lorem ipsum dolor sit amet.";
    private static final String SECOND_PARAGRAPH = "At vero eos et accusam!";
    private static final String THIRD_PARAGRAPH = "Stet clita kasd gubergren?";
    private static final String FOURTH_PARAGRAPH = "Lorem ipsum...";

    private static final Component FIRST_SENTENCE_COMPOSITE =
            new Composite(Arrays.asList(Lexeme.word("Lorem"), Lexeme.word("ipsum"), Lexeme.word("dolor"), Lexeme.word("sit"), Lexeme.word("amet.")));
    private static final Component SECOND_SENTENCE_COMPOSITE =
            new Composite(Arrays.asList(Lexeme.word("At"), Lexeme.word("vero"), Lexeme.word("eos"), Lexeme.word("et"), Lexeme.word("accusam!")));
    private static final Component THIRD_SENTENCE_COMPOSITE =
            new Composite(Arrays.asList(Lexeme.word("Stet"), Lexeme.word("clita"), Lexeme.word("kasd"), Lexeme.word("gubergren?")));
    private static final Component FOURTH_SENTENCE_COMPOSITE =
            new Composite(Arrays.asList(Lexeme.word("Lorem"), Lexeme.word("ipsum...")));

    private static final Component FIRST_PARAGRAPH_COMPOSITE = new Composite(Arrays.asList(FIRST_SENTENCE_COMPOSITE, SECOND_SENTENCE_COMPOSITE));
    private static final Component SECOND_PARAGRAPH_COMPOSITE = new Composite(Collections.singletonList(THIRD_SENTENCE_COMPOSITE));
    private static final Component THIRD_PARAGRAPH_COMPOSITE = new Composite(Collections.singletonList(FOURTH_SENTENCE_COMPOSITE));
    private static final Component FOURTH_PARAGRAPH_COMPOSITE = new Composite(Collections.singletonList(FOURTH_SENTENCE_COMPOSITE));

    private static final String TEST_TEXT = FIRST_PARAGRAPH + "\n" + SECOND_PARAGRAPH + "\n" + THIRD_PARAGRAPH + "\n" + FOURTH_PARAGRAPH;

    private static final Component EXPECTED_COMPOSITE =
            new Composite(Arrays.asList(FIRST_PARAGRAPH_COMPOSITE, SECOND_PARAGRAPH_COMPOSITE, THIRD_PARAGRAPH_COMPOSITE, FOURTH_PARAGRAPH_COMPOSITE));

    @Test
    public void testParseShouldParseTextWithParagraphs() throws TextException {
        //given
        ParagraphParser paragraphParser = Mockito.mock(ParagraphParser.class);
        Mockito.when(paragraphParser.parse(FIRST_PARAGRAPH)).thenReturn(FIRST_PARAGRAPH_COMPOSITE);
        Mockito.when(paragraphParser.parse(SECOND_PARAGRAPH)).thenReturn(SECOND_PARAGRAPH_COMPOSITE);
        Mockito.when(paragraphParser.parse(THIRD_PARAGRAPH)).thenReturn(THIRD_PARAGRAPH_COMPOSITE);
        Mockito.when(paragraphParser.parse(FOURTH_PARAGRAPH)).thenReturn(FOURTH_PARAGRAPH_COMPOSITE);
        TextParser textParser = new TextParser(paragraphParser);
        //when
        Component actualTextComposite = textParser.parse(TEST_TEXT);
        //then
        Assert.assertEquals(EXPECTED_COMPOSITE, actualTextComposite);
    }
}
