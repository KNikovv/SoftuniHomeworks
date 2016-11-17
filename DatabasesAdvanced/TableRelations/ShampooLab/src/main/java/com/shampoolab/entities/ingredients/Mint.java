package com.shampoolab.entities.ingredients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "MI")
public class Mint extends BasicIngredient {

    private static final BigDecimal PRICE = BigDecimal.valueOf(3.54);
    private static final String NAME = "Mint";

    public Mint() {
        super(NAME, PRICE);
    }
}
