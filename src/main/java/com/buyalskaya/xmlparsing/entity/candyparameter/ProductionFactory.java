package com.buyalskaya.xmlparsing.entity.candyparameter;

import java.util.Optional;
import java.util.stream.Stream;

public enum ProductionFactory {
    KOMMUNARKA("Kommunarka"),
    SPARTAK("Spartak"),
    ROSHEN("Roshen");
    private String factoryName;

    ProductionFactory(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public static Optional<ProductionFactory> findEnumParameterByString(String value) {
        Optional<ProductionFactory> productionFactory = Stream.of(ProductionFactory.values())
                .filter(p -> p.getFactoryName().equalsIgnoreCase(value)).findAny();
        return productionFactory;
    }
}