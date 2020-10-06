package com.buyalskaya.xmlparsing.entity.candyparameter;

import java.util.StringJoiner;

public class CaramelIngredient {
    private int sugar;
    private int vanilla;
    private int fructose;
    private int molasses;
    private int condensedMilk;
    private int applesauce;

    public CaramelIngredient() {
    }

    public CaramelIngredient(int sugar, int vanilla, int fructose, int molasses, int condensedMilk, int applesauce) {
        this.sugar = sugar;
        this.vanilla = vanilla;
        this.fructose = fructose;
        this.molasses = molasses;
        this.condensedMilk = condensedMilk;
        this.applesauce = applesauce;
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

    public int getMolasses() {
        return molasses;
    }

    public void setMolasses(int molasses) {
        this.molasses = molasses;
    }

    public int getCondensedMilk() {
        return condensedMilk;
    }

    public void setCondensedMilk(int condensedMilk) {
        this.condensedMilk = condensedMilk;
    }

    public int getApplesauce() {
        return applesauce;
    }

    public void setApplesauce(int applesauce) {
        this.applesauce = applesauce;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        CaramelIngredient caramelIngredient = (CaramelIngredient) obj;
        return sugar == caramelIngredient.sugar &&
                vanilla == caramelIngredient.vanilla &&
                fructose == caramelIngredient.fructose &&
                molasses == caramelIngredient.molasses &&
                condensedMilk == caramelIngredient.condensedMilk &&
                applesauce == caramelIngredient.applesauce;
    }

    @Override
    public int hashCode() {
        return 31 * sugar + vanilla + fructose + molasses + condensedMilk + applesauce;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CaramelIngredient.class.getSimpleName() + "[", "]")
                .add("sugar=" + sugar)
                .add("vanilla=" + vanilla)
                .add("fructose=" + fructose)
                .add("molasses=" + molasses)
                .add("condensedMilk=" + condensedMilk)
                .add("applesauce=" + applesauce)
                .toString();
    }
}