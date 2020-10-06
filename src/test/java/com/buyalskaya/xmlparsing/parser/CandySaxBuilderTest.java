package com.buyalskaya.xmlparsing.parser;

import com.buyalskaya.xmlparsing.entity.Candy;
import com.buyalskaya.xmlparsing.parser.impl.CandySaxBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class CandySaxBuilderTest {
    CandySaxBuilder candySaxBuilder;

    @BeforeClass
    public void setUp() {
        candySaxBuilder = new CandySaxBuilder();
    }


    @Test
    public void buildSetCandyTest() {
        String fileName = "candy.xml";
        candySaxBuilder.buildSetCandy(fileName);
        Set<Candy> actual = candySaxBuilder.getCandies();
        Set<Candy> expected = ResultParsingTest.resultParsing();
        assertEquals(actual, expected);
    }
}