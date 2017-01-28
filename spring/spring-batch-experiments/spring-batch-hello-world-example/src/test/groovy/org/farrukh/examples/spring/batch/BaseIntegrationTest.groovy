package org.farrukh.examples.spring.batch

import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration

@ContextConfiguration(classes = Application, loader = SpringApplicationContextLoader)
class BaseIntegrationTest extends BaseTest {
}
