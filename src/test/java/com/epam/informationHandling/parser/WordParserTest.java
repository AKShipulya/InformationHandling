package com.epam.informationHandling.parser;

import com.epam.informationHandling.entity.Component;
import com.epam.informationHandling.entity.Composite;
import com.epam.informationHandling.parser.impl.WordParser;
import org.junit.Assert;
import org.junit.Test;

public class WordParserTest {

    @Test
    public void testParserShouldReturnParagraphsFromText() {
        // TODO: 14.01.2022
        //given
        String text = "Word1 word2 word3";
        Parser parser = new WordParser();
        Component composite = new Composite();
        Component expected = composite.add();
        //when
        Component actual = parser.parse(text);
        //then
        Assert.assertEquals(expected, actual);
    }

}
