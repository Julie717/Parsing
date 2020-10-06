package com.buyalskaya.xmlparsing.parser;

import com.buyalskaya.xmlparsing.entity.Candy;
import com.buyalskaya.xmlparsing.parser.impl.CandyStaxBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;

public class CandyStaxBuilderTest {
    CandyStaxBuilder candyStaxBuilder;

    @BeforeClass
    public void setUp() {
        candyStaxBuilder = new CandyStaxBuilder();
    }


    @Test
    public void buildSetCandyTest() {
        String fileName = "candy.xml";
        candyStaxBuilder.buildSetCandy(fileName);
        Set<Candy> actual = candyStaxBuilder.getCandies();
        Set<Candy> expected = ResultParsingTest.resultParsing();
        assertEquals(actual, expected);
    }
}