package com.hoteldb.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import static com.hoteldb.util.Messages.CANNOT_CONTAIN_DIGITS_MESSAGE;

@Entity(name = "customers")
public class Customer {

    private long accountNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emergencyName;
    private String emergencyNumber;
    private String notes;

    public Customer() {

    }

    @Id
    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.contains("\\d*")) {
            throw new IllegalArgumentException(String.format(CANNOT_CONTAIN_DIGITS_MESSAGE, "First name"));
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.contains("\\d*")) {
            throw new IllegalArgumentException(String.format(CANNOT_CONTAIN_DIGITS_MESSAGE, "Last name"));
        }
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmergencyName() {
        return emergencyName;
    }

    public void setEmergencyName(String emergencyName) {
        this.emergencyName = emergencyName;
    }

    public String getEmergencyNumber() {
        return emergencyNumber;
    }

    public void setEmergencyNumber(String emergencyNumber) {
        this.emergencyNumber = emergencyNumber;
    }

    @Column(columnDefinition = "TEXT")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
