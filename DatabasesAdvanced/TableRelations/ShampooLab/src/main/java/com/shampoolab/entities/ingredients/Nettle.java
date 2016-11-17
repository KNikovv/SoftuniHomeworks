package com.shampoolab.entities.ingredients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "NT")
public class Nettle extends BasicIngredient {

    private static final BigDecimal PRICE = BigDecimal.valueOf(6.12);
    private static final String NAME = "Nettle";

    public Nettle() {
        super(NAME, PRICE);
    }
}
