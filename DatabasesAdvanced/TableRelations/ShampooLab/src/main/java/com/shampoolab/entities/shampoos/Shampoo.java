package com.shampoolab.entities.shampoos;

import com.shampoolab.entities.batches.ProductionBatch;
import com.shampoolab.entities.ingredients.BasicIngredient;
import com.shampoolab.entities.labels.ClassicLabel;
import com.shampoolab.enums.Size;

import java.math.BigDecimal;
import java.util.Set;

public interface Shampoo  {

    long getId();

    void setId(long id);

    String getBrand();

    void setBrand(String brand);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    Size getSize();

    void setSize(Size size);

    ClassicLabel getLabel();

    void setLabel(ClassicLabel label);

    ProductionBatch getBatch();

    void setBatch(ProductionBatch batch);

    Set<BasicIngredient> getIngredients();

    void setIngredients(Set<BasicIngredient> ingredients);

}
