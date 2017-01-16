package org.farrukh.experiments.old.tech.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.farrukh.experiments.old.tech.AppContextConfigTests;
import org.farrukh.experiments.old.tech.model.Employee;
import org.farrukh.experiments.old.tech.service.EmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceTest extends AppContextConfigTests {
    
    @Autowired
    private EmployeeService service;
    
    @Test
    public void shouldReturnAllEmployees() throws Exception {
        List<Employee> employees = service.findAll();
        int employeeCount = employees.size();
        assertTrue(employeeCount > 0);
    }

}
