package com.sales.db.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "locations")
public class StoreLocation {

    private long id;
    private String locationName;
    private Set<Sale> sales;

    public StoreLocation() {

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
    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @OneToMany(mappedBy = "storeLocation", targetEntity = Sale.class)
    public Set<Sale> getSales() {
        return this.sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
