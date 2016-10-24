package org.farrukh.examples.spring.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextHierarchy({
    @ContextConfiguration(name = "parent", classes = ParentAppContextConfig.class),
    @ContextConfiguration(name = "child", locations = "classpath:application-context.xml")
})
@SpringBootTest
public class ApplicationTests {

    @Test
    public void contextLoads() {
    }

}
