package org.farrukh.experiments.old.tech;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class AppConfigContext {
    final Logger logger = LoggerFactory.getLogger(MyBean.class);

}
