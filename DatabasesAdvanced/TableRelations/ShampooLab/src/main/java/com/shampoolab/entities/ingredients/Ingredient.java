package com.shampoolab.entities.ingredients;

import com.shampoolab.entities.shampoos.BasicShampoo;

import java.math.BigDecimal;
import java.util.List;

public interface Ingredient {

    long getId();

    void setId(long id);

    String getName();

    void setName(String name);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    List<BasicShampoo> getShampoos();

    void setShampoos(List<BasicShampoo> shampoos);

}
