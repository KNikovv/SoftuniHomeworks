package com.shampoolab.entities.shampoos;

import com.shampoolab.entities.batches.ProductionBatch;
import com.shampoolab.entities.labels.ClassicLabel;
import com.shampoolab.enums.Size;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "FN")
public class FreshNuke extends BasicShampoo {

    private static final String BRAND = "Fresh Nuke";

    private static final BigDecimal PRICE = BigDecimal.valueOf(9.33);

    private static final Size SIZE = Size.LARGE;



    public FreshNuke(ClassicLabel label, ProductionBatch batch) {
        super(BRAND, PRICE, SIZE, label, batch);
    }
}
