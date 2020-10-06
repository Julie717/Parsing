package com.buyalskaya.xmlparsing.parser.impl;

import com.buyalskaya.xmlparsing.entity.Candy;
import com.buyalskaya.xmlparsing.entity.CandyType;
import com.buyalskaya.xmlparsing.entity.candyparameter.CandyParameter;
import com.buyalskaya.xmlparsing.parser.AbstractCandyBuilder;
import com.buyalskaya.xmlparsing.util.FilePathFinder;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class CandyDomBuilder extends AbstractCandyBuilder {
    private static final Logger logger = LogManager.getLogger();
    private DocumentBuilder docBuilder;

    public CandyDomBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.log(Level.ERROR, "Error in configuration of DOM parser");
        }
    }

    @Override
    public void buildSetCandy(String fileName) {
        Document doc;
        String filePath = FilePathFinder.getInstance().findPath(fileName);
        try {
            doc = docBuilder.parse(filePath);
            Element root = doc.getDocumentElement();
            NodeList candyList;
            Element candyElement;
            Candy candy;
            for (CandyType candyType : CandyType.values()) {
                candyList = root.getElementsByTagName(candyType.getCandyType());
                for (int i = 0; i < candyList.getLength(); i++) {
                    candy=candyType.get();
                    candyElement = (Element) candyList.item(i);
                    addCandyParameters(candy, candyElement);
                    candies.add(candy);
                }
            }
        } catch (SAXException ex) {
            logger.log(Level.ERROR, "Error in DOM parser");
        } catch (IOException ex) {
            logger.log(Level.ERROR, "Error in I/О stream");
        }
    }

    private void addCandyParameters(Candy candy, Element candyElement) {
        String attributeValue;
        String attributeName;
        Node element;
        int numberElementValue = 0;
        for (CandyParameter candyParameter : CandyParameter.values()) {
            attributeName = candyParameter.getParameterName();
            if (candyElement.hasAttribute(attributeName)) {
                attributeValue = candyElement.getAttribute(attributeName);
                setAttributeValue(candyParameter, attributeValue, candy);
            } else {
                element = candyElement.getElementsByTagName(attributeName).item(numberElementValue);
                if (element != null) {
                    attributeValue = element.getTextContent();
                    setAttributeValue(candyParameter, attributeValue, candy);
                }
            }
        }
    }

    private void setAttributeValue(CandyParameter candyParameter, String attributeValue, Candy candy) {
        boolean isAddedParameter = candy.setParameter(candyParameter, attributeValue);
        if (!isAddedParameter) {
            logger.log(Level.WARN, "Parameter " + candyParameter.getParameterName() + " isn't added");
        }
    }
}