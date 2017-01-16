package org.farrukh.experiments.old.tech.dao;

import org.farrukh.experiments.old.tech.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao extends AbstractHibernateDao<Employee> implements IEmployeeDao {
    
    public EmployeeDao() {
        super(Employee.class);
    }

}
