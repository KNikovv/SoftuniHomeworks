package com.shampoolab.entities.shampoos;


import com.shampoolab.entities.batches.ProductionBatch;
import com.shampoolab.entities.labels.ClassicLabel;
import com.shampoolab.enums.Size;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "FS")
public class FiftyShades extends BasicShampoo {

    private static final String BRAND = "Fifty Shades";

    private static final BigDecimal PRICE = BigDecimal.valueOf(6.69);

    private static final Size SIZE = Size.SMALL;



    public FiftyShades(ClassicLabel label, ProductionBatch batch) {
        super(BRAND, PRICE, SIZE, label, batch);
    }
}
