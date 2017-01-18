package org.farrukh.experiments.spring.orm.jpa.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.farrukh.experiments.spring.orm.model.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoByCriteriaQuery {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Employee> name() {
        CriteriaQuery<Object> criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
        return null;
    }

}
