package app.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "doctors")
public class Doctor {

    private Long id;
    private String name;
    private String specialty;
    private Set<Visitation> visitations;

    public Doctor() {
        this.setVisitations(new HashSet<>());
    }

    public Doctor(String name, String specialty) {
        this();
        this.setName(name);
        this.setSpecialty(specialty);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    @OneToMany(mappedBy = "doctor",targetEntity = Visitation.class)
    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }
}
