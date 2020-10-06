package com.buyalskaya.xmlparsing.entity.candyparameter;

import java.util.Optional;
import java.util.stream.Stream;

public enum CandyParameter {
    ID("id"),
    NAME("name"),
    CANDY_ENERGY_VALUE("value"),
    PROTEINS("proteins"),
    FATS("fats"),
    CARBOHYDRATES("carbohydrates"),
    CALORIE("energy"),
    PRODUCTION_DATE("production-date"),
    PRODUCTION_FACTORY("production"),
    CARAMEL_TYPE("type-caramel"),
    CARAMEL_INGREDIENT("caramel-ingredients"),
    CHOCOLATE_CANDY_INGREDIENT("chocolate-candy-ingredients"),
    SUGAR("sugar"),
    VANILLA("vanilla"),
    FRUCTOSE("fructose"),
    MOLASSES("molasses"),
    CONDENSED_MILK("condensed-milk"),
    APPLESAUCE(" applesauce"),
    CHOCOLATE_TYPE("chocolate-type"),
    FILLING_TYPE("filling-type"),
    BUTTER("butter"),
    CREAM("cream"),
    PASTRY_FAT("pastry-fat");

    private String parameterName;

    CandyParameter(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterName() {
        return parameterName;
    }

    public static Optional<CandyParameter> findEnumParameterByString(String value) {
        Optional<CandyParameter> candyParameter = Stream.of(CandyParameter.values())
                .filter(p -> p.getParameterName().equalsIgnoreCase(value)).findAny();
        return candyParameter;
    }
}