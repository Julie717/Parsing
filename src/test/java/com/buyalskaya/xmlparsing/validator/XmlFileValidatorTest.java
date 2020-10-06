package com.buyalskaya.xmlparsing.validator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class XmlFileValidatorTest {
    XmlFileValidator validator;

    @BeforeClass
    public void setUp() {
        validator = new XmlFileValidator();
    }

    @DataProvider(name = "dataForIsXmlFileValid")
    public Object[][] dataForIsIdValid() {
        return new Object[][]{
                {"candy.xml", "candy.xsd", true},
                {"IncorrectTest.xml", "candy.xsd", false},
                {"", "candy.xsd", false},
                {"candyChocolate.xml", "candy.xsd", false},
                {"candy.xml", null, false}
        };
    }

    @Test(dataProvider = "dataForIsXmlFileValid")
    public void isXmlFileValidTest(String fileName, String schemaName, boolean expected) {
        boolean actual = validator.isXmlFileValid(fileName, schemaName);
        assertEquals(actual, expected);
    }
}