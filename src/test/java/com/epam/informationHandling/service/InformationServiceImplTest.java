package com.epam.informationHandling.service;

import com.epam.informationHandling.entity.Component;
import com.epam.informationHandling.entity.Composite;
import com.epam.informationHandling.entity.Lexeme;
import com.epam.informationHandling.service.impl.InformationServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InformationServiceImplTest {

    private static final Composite FIRST_SENTENCE_COMPOSITE =
            new Composite(Arrays.asList(Lexeme.word("Lorem"), Lexeme.word("ipsum"), Lexeme.word("dolor"), Lexeme.word("sit"), Lexeme.word("amet.")));
    private static final Composite SECOND_SENTENCE_COMPOSITE =
            new Composite(Arrays.asList(Lexeme.word("At"), Lexeme.word("vero"), Lexeme.word("eos"), Lexeme.word("et"), Lexeme.word("accusam!")));
    private static final Composite THIRD_SENTENCE_COMPOSITE =
            new Composite(Arrays.asList(Lexeme.word("Stet"), Lexeme.word("clita"), Lexeme.word("kasd"), Lexeme.word("gubergren?")));
    private static final Composite FOURTH_SENTENCE_COMPOSITE =
            new Composite(Arrays.asList(Lexeme.word("Lorem"), Lexeme.word("ipsum...")));

    private static final Composite FIRST_PARAGRAPH_COMPOSITE = new Composite(Arrays.asList(FIRST_SENTENCE_COMPOSITE, SECOND_SENTENCE_COMPOSITE));
    private static final Composite SECOND_PARAGRAPH_COMPOSITE = new Composite(Collections.singletonList(THIRD_SENTENCE_COMPOSITE));
    private static final Composite THIRD_PARAGRAPH_COMPOSITE = new Composite(Collections.singletonList(FOURTH_SENTENCE_COMPOSITE));
    private static final Composite FOURTH_PARAGRAPH_COMPOSITE = new Composite(Collections.singletonList(FOURTH_SENTENCE_COMPOSITE));

    private static final Composite TEST_TEXT =
            new Composite(Arrays.asList(FIRST_PARAGRAPH_COMPOSITE, SECOND_PARAGRAPH_COMPOSITE, THIRD_PARAGRAPH_COMPOSITE, FOURTH_PARAGRAPH_COMPOSITE));
    private static final List<Component> EXPECTED = TEST_TEXT.getComponents();

    @Test
    public void testSortBySentencesQuantityShouldSortSentences() {
        //given
        InformationService service = new InformationServiceImpl();
        //when
        List<Component> actual = service.sortBySentencesQuantity(TEST_TEXT);
        //then
        Assert.assertEquals(EXPECTED, actual);
    }

    @Test
    public void testSortWordsInSentenceByLongShouldSortWords() {
        //given

        //when

        //then
    }
}
