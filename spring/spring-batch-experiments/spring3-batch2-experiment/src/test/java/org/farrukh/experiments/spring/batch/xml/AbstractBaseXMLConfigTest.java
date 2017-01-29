package org.farrukh.experiments.spring.batch.xml;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/job-config.xml", "/job-launcher-test-config.xml" })
public abstract class AbstractBaseXMLConfigTest {

}
