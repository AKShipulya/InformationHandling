package com.epam.informationhandling.service;

import com.epam.informationhandling.entity.Component;
import com.epam.informationhandling.entity.Composite;
import com.epam.informationhandling.entity.Lexeme;
import com.epam.informationhandling.exception.TextException;
import com.epam.informationhandling.service.impl.InformationServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class InformationServiceImplTest {

    private static final InformationService SERVICE = new InformationServiceImpl();
    //sentences for paragraphs
    private static final Component FIRST_SENTENCE_COMPOSITE =
            new Composite(Arrays.asList(Lexeme.word("Lorem"), Lexeme.word("ipsum"), Lexeme.word("dolor"), Lexeme.word("sit"), Lexeme.word("amet.")));
    private static final Component SECOND_SENTENCE_COMPOSITE =
            new Composite(Arrays.asList(Lexeme.word("At"), Lexeme.word("vero"), Lexeme.word("eos"), Lexeme.word("et")));
    private static final Component THIRD_SENTENCE_COMPOSITE =
            new Composite(Arrays.asList(Lexeme.word("Stet"), Lexeme.word("clita"), Lexeme.word("kasd")));
    private static final Component FOURTH_SENTENCE_COMPOSITE =
            new Composite(Arrays.asList(Lexeme.word("Lorem"), Lexeme.word("ipsum...")));
    //paragraphs
    private static final Component FIRST_PARAGRAPH_COMPOSITE =
            new Composite(Arrays.asList(FIRST_SENTENCE_COMPOSITE, SECOND_SENTENCE_COMPOSITE, THIRD_SENTENCE_COMPOSITE, FOURTH_SENTENCE_COMPOSITE));
    private static final Component SECOND_PARAGRAPH_COMPOSITE =
            new Composite(Arrays.asList(FIRST_SENTENCE_COMPOSITE, SECOND_SENTENCE_COMPOSITE, THIRD_SENTENCE_COMPOSITE));
    private static final Component THIRD_PARAGRAPH_COMPOSITE = new Composite(Arrays.asList(FIRST_SENTENCE_COMPOSITE, SECOND_SENTENCE_COMPOSITE));
    private static final Component FOURTH_PARAGRAPH_COMPOSITE = new Composite(Arrays.asList(FIRST_SENTENCE_COMPOSITE));

    @Test
    public void testSortBySentencesQuantityShouldSortSentences() throws TextException {
        //given
        Component testText =
                new Composite(Arrays.asList(FIRST_PARAGRAPH_COMPOSITE, SECOND_PARAGRAPH_COMPOSITE, THIRD_PARAGRAPH_COMPOSITE, FOURTH_PARAGRAPH_COMPOSITE));
        List<Component> expectedText =
                Arrays.asList(FOURTH_PARAGRAPH_COMPOSITE, THIRD_PARAGRAPH_COMPOSITE, SECOND_PARAGRAPH_COMPOSITE, FIRST_PARAGRAPH_COMPOSITE);
        //when
        List<Component> actual = SERVICE.sortBySentencesQuantity(testText);
        //then
        Assert.assertEquals(expectedText, actual);
    }

    @Test
    public void testSortWordsInSentenceByLongShouldSortWords() throws TextException {
        //given
        Component testSentence = new Composite(Arrays.asList(Lexeme.word("At"), Lexeme.word("vero"), Lexeme.word("eos")));
        List<Component> expectedSentence = Arrays.asList(Lexeme.word("At"), Lexeme.word("eos"), Lexeme.word("vero"));
        //when
        List<Component> actual = SERVICE.sortWordsInSentenceByLong(testSentence);
        //then
        Assert.assertEquals(expectedSentence, actual);
    }

    @Test
    public void testRestoreTextFromComponentShouldReturnRestoredText() throws TextException {
        //given
        Component testText = new Composite(Arrays.asList(Lexeme.word("Lorem"), Lexeme.word("ipsum"), Lexeme.word("dolor"), Lexeme.word("sit")));
        String expected = "Lorem ipsum dolor sit";
        //when
        String actual = SERVICE.restoreTextFromComponent(testText);
        //then
        Assert.assertEquals(expected, actual);
    }
}
