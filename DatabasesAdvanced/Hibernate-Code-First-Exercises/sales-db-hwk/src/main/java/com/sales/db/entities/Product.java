package com.sales.db.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "products")
public class Product {

    private long id;
    private String name;
    private Double quantiy;
    private BigDecimal price;
    private Set<Sale> sales;

    public Product() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    public Double getQuantiy() {
        return quantiy;
    }

    public void setQuantiy(Double quantiy) {
        this.quantiy = quantiy;
    }

    @Basic
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @OneToMany(mappedBy = "product", targetEntity = Sale.class)
    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
