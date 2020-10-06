package com.buyalskaya.xmlparsing.entity.candyparameter;

import java.util.StringJoiner;

public class CandyEnergyValue {
    private int proteins;
    private int fats;
    private int carbohydrates;

    public CandyEnergyValue() {
    }

    public CandyEnergyValue(int proteins, int fats, int carbohydrates) {
        this.proteins = proteins;
        this.fats = fats;
        this.carbohydrates = carbohydrates;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        CandyEnergyValue candyEnergyValue = (CandyEnergyValue) obj;
        return proteins == candyEnergyValue.proteins &&
                fats == candyEnergyValue.fats &&
                carbohydrates == candyEnergyValue.carbohydrates;
    }

    @Override
    public int hashCode() {
        return proteins * 31 + fats + carbohydrates;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CandyEnergyValue.class.getSimpleName() + "[", "]")
                .add("proteins=" + proteins)
                .add("fats=" + fats)
                .add("carbohydrates=" + carbohydrates)
                .toString();
    }
}