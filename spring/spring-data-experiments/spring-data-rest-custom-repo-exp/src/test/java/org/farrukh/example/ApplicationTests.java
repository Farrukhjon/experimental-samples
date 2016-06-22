package org.farrukh.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest(randomPort = true)
public class ApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void contextLoads() {
		Assert.assertNotNull(bookRepository);
		Assert.assertNotNull(applicationContext);
		String[] names = applicationContext.getBeanDefinitionNames();
		BookRepository bean = applicationContext.getBean(BookRepository.class);
		org.springframework.util.Assert.notEmpty(names);
	}

}
