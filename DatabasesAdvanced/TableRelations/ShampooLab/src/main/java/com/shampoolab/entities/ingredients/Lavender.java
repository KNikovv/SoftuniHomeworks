package com.shampoolab.entities.ingredients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "LA")
public class Lavender extends BasicIngredient {

    private static final BigDecimal PRICE = BigDecimal.valueOf(2);
    private static final String NAME = "Lavender";

    public Lavender() {
        super(NAME, PRICE);
    }
}
