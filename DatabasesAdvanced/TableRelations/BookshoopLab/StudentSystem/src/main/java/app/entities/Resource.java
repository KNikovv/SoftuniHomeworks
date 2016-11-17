package app.entities;

import app.entities.enums.ResourceType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "resources")
public class Resource {

    private Long id;
    private String name;
    private ResourceType resourceType;
    private String url;
    private Course course;
    private Set<License> licenses;

    public Resource() {

    }

    public Resource(String name, ResourceType resourceType, String url) {
        this.setName(name);
        this.setResourceType(resourceType);
        this.setUrl(url);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    @Column(nullable = false)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @ManyToOne()
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @OneToMany
    @JoinColumn(name = "license_id",referencedColumnName = "id")
    public Set<License> getLicenses() {
        return licenses;
    }

    public void setLicenses(Set<License> licenses) {
        this.licenses = licenses;
    }
}
