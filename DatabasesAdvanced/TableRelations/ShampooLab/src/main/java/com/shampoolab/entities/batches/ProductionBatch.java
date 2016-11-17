package com.shampoolab.entities.batches;

import com.shampoolab.entities.shampoos.BasicShampoo;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "batches")
public class ProductionBatch implements Batch {

    private long id;
    private Date date;
    private Set<BasicShampoo> shampoos;

    public ProductionBatch() {
        this.setShampoos(new HashSet<>());
    }

    public ProductionBatch(Date date) {
        this();
        this.setBatchDate(date);
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
    public Date getBatchDate() {
        return date;
    }

    @Override
    public void setBatchDate(Date date) {
        this.date = date;
    }

    @Override
    @OneToMany(mappedBy = "batch", targetEntity = BasicShampoo.class)
    public Set<BasicShampoo> getShampoos() {
        return shampoos;
    }

    @Override
    public void setShampoos(Set<BasicShampoo> shampoos) {
        this.shampoos = shampoos;
    }
}
