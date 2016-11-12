package com.hoteldb.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "payments")
public class Payment {

    private long id;
    private Date paymentDate;
    private long accountNumber;
    private Date firstDateOccupied;
    private Date lastDateOccupied;
    private int totalDays;
    private Double amountCharged;
    private Double taxRate;
    private Double taxAmount;
    private Double paymentTotal;
    private String notes;

    public Payment() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getFirstDateOccupied() {
        return firstDateOccupied;
    }

    public void setFirstDateOccupied(Date firstDateOccupied) {
        this.firstDateOccupied = firstDateOccupied;
    }

    public Date getLastDateOccupied() {
        return lastDateOccupied;
    }

    public void setLastDateOccupied(Date lastDateOccupied) {
        this.lastDateOccupied = lastDateOccupied;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public Double getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(Double amountCharged) {
        this.amountCharged = amountCharged;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

    public Double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Double getPaymentTotal() {
        return paymentTotal;
    }

    public void setPaymentTotal(Double paymentTotal) {
        this.paymentTotal = paymentTotal;
    }

    @Column(columnDefinition = "TEXT")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
