package org.farrukh.experiments.orm.hibernate3.query.hql;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.farrukh.experiments.orm.hibernate3.config.SpringHibernate3ContextConfigTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class QueryTest extends SpringHibernate3ContextConfigTest {
    
    @Test
    public void showRichestEmployeeInEurope() throws Exception {
        Object richest = findRichestEmployeeInEurope();
        assertNotNull(richest);
    }
    
    @Test
    public void testFromClause() throws Exception {
        List<?> employees = currentSession().createQuery("from Employee").list();
        Assert.assertNotNull(employees);
    }
    
    @Test
    public void testSelectClauseForResultSetAsList() throws Exception {
        String selectQueryNewList = "select new list(e.id, e.firstName, e.lastName) from Employee e";
        List<?> employees = currentSession().createQuery(selectQueryNewList).list();
        Assert.assertNotNull(employees);
    }

    @Test
    public void testSelectClauseForProjectionToASpecifiedType() throws Exception {
        String selectQueryNewType = "select new org.farrukh.experiments.orm.hibernate3.query.hql.ShortReportData(e.id, e.firstName, e.lastName) from Employee e";
        List<?> employees = currentSession().createQuery(selectQueryNewType).list();
        Assert.assertNotNull(employees);
    }

    private Object findRichestEmployeeInEurope() {
        String saveQuery = "select e.firstName, max(e.salary) as salary from Employee e inner join e.departament as d group by e.salary, e.firstName";
        Object object = currentSession().createQuery(saveQuery).setMaxResults(1).uniqueResult();
        return object;
    }
    
}
