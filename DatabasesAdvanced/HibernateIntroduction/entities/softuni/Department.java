package entities.softuni;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private int departmentId;

    @Basic
    private String name;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @OneToMany
    @JoinColumn(name = "department_id")
    List<Employee> employees;

    public Department() {
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Employee getManager() {
        return this.manager;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
