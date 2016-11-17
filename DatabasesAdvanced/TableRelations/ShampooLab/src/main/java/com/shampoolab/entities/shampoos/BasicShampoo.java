package com.shampoolab.entities.shampoos;

import com.shampoolab.entities.batches.ProductionBatch;
import com.shampoolab.entities.ingredients.BasicIngredient;
import com.shampoolab.entities.labels.ClassicLabel;
import com.shampoolab.enums.Size;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "shampoos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "shampoo_type", discriminatorType = DiscriminatorType.STRING)
public abstract class BasicShampoo implements Shampoo {

    private long id;
    private String brand;
    private BigDecimal price;
    private Size size;
    private ClassicLabel label;
    private ProductionBatch batch;
    private Set<BasicIngredient> ingredients;

    public BasicShampoo() {
        this.setIngredients(new HashSet<>());
    }

    public BasicShampoo(String brand, BigDecimal price, Size size, ClassicLabel label, ProductionBatch
            productionBatch) {
        this();
        this.setBrand(brand);
        this.setPrice(price);
        this.setSize(size);
        this.setLabel(label);
        this.setBatch(productionBatch);
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
    public String getBrand() {
        return brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
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
    @Enumerated(value = EnumType.STRING)
    public Size getSize() {
        return size;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    @OneToOne(optional = false)
    @JoinColumn(name = "label_id", referencedColumnName = "id")
    public ClassicLabel getLabel() {
        return label;
    }

    public void setLabel(ClassicLabel label) {
        this.label = label;
    }

    @Override
    @ManyToOne(optional = false)
    @JoinColumn(name = "batch_id", referencedColumnName = "id")
    public ProductionBatch getBatch() {
        return batch;
    }

    public void setBatch(ProductionBatch batch) {
        this.batch = batch;
    }

    @Override
    @ManyToMany
    @JoinTable(name = "shampoos_ingredients",
            joinColumns = @JoinColumn(name = "shampoo_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
    public Set<BasicIngredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<BasicIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
