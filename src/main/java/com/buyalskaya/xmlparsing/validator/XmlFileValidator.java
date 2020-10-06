package com.buyalskaya.xmlparsing.validator;

import com.buyalskaya.xmlparsing.util.FilePathFinder;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlFileValidator {
    private static final Logger logger = LogManager.getLogger();

    public boolean isXmlFileValid(String fileName, String schemaName) {
        boolean isValid = false;
        if (fileName != null && !fileName.isEmpty() && schemaName != null && !schemaName.isEmpty()) {
            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(language);
            String filePath = FilePathFinder.getInstance().findPath(fileName);
            File fileLocation = new File(filePath);
            String schemaPath = FilePathFinder.getInstance().findPath(schemaName);
            File schemaLocation = new File(schemaPath);
            try {
                Schema schema = factory.newSchema(schemaLocation);
                Validator validator = schema.newValidator();
                Source source = new StreamSource(fileLocation);
                validator.validate(source);
                isValid = true;
                logger.log(Level.INFO, "XML file is valid");
            } catch (SAXException ex) {
                logger.log(Level.ERROR, "XML file isn't valid " + ex.getMessage());
            } catch (IOException ex) {
                logger.log(Level.ERROR, "XML file isn't valid " + ex.getMessage());
            }
        }
        return isValid;
    }
}