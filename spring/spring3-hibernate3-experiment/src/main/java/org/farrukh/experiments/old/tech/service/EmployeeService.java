package org.farrukh.experiments.old.tech.service;

import java.util.List;

import org.farrukh.experiments.old.tech.dao.IEmployeeDao;
import org.farrukh.experiments.old.tech.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private IEmployeeDao employeeDao;
    
    public List<Employee>findAll() {
        return employeeDao.findAll();
    }
    
    
}
