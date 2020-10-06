package com.buyalskaya.xmlparsing.entity;

import com.buyalskaya.xmlparsing.entity.impl.Caramel;
import com.buyalskaya.xmlparsing.entity.impl.ChocolateCandy;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public enum CandyType implements Supplier<Candy> {
    CARAMEL("caramel") {
        @Override
        public Candy get() {
            return new Caramel();
        }
    },
    CHOCOLATE_CANDY("chocolate-candy") {
        @Override
        public Candy get() {
            return new ChocolateCandy();
        }
    };

    private String candyType;

    CandyType(String candyType) {
        this.candyType = candyType;
    }

    public String getCandyType() {
        return candyType;
    }

    public static Optional<CandyType> findEnumParameterByString(String value) {
        Optional<CandyType> candyType = Stream.of(CandyType.values())
                .filter(p -> p.getCandyType().equalsIgnoreCase(value)).findAny();
        return candyType;
    }
}