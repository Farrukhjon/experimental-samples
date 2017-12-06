package org.farrukh.experiments.hibernate3;

import org.farrukh.experiments.hibernate3.model.Employee;
import org.hibernate.classic.Session;
import org.junit.Assert;
import org.junit.Test;

public class SaveSaveOrUpdateMergeDelete extends AbstractBaseTest {

    @Test
    public void testSessionSaveOperation() {
        Session session = getSessionFactory().openSession();

        session.getTransaction().begin();

        Employee employee = generateRandomEmployee();
        Long expectedId = (Long) session.save(employee);

        session.getTransaction().commit();

        Employee ali = (Employee) session.get(Employee.class, expectedId);

        Assert.assertEquals(ali.getId(), expectedId);
        Assert.assertEquals(ali.getFirstName(), "Ali");

        session.close();

    }

    private Employee generateRandomEmployee() {
        Employee employee = new Employee();
        employee.setFirstName("Ali");
        return employee;

    }
}
