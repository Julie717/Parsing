package com.buyalskaya.xmlparsing.entity;

import com.buyalskaya.xmlparsing.entity.candyparameter.CandyEnergyValue;
import com.buyalskaya.xmlparsing.entity.candyparameter.CandyParameter;
import com.buyalskaya.xmlparsing.entity.candyparameter.ProductionFactory;

import java.time.LocalDate;
import java.util.StringJoiner;

public abstract class Candy {
    private String id;
    private String name;
    private CandyEnergyValue candyEnergyValue;
    private int calorie;
    private LocalDate productionDate;
    private ProductionFactory productionFactory;
    private static final String DEFAULT_NAME = "Candy";
    private static final ProductionFactory DEFAULT_PRODUCTION_FACTORY = ProductionFactory.KOMMUNARKA;

    public Candy() {
        name = DEFAULT_NAME;
        productionFactory = DEFAULT_PRODUCTION_FACTORY;
    }

    public Candy(String id, String name, CandyEnergyValue candyEnergyValue,
                 int calorie, LocalDate productionDate, ProductionFactory productionFactory) {
        this.id = id;
        this.name = name;
        this.candyEnergyValue = candyEnergyValue;
        this.calorie = calorie;
        this.productionDate = productionDate;
        this.productionFactory = productionFactory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CandyEnergyValue getCandyEnergyValue() {
        return candyEnergyValue;
    }

    public void setCandyEnergyValue(CandyEnergyValue candyEnergyValue) {
        this.candyEnergyValue = candyEnergyValue;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public LocalDate getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDate productionDate) {
        this.productionDate = productionDate;
    }

    public ProductionFactory getProductionFactory() {
        return productionFactory;
    }

    public void setProductionFactory(ProductionFactory productionFactory) {
        this.productionFactory = productionFactory;
    }

    public abstract boolean setParameter(CandyParameter parameter, String value);

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Candy candy = (Candy) obj;
        if ((id != null && candy.id == null) || (id == null && candy.id != null)) {
            return false;
        }
        if (id != null && candy.id != null && !id.equals(candy.id)) {
            return false;
        }
        if ((name != null && candy.name == null) || (name == null && candy.name != null)) {
            return false;
        }
        if (name != null && candy.name != null && !name.equals(candy.name)) {
            return false;
        }
        if ((candyEnergyValue != null && candy.candyEnergyValue == null) ||
                (candyEnergyValue == null && candy.candyEnergyValue != null)) {
            return false;
        }
        if (candyEnergyValue != null && candy.candyEnergyValue != null &&
                !candyEnergyValue.equals(candy.candyEnergyValue)) {
            return false;
        }
        return calorie == candy.calorie &&
                productionDate.equals(candy.productionDate) &&
                productionFactory == candy.productionFactory;
    }

    @Override
    public int hashCode() {
        return calorie * 31 + id.hashCode() + name.hashCode() + candyEnergyValue.hashCode()
                + productionDate.hashCode() + productionFactory.hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "", "")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("candyEnergyValue=" + candyEnergyValue)
                .add("calorie=" + calorie)
                .add("productionDate=" + productionDate)
                .add("productionFactory=" + productionFactory)
                .toString();
    }
}