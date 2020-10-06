package com.buyalskaya.xmlparsing.parser;

import com.buyalskaya.xmlparsing.entity.Candy;
import com.buyalskaya.xmlparsing.parser.impl.CandyDomBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.*;

public class CandyDomBuilderTest {
    CandyDomBuilder candyDomBuilder;

    @BeforeClass
    public void setUp() {
        candyDomBuilder = new CandyDomBuilder();
    }


    @Test
    public void buildSetCandyTest() {
        String fileName = "candy.xml";
        candyDomBuilder.buildSetCandy(fileName);
        Set<Candy> actual = candyDomBuilder.getCandies();
        Set<Candy> expected = ResultParsingTest.resultParsing();
        assertEquals(actual, expected);
    }
}