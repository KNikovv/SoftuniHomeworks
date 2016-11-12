package com.hoteldb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "room_status")
public class RoomStatus {

    private long id;
    private String roomStatus;
    private String notes;

    public RoomStatus() {

    }

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String occupied) {
        roomStatus = occupied;
    }

    @Column(columnDefinition = "TEXT")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
