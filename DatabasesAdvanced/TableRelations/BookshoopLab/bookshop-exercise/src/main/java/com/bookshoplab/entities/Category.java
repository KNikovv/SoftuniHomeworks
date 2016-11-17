package com.bookshoplab.entities;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    private long id;
    private String name;

    public Category() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
