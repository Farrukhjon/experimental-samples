/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.example.hibernate.identifier;

import lombok.Getter;
import lombok.Setter;
import org.farrukh.example.hibernate.AbstractBaseTest;
import org.junit.Test;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CompositeIdTests extends AbstractBaseTest {

    @Override
    protected Class<?>[] getAnnotatedClasses() {
        return new Class<?>[]{
                Company.class,
                Employee.class,
                Phone.class
        };
    }

    @Test
    public void test() throws Exception {

        executeInTransaction(session -> {
            Company company = new Company();
            company.setId(1L);
            company.setName("ali_vali.com");
            session.persist(company);

            Employee employee = new Employee();
            employee.setId(new EmployeeId(1L, 100L));
            employee.setName("Ali Valizoda");
            session.save(employee);
        });

        executeInTransaction(session -> {
            Employee employee = session.find(Employee.class, new EmployeeId(1L, 100L));
            Phone phone = new Phone();
            phone.setEmployee(employee);
            phone.setNumber("+992-92-888-58-46");
            session.save(phone);
        });

        executeInTransaction(session -> {
            Phone phone = session.find(Phone.class, "+992-92-888-58-46");
            assertNotNull(phone);
            assertEquals(new EmployeeId(1L, 100L), phone.getEmployee().getId());
        });


    }

    @Entity(name = "Company")
    @Table(name = "company")
    @Getter
    @Setter
    private static class Company {

        @Id
        private Long id;

        private String name;

    }

    @Entity(name = "Employee")
    @Table(name = "employee")
    @Setter
    @Getter
    private static class Employee {

        @EmbeddedId
        private EmployeeId id;

        private String name;

        @ManyToOne
        @JoinColumn(name = "company_id", insertable = false, updatable = false)
        private Company company;


    }

    @Entity(name = "Phone")
    @Table(name = "phone")
    @Getter
    @Setter
    private static class Phone {

        @Id
        @Column(name = "`number`")
        private String number;

        @ManyToOne
        @JoinColumns({
                @JoinColumn(
                        name = "company_id",
                        referencedColumnName = "company_id"),
                @JoinColumn(
                        name = "employee_number",
                        referencedColumnName = "employee_number")
        })
        private Employee employee;

    }

    @Getter
    @Setter
    @Embeddable
    private static class EmployeeId implements Serializable {

        @Column(name = "company_id")
        private Long companyId;

        @Column(name = "employee_number")
        private Long employeeNumber;

        public EmployeeId() {
        }

        public EmployeeId(Long companyId, Long employeeId) {
            this.companyId = companyId;
            this.employeeNumber = employeeId;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof EmployeeId)) return false;
            EmployeeId that = (EmployeeId) o;
            return Objects.equals(getCompanyId(), that.getCompanyId()) &&
                    Objects.equals(getEmployeeNumber(), that.getEmployeeNumber());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getCompanyId(), getEmployeeNumber());
        }
    }

}
