package com.buyalskaya.xmlparsing.entity.candyparameter;

import java.util.StringJoiner;

public class ChocolateCandyIngredient {
    private int sugar;
    private int vanilla;
    private int fructose;
    private int butter;
    private int cream;
    private int pastryFat;

    public ChocolateCandyIngredient() {
    }

    public ChocolateCandyIngredient(int sugar, int vanilla, int fructose, int butter, int cream, int pastryFat) {
        this.sugar = sugar;
        this.vanilla = vanilla;
        this.fructose = fructose;
        this.butter = butter;
        this.cream = cream;
        this.pastryFat = pastryFat;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getVanilla() {
        return vanilla;
    }

    public void setVanilla(int vanilla) {
        this.vanilla = vanilla;
    }

    public int getFructose() {
        return fructose;
    }

    public void setFructose(int fructose) {
        this.fructose = fructose;
    }

    public int getButter() {
        return butter;
    }

    public void setButter(int butter) {
        this.butter = butter;
    }

    public int getCream() {
        return cream;
    }

    public void setCream(int cream) {
        this.cream = cream;
    }

    public int getPastryFat() {
        return pastryFat;
    }

    public void setPastryFat(int pastryFat) {
        this.pastryFat = pastryFat;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        ChocolateCandyIngredient chocolateCandyIngredient = (ChocolateCandyIngredient) obj;
        return sugar == chocolateCandyIngredient.sugar &&
                vanilla == chocolateCandyIngredient.vanilla &&
                fructose == chocolateCandyIngredient.fructose &&
                butter == chocolateCandyIngredient.butter &&
                cream == chocolateCandyIngredient.cream &&
                pastryFat == chocolateCandyIngredient.pastryFat;
    }

    @Override
    public int hashCode() {
        return 31 * sugar + vanilla + fructose + butter + cream + pastryFat;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ChocolateCandyIngredient.class.getSimpleName() + "[", "]")
                .add("sugar=" + sugar)
                .add("vanilla=" + vanilla)
                .add("fructose=" + fructose)
                .add("butter=" + butter)
                .add("cream=" + cream)
                .add("pastryFat=" + pastryFat)
                .toString();
    }
}