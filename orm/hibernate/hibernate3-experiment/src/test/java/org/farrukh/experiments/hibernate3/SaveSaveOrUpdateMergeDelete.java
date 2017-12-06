package org.farrukh.experiments.hibernate3;

import org.farrukh.experiments.hibernate3.model.Address;
import org.farrukh.experiments.hibernate3.model.Departament;
import org.farrukh.experiments.hibernate3.model.Employee;
import org.hibernate.classic.Session;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SaveSaveOrUpdateMergeDelete extends AbstractBaseTest {

    @Test
    public void testSessionSaveOperation() {
        Session session = getSessionFactory().openSession();

        session.getTransaction().begin();

        Departament it = generateRandomEmployee();
        Long expectedId = (Long) session.save(it);

        session.getTransaction().commit();

        Departament storedDep = (Departament) session.get(Departament.class, expectedId);

        assertEquals(expectedId, storedDep.getId());
        assertEquals("IT", storedDep.getName());
        assertEquals("Ali", storedDep.getEmployee().getFirstName());
        assertEquals("Switzerland", storedDep.getEmployee().getAddress().getCountry());

        session.close();

    }

    private Departament generateRandomEmployee() {
        Employee ali = new Employee();
        ali.setFirstName("Ali");

        Address aliAddress = new Address();
        aliAddress.setCountry("Switzerland");
        aliAddress.setCiti("Geneva");

        ali.setAddress(aliAddress);

        Departament it = new Departament();
        it.setName("IT");

        it.setEmployee(ali);

        return it;

    }
}
