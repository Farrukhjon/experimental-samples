package org.farrukh.experiments.orm.hibernate3.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.farrukh.experiments.orm.hibernate3.config.SpringHibernate3ContextConfigTest;
import org.farrukh.experiments.spring.orm.model.Employee;
import org.farrukh.experiments.spring.orm.service.EmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceTest extends SpringHibernate3ContextConfigTest {
    
    @Autowired
    private EmployeeService service;
    
    @Test
    public void shouldReturnAllEmployees() throws Exception {
        List<Employee> employees = service.findAll();
        int employeeCount = employees.size();
        assertTrue(employeeCount > 0);
    }
    
    @Test
    public void shouldReturnEmployeesByName() throws Exception {
        List<Employee> employees = service.findByName("James");
        for (Employee employee: employees) {
            assertEquals("James", employee.getFirstName());
        }
    }

}
