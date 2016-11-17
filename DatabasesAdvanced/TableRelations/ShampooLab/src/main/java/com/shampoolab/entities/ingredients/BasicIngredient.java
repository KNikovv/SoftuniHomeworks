package com.shampoolab.entities.ingredients;

import com.shampoolab.entities.shampoos.BasicShampoo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Entity(name = "ingredients")
@Inheritance
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class BasicIngredient implements Ingredient {

    private long id;
    private String name;
    private BigDecimal price;
    private List<BasicShampoo> shampoos;

    protected BasicIngredient() {
        this.setShampoos(new LinkedList<>());
    }

    protected BasicIngredient(String name, BigDecimal price) {
        this();
        this.setName(name);
        this.setPrice(price);
    }

    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    @ManyToMany(mappedBy = "ingredients",targetEntity = BasicShampoo.class)
    public List<BasicShampoo> getShampoos() {
        return shampoos;
    }

    public void setShampoos(List<BasicShampoo> shampoos) {
        this.shampoos = shampoos;
    }
}
