package com.buyalskaya.xmlparsing.entity.candyparameter;

import java.util.Optional;
import java.util.stream.Stream;

public enum CaramelType {
    LOLLIPOP("Lollipop"),
    JELLY_BEANS("Jelly beans"),
    STUFFED_CARAMEL("Stuffed caramel");

    private String caramelTypeName;

    CaramelType(String caramelTypeName) {
        this.caramelTypeName = caramelTypeName;
    }

    public String getCaramelTypeName() {
        return caramelTypeName;
    }
    public static Optional<CaramelType> findEnumParameterByString(String value) {
        Optional<CaramelType> caramelType = Stream.of(CaramelType.values())
                .filter(p -> p.getCaramelTypeName().equalsIgnoreCase(value)).findAny();
        return caramelType;
    }
}