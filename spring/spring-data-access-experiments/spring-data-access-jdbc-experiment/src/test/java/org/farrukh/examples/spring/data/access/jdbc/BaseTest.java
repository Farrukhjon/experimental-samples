package org.farrukh.examples.spring.data.access.jdbc;

import junit.framework.TestCase;
import org.farrukh.examples.spring.data.access.jdbc.config.DaoConfig;
import org.farrukh.examples.spring.data.access.jdbc.config.H2DataSourceConfig;
import org.farrukh.examples.spring.data.access.jdbc.config.TemplatesConfig;
import org.farrukh.examples.spring.data.access.jdbc.config.MySqlDataSourceConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Base test class.
 */
@ActiveProfiles("testing")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = {H2DataSourceConfig.class, MySqlDataSourceConfig.class, TemplatesConfig.class, DaoConfig.class})
public abstract class BaseTest extends TestCase {

}
