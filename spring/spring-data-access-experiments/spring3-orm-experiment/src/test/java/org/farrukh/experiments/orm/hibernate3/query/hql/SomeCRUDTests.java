package org.farrukh.experiments.orm.hibernate3.query.hql;

import static org.junit.Assert.assertNotNull;

import org.farrukh.experiments.orm.hibernate3.config.SpringHibernate3ContextConfigTest;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

public class SomeCRUDTests extends SpringHibernate3ContextConfigTest {
    
    @Transactional
    @Test
    public void showRichestEmployeeInEurope() throws Exception {
        Object richest = findRichestEmployeeInEurope();
        assertNotNull(richest);
    }

    private Object findRichestEmployeeInEurope() {
        String saveQuery = "select e.firstName, max(e.salary) as salary from Employee e inner join e.departament as d group by e.salary, e.firstName";
        Object object = currentSession().createQuery(saveQuery).setMaxResults(1).uniqueResult();
        return object;
    }
    
    
    

}
