package com.epam.informationHandling.parser;

import com.epam.informationHandling.entity.Component;
import com.epam.informationHandling.entity.Composite;
import com.epam.informationHandling.parser.impl.ParagraphParser;
import org.junit.Assert;
import org.junit.Test;

public class ParagraphParserTest {
    // TODO: 14.01.2022
    @Test
    public void testParserShouldReturnParagraphsFromText() {
        //given
        String text = "Paragraph1.\nParagraph2.";
        Parser parser = new ParagraphParser(null);
        Component composite = new Composite();
        Component expected = composite.add();
        //when
        Component actual = parser.parse(text);
        //then
        Assert.assertEquals(expected, actual);
    }
}
