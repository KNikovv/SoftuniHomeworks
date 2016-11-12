package com.hoteldb.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "occupancies")
public class Occupancy {

    private long id;
    private Date dateOccupied;
    private long accountNumber;
    private long roomNumber;
    private Double rateApplied;
    private Double phoneCharge;
    private String notes;

    public Occupancy() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateOccupied() {
        return dateOccupied;
    }

    public void setDateOccupied(Date dateOccupied) {
        this.dateOccupied = dateOccupied;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Double getRateApplied() {
        return rateApplied;
    }

    public void setRateApplied(Double rateApplied) {
        this.rateApplied = rateApplied;
    }

    public Double getPhoneCharge() {
        return phoneCharge;
    }

    public void setPhoneCharge(Double phoneCharge) {
        this.phoneCharge = phoneCharge;
    }

    @Column(columnDefinition = "TEXT")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
