package app.entities;

import javax.persistence.*;

@Entity
@Table(name = "licenses")
public class License {

    private Long id;
    private String name;
    private Resource resource;

    public License() {

    }

    public License(String name) {
        this.setName(name);
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

    @ManyToOne
    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
