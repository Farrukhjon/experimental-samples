package org.farrukh.experiments.spring.orm.service;

import java.util.List;

import org.farrukh.experiments.spring.orm.dao.IEmployeeDao;
import org.farrukh.experiments.spring.orm.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private IEmployeeDao employeeDao;

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public List<Employee> findByName(final String name) {
        return employeeDao.findByName(name);
    }


}
