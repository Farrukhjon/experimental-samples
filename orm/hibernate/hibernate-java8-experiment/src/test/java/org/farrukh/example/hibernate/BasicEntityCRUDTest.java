import org.farrukh.example.hibernate.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BasicEntityCRUDTest {

    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        String url = "hibernate.cfg.xml";
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure(url)
                                                              .build();
        sessionFactory = new MetadataSources(serviceRegistry).buildMetadata()
                                                                            .buildSessionFactory();
    }

    @Test
    public void testSomeLibraryMethod() {
        Assert.assertNotNull(sessionFactory);
        Session session = sessionFactory.openSession();

        session.beginTransaction();

        session.save(new Order());

        session.getTransaction().commit();
        session.close();

    }
}
