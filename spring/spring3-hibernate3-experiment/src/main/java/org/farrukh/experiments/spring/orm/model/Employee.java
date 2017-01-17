package org.farrukh.experiments.spring.orm.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
public class Employee implements Serializable {
    
    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false)
    private BigDecimal id;
    
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "HIRE_DATE", nullable = false)
    private Date hireDate;
    
    @ManyToOne
    @JoinColumn(name = "JOB_ID")
    private Job job;
    
    @Column(name = "SALARY")
    private BigDecimal salary;

    @Column(name = "COMMISSION_PCT")
    private BigDecimal commissionPct;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employee managerId;
    
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department departament;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Employee getManagerId() {
        return managerId;
    }

    public void setManagerId(Employee managerId) {
        this.managerId = managerId;
    }

    public Department getDepartament() {
        return departament;
    }

    public void setDepartament(Department departament) {
        this.departament = departament;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employee [id=")
               .append(id)
               .append(", firstName=")
               .append(firstName)
               .append(", lastName=")
               .append(lastName)
               .append(", salary=")
               .append(salary)
               .append("]");
        return builder.toString();
    }
    
}
