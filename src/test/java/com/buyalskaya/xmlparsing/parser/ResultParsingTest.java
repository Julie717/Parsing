package com.buyalskaya.xmlparsing.parser;

import com.buyalskaya.xmlparsing.entity.Candy;
import com.buyalskaya.xmlparsing.entity.candyparameter.*;
import com.buyalskaya.xmlparsing.entity.impl.Caramel;
import com.buyalskaya.xmlparsing.entity.impl.ChocolateCandy;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class ResultParsingTest {
    public static Set<Candy> resultParsing() {
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
        return candies;
    }
}
