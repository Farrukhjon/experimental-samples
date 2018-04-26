package org.farrukh.experiment;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-context.xml")
public class AppTest {

    @Autowired
    ClassA classA;

    @Autowired
    ClassB classB;

    @Autowired
    ClassC classC;

    @Autowired
    Environment environment;


    @Test
    public void testInjection() {
        Assert.assertNotNull(environment);
        Assert.assertNotNull(classA);
        Assert.assertNotNull(classB);

        //when:
        RootInterface injectedBean = classC.getInjectedBean();

        //then:
        assertEquals(injectedBean.getClass(), ClassA.class);
    }
}
