package com.buyalskaya.xmlparsing;

import com.buyalskaya.xmlparsing.entity.Candy;
import com.buyalskaya.xmlparsing.entity.candyparameter.*;
import com.buyalskaya.xmlparsing.entity.impl.Caramel;
import com.buyalskaya.xmlparsing.entity.impl.ChocolateCandy;
import com.buyalskaya.xmlparsing.parser.impl.CandyDomBuilder;
import com.buyalskaya.xmlparsing.parser.impl.CandySaxBuilder;
import com.buyalskaya.xmlparsing.parser.impl.CandyStaxBuilder;
import com.buyalskaya.xmlparsing.util.FilePathFinder;
import com.buyalskaya.xmlparsing.validator.XmlFileValidator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Candy> candies = new HashSet<>();
        CandyEnergyValue candyEnergyValue = new CandyEnergyValue(0, 100, 98000);
        CaramelIngredient caramelIngredient = new CaramelIngredient(50000, 2000, 0, 0, 0, 0);
        Candy candy = new Caramel("N1", "Critters", candyEnergyValue, 390,
                LocalDate.parse("04.05.2020", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                ProductionFactory.KOMMUNARKA, CaramelType.LOLLIPOP, caramelIngredient);
        candies.add(candy);
        candyEnergyValue = new CandyEnergyValue(8000, 40700, 45300);
        ChocolateCandyIngredient chocolateCandyIngredient = new ChocolateCandyIngredient(10000, 0,
                0, 40000, 10000, 20);
        candy = new ChocolateCandy("N2", "Mont Blanc", candyEnergyValue, 580,
                LocalDate.parse("01.09.2020", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                ProductionFactory.ROSHEN, ChocolateType.MILK, FillingType.TOFFEE, chocolateCandyIngredient);
        candies.add(candy);
        candyEnergyValue = new CandyEnergyValue(10000, 37000, 50000);
        chocolateCandyIngredient = new ChocolateCandyIngredient(9000, 2,
                0, 30000, 0, 25);
        candy = new ChocolateCandy("N3", "Candy", candyEnergyValue, 497,
                LocalDate.parse("27.05.2020", DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                ProductionFactory.KOMMUNARKA, ChocolateType.DARK, FillingType.TRUFFLE, chocolateCandyIngredient);
        candies.add(candy);
        String fileName = "candy.xml";
        String schemaname = "candy.xsd";
        XmlFileValidator xmlFileValidator = new XmlFileValidator();
        //  FilePathFinder filePathFinder=new FilePathFinder();
        //   String fileLocation=filePathFinder.findPath(fileName);
        //     String schemaLocation=filePathFinder.findPath(fileName);
        if (xmlFileValidator.isXmlFileValid(fileName, schemaname)) {
            CandySaxBuilder saxBuilder = new CandySaxBuilder();

            saxBuilder.buildSetCandy(fileName);
            saxBuilder.getCandies().stream().forEach(s -> System.out.println(s));
            CandyDomBuilder domBuilder = new CandyDomBuilder();
            domBuilder.buildSetCandy(fileName);
            domBuilder.getCandies().stream().forEach(s -> System.out.println(s));
            CandyStaxBuilder staxBuilder = new CandyStaxBuilder();
            staxBuilder.buildSetCandy(fileName);
            staxBuilder.getCandies().stream().forEach(s -> System.out.println(s));
        }
       /* URL url = getClass().getClassLoader().getResource(fileName);
        if (url == null) {
            throw new TextReaderException("File not exist");
        }
        Paths.get(url.toURI()).toFile()
      //  String logname = "logs/log.txt";
        Schema schema = null;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
// установка проверки с использованием XSD
            schema = factory.newSchema(Paths.get(getClass().getClassLoader().getResource(schemaname).toURI()).toFile());
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
// создание объекта-парсера
            SAXParser parser = spf.newSAXParser();
// установка обработчика ошибок и запуск
            parser.parse(filename, new StudentErrorHandler());
            System.out.println(filename + " is valid");
        } catch (ParserConfigurationException e) {
            System.err.println(filename + " config error: " + e.getMessage());
        } catch (SAXException e) {
            System.err.println(filename + " SAX error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
        }*/
    }
}
