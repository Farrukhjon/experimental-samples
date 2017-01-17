package org.farrukh.examples.spring.data.access.jdbc;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Base test class.
 */
@ActiveProfiles("testing")
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class BaseTest extends TestCase {

}
