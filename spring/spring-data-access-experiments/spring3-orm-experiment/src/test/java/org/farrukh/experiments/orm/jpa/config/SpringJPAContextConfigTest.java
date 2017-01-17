package org.farrukh.experiments.orm.jpa.config;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.farrukh.experiments.spring.orm.jpa.config.SpringJPAContextConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringJPAContextConfig.class, loader = AnnotationConfigContextLoader.class)
public class SpringJPAContextConfigTest {

    @Autowired
    EntityManagerFactory entityManagerFactory;
    
    @PersistenceContext // Injection of the EntityManager
    EntityManager entityManager;

    @Test
    public void shouldTestStartingUpSpringJPAContextConfiguration() throws Exception {
        assertNotNull(entityManagerFactory);
        assertNotNull(entityManager);
    }

}
