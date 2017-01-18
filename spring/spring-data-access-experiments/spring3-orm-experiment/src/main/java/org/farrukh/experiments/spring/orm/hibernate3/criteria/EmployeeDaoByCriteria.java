package org.farrukh.experiments.spring.orm.hibernate3.criteria;

import java.util.List;

import org.farrukh.experiments.spring.orm.model.Employee;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoByCriteria {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public List<Employee> name() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
        return null;
    }

}
