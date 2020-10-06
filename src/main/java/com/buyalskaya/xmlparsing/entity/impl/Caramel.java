package com.buyalskaya.xmlparsing.entity.impl;

import com.buyalskaya.xmlparsing.entity.*;
import com.buyalskaya.xmlparsing.entity.candyparameter.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.StringJoiner;

public class Caramel extends Candy {
    private CaramelType caramelType;
    private CaramelIngredient caramelIngredient;

    public Caramel() {
    }

    public Caramel(String id, String name, CandyEnergyValue candyEnergyValue,
                   int calorie, LocalDate productionDate, ProductionFactory productionFactory,
                   CaramelType caramelType, CaramelIngredient caramelIngredient) {
        super(id, name, candyEnergyValue, calorie, productionDate, productionFactory);
        this.caramelType = caramelType;
        this.caramelIngredient = caramelIngredient;
    }

    public CaramelType getCaramelType() {
        return caramelType;
    }

    public void setCaramelType(CaramelType caramelType) {
        this.caramelType = caramelType;
    }

    public CaramelIngredient getCaramelIngredient() {
        return caramelIngredient;
    }

    public void setCaramelIngredient(CaramelIngredient caramelIngredient) {
        this.caramelIngredient = caramelIngredient;
    }

    public boolean setParameter(CandyParameter parameter, String value) {
        if (parameter == null ) {
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
            case CARAMEL_TYPE:
                Optional<CaramelType> caramelType = CaramelType.findEnumParameterByString(value.toUpperCase());
                if (caramelType.isPresent()) {
                    setCaramelType(caramelType.get());
                } else {
                    result = false;
                }
                break;
            case CARAMEL_INGREDIENT:
                setCaramelIngredient(new CaramelIngredient());
                break;
            case SUGAR:
                getCaramelIngredient().setSugar(Integer.parseInt(value));
                break;
            case VANILLA:
                getCaramelIngredient().setVanilla(Integer.parseInt(value));
                break;
            case FRUCTOSE:
                getCaramelIngredient().setFructose(Integer.parseInt(value));
                break;
            case MOLASSES:
                getCaramelIngredient().setMolasses(Integer.parseInt(value));
                break;
            case CONDENSED_MILK:
                getCaramelIngredient().setCondensedMilk(Integer.parseInt(value));
                break;
            case APPLESAUCE:
                getCaramelIngredient().setApplesauce(Integer.parseInt(value));
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
        Caramel caramel = (Caramel) obj;
        return caramelType == caramel.caramelType &&
                caramelIngredient.equals(caramel.caramelIngredient);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 7 * caramelType.hashCode() + caramelIngredient.hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Caramel.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("caramelType=" + caramelType)
                .add("caramelIngredient=" + caramelIngredient)
                .toString();
    }
}