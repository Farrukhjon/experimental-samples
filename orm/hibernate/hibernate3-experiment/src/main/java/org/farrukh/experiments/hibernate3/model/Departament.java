package org.farrukh.experiments.hibernate3.model;


import javax.persistence.*;

@Entity
public class Departament {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @JoinColumn(name = "employeeId")
    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
