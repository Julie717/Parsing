package com.buyalskaya.xmlparsing.parser.impl;

import com.buyalskaya.xmlparsing.entity.Candy;
import com.buyalskaya.xmlparsing.entity.CandyType;
import com.buyalskaya.xmlparsing.entity.candyparameter.CandyParameter;
import com.buyalskaya.xmlparsing.parser.AbstractCandyBuilder;
import com.buyalskaya.xmlparsing.util.FilePathFinder;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

public class CandyStaxBuilder extends AbstractCandyBuilder {
    private static final Logger logger = LogManager.getLogger();
    private XMLInputFactory inputFactory;

    public CandyStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    public CandyStaxBuilder(Set<Candy> candies) {
        super(candies);
    }

    @Override
    public void buildSetCandy(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader;
        String name;
        String filePath = FilePathFinder.getInstance().findPath(fileName);
        try {
            inputStream = new FileInputStream(new File(filePath));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    Optional<CandyType> candyType = CandyType.findEnumParameterByString(name);
                    if (candyType.isPresent()) {
                        Candy candy=candyType.get().get();
                        candy = addCandyParameters(candy, reader);
                        candies.add(candy);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            logger.log(Level.ERROR, "Error in StAX parser");
        } catch (FileNotFoundException ex) {
            logger.log(Level.ERROR, "File " + fileName + " not found");
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                logger.log(Level.WARN, "File " + fileName + " not closed");
            }
        }
    }

    private Candy addCandyParameters(Candy candy, XMLStreamReader reader) throws XMLStreamException {
        String attributeName;
        String attributeValue;
        for (int i = 0; i < reader.getAttributeCount(); i++) {
            attributeName = reader.getAttributeLocalName(i);
            attributeValue = reader.getAttributeValue(i);
            setAttributeValue(attributeName, attributeValue, candy);
        }
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    attributeName = reader.getLocalName();
                    attributeValue = getXMLText(reader);
                    setAttributeValue(attributeName, attributeValue, candy);
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    attributeName = reader.getLocalName();
                    if (CandyType.findEnumParameterByString(attributeName).isPresent()) {
                        return candy;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag Candy");
    }

    private void setAttributeValue(String attributeName, String attributeValue, Candy candy) {
        Optional<CandyParameter> candyParameter = CandyParameter.findEnumParameterByString(attributeName);
        if (candyParameter.isPresent()) {
            boolean isAddedParameter = candy.setParameter(candyParameter.get(), attributeValue);
            if (!isAddedParameter) {
                logger.log(Level.WARN, "Parameter " + attributeName + " isn't added");
            }
        }
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            if(reader.hasText()){
                text = reader.getText();
            }
        }
        return text;
    }
}