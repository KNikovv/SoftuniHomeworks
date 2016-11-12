package bg.softuni.hibernate.entities;

import javax.persistence.*;

@Entity(name = "towns")
public class Town {

    private Long id;
    private String name;
    private Country country;

    public Town() {

    }

    public Town(String name, Country country) {
        this.setName(name);
        this.setCountry(country);
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

    @ManyToOne()
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
