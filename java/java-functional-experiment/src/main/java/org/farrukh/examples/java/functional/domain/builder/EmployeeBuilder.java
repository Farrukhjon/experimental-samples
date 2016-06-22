package org.farrukh.examples.java.functional.domain.builder;

import org.farrukh.examples.java.functional.domain.Department;
import org.farrukh.examples.java.functional.domain.Employee;

/**
 * Created by Farrukhjon on 05-Oct-15.
 */
public class EmployeeBuilder implements Builder<Employee> {

    private int id;
    private String firstName;
    private String name;
    private String lastName;
    private int age;
    private Department department;

    public EmployeeBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public EmployeeBuilder setDepartment(Department department) {
        this.department = department;
        return this;
    }

    public EmployeeBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public EmployeeBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Employee build() {
        return new Employee(id, firstName, name, lastName, age, department);
    }
}
