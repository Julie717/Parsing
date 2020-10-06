package com.buyalskaya.xmlparsing.parser;

import com.buyalskaya.xmlparsing.entity.Candy;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractCandyBuilder {
    protected Set<Candy> candies;
    public AbstractCandyBuilder() {
        candies = new HashSet<>();
    }
    public AbstractCandyBuilder(Set<Candy> candies) {
        this.candies = candies;
    }
    public Set<Candy> getCandies() {
        return candies;
    }
    abstract public void buildSetCandy(String fileName);
}