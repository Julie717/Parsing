package com.buyalskaya.xmlparsing.entity.impl;

import com.buyalskaya.xmlparsing.entity.*;
import com.buyalskaya.xmlparsing.entity.candyparameter.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.StringJoiner;

public class ChocolateCandy extends Candy {
    private ChocolateType chocolateType;
    private FillingType fillingType;
    private ChocolateCandyIngredient chocolateCandyIngredient;

    public ChocolateCandy() {
    }

    public ChocolateCandy(String id, String name, CandyEnergyValue candyEnergyValue,
                          int calorie, LocalDate productionDate, ProductionFactory productionFactory,
                          ChocolateType chocolateType, FillingType fillingType,
                          ChocolateCandyIngredient chocolateCandyIngredient) {
        super(id, name, candyEnergyValue, calorie, productionDate, productionFactory);
        this.chocolateType = chocolateType;
        this.fillingType = fillingType;
        this.chocolateCandyIngredient = chocolateCandyIngredient;
    }

    public ChocolateType getChocolateType() {
        return chocolateType;
    }

    public void setChocolateType(ChocolateType chocolateType) {
        this.chocolateType = chocolateType;
    }

    public FillingType getFillingType() {
        return fillingType;
    }

    public void setFillingType(FillingType fillingType) {
        this.fillingType = fillingType;
    }

    public ChocolateCandyIngredient getChocolateCandyIngredient() {
        return chocolateCandyIngredient;
    }

    public void setChocolateCandyIngredient(ChocolateCandyIngredient chocolateCandyIngredient) {
        this.chocolateCandyIngredient = chocolateCandyIngredient;
    }

    public boolean setParameter(CandyParameter parameter, String value) {
        if (parameter == null) {
            return false;
        }
        boolean result = true;
        switch (parameter) {
            case ID:
                setId(value);
                break;
            case NAME:
                setName(value);
                break;
            case CANDY_ENERGY_VALUE:
                setCandyEnergyValue(new CandyEnergyValue());
                break;
            case PROTEINS:
                getCandyEnergyValue().setProteins(Integer.parseInt(value));
                break;
            case FATS:
                getCandyEnergyValue().setFats(Integer.parseInt(value));
                break;
            case CARBOHYDRATES:
                getCandyEnergyValue().setCarbohydrates(Integer.parseInt(value));
                break;
            case CALORIE:
                setCalorie(Integer.parseInt(value));
                break;
            case PRODUCTION_DATE:
                setProductionDate(LocalDate.parse(value));
                break;
            case PRODUCTION_FACTORY:
                Optional<ProductionFactory> productionFactory = ProductionFactory.findEnumParameterByString(value);
                if (productionFactory.isPresent()) {
                    setProductionFactory(productionFactory.get());
                }
                break;
            case CHOCOLATE_TYPE:
                setChocolateType(ChocolateType.valueOf(value.toUpperCase()));
                break;
            case FILLING_TYPE:
                setFillingType(FillingType.valueOf(value.toUpperCase()));
                break;
            case CHOCOLATE_CANDY_INGREDIENT:
                setChocolateCandyIngredient(new ChocolateCandyIngredient());
                break;
            case SUGAR:
                getChocolateCandyIngredient().setSugar(Integer.parseInt(value));
                break;
            case VANILLA:
                getChocolateCandyIngredient().setVanilla(Integer.parseInt(value));
                break;
            case FRUCTOSE:
                getChocolateCandyIngredient().setFructose(Integer.parseInt(value));
                break;
            case BUTTER:
                getChocolateCandyIngredient().setButter(Integer.parseInt(value));
                break;
            case CREAM:
                getChocolateCandyIngredient().setCream(Integer.parseInt(value));
                break;
            case PASTRY_FAT:
                getChocolateCandyIngredient().setPastryFat(Integer.parseInt(value));
                break;
            default:
                result = false;
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        ChocolateCandy chocolateCandy = (ChocolateCandy) obj;
        return chocolateType == chocolateCandy.chocolateType &&
                fillingType == chocolateCandy.fillingType &&
                chocolateCandyIngredient.equals(chocolateCandy.chocolateCandyIngredient);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + chocolateType.hashCode() * 7 + fillingType.hashCode() +
                chocolateCandyIngredient.hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ChocolateCandy.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("chocolateType=" + chocolateType)
                .add("fillingType=" + fillingType)
                .add("chocolateCandyIngredient=" + chocolateCandyIngredient)
                .toString();
    }
}