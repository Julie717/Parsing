package com.buyalskaya.xmlparsing.parser.impl;

import com.buyalskaya.xmlparsing.parser.AbstractCandyBuilder;
import com.buyalskaya.xmlparsing.parser.CandyHandler;
import com.buyalskaya.xmlparsing.util.FilePathFinder;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class CandySaxBuilder extends AbstractCandyBuilder {
    private static final Logger logger = LogManager.getLogger();
    private CandyHandler candyHandler;
    private XMLReader reader;

    public CandySaxBuilder() {
        candyHandler = new CandyHandler();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            reader = parser.getXMLReader();
            reader.setContentHandler(candyHandler);
        } catch (SAXException | ParserConfigurationException ex) {
            logger.log(Level.ERROR, "Error in SAX parser");
        }
    }

    @Override
    public void buildSetCandy(String fileName) {
        String filePath = FilePathFinder.getInstance().findPath(fileName);
        try {
            reader.parse(filePath);
        } catch (SAXException ex) {
            logger.log(Level.ERROR, "Error in SAX parser");
        } catch (IOException ex) {
            logger.log(Level.ERROR, "Error in I/О stream");
        }
        candies = candyHandler.getCandies();
    }
}