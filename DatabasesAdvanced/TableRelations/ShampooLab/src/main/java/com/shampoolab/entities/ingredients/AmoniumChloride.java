package com.shampoolab.entities.ingredients;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "AC")
public class AmoniumChloride extends BasicChemicalIngredient {

    private static final BigDecimal PRICE = BigDecimal.valueOf(0.59);
    private static final String NAME = "Amonium Chloride";
    private static final String FORMULA = "NH4CL";


    public AmoniumChloride() {
        super(NAME, PRICE, FORMULA);
    }
}
