package com.hoteldb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "bed_types")
public class BedType {

    private long id;
    private String bedType;
    private String notes;

    public BedType() {

    }

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomType() {
        return bedType;
    }

    public void setRoomType(String roomType) {
        this.bedType = roomType;
    }

    @Column(columnDefinition = "TEXT")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
