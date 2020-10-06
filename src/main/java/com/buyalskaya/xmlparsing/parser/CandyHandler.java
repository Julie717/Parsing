package com.buyalskaya.xmlparsing.parser;

import com.buyalskaya.xmlparsing.entity.Candy;
import com.buyalskaya.xmlparsing.entity.CandyType;
import com.buyalskaya.xmlparsing.entity.candyparameter.CandyParameter;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.*;

public class CandyHandler extends DefaultHandler {
    private static final Logger logger = LogManager.getLogger();
    private Set<Candy> candies;
    private Candy current;
    private CandyParameter currentParameter;

    public CandyHandler() {
        candies = new HashSet<>();
    }

    public Set<Candy> getCandies() {
        return candies;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (qName != null && !qName.isEmpty()) {
            Optional<CandyType> candyType = CandyType.findEnumParameterByString(qName);
            String attributeName;
            if (candyType.isPresent()) {
                current = candyType.get().get();
                Optional<CandyParameter> candyParameter;
                for (int i = 0; i < attributes.getLength(); i++) {
                    attributeName = attributes.getQName(i);
                    candyParameter = CandyParameter.findEnumParameterByString(attributeName);
                    if (candyParameter.isPresent()) {
                        setAttributeValue(candyParameter.get(), attributes.getValue(i), current);
                    }
                }
            } else {
                currentParameter = CandyParameter.findEnumParameterByString(qName).orElse(null);
            }
        }
    }

    public void endElement(String uri, String localName, String qName) {
        boolean isEndTagCandy = Arrays.stream(CandyType.values())
                .anyMatch(c -> c.getCandyType().equalsIgnoreCase(qName));
        if (isEndTagCandy) {
            candies.add(current);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length).trim();
        if (currentParameter != null) {
            setAttributeValue(currentParameter, value, current);
            currentParameter = null;
        }
    }

    private void setAttributeValue(CandyParameter candyParameter, String attributeValue, Candy candy) {
        boolean isAddedParameter = candy.setParameter(candyParameter, attributeValue);
        if (!isAddedParameter) {
            logger.log(Level.WARN, "Parameter " + candyParameter.getParameterName() + " isn't added");
        }
    }
}