package com.hoteldb.entities;

import javax.persistence.*;

import static com.hoteldb.util.Messages.CANNOT_CONTAIN_DIGITS_MESSAGE;

@Entity(name = "employees")
public class Employee {


    private long id;
    private String firstName;
    private String lastName;
    private String title;
    private String notes;

    public Employee() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.contains("\\d*")) {
            throw new IllegalArgumentException(String.format(CANNOT_CONTAIN_DIGITS_MESSAGE,"First name"));
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.contains("\\d*")) {
            throw new IllegalArgumentException(String.format(CANNOT_CONTAIN_DIGITS_MESSAGE,"Last name"));
        }
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(columnDefinition = "TEXT")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
