package org.farrukh.examples.spring.core.container.configuration.applicationContext.annotation;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Farrukhjon SATTOROV.
 */
public class AnnotationConfigurationApplicationContext extends AnnotationConfigApplicationContext {

    public AnnotationConfigurationApplicationContext() {
    }

    public AnnotationConfigurationApplicationContext(DefaultListableBeanFactory beanFactory) {
        super(beanFactory);
    }

    public AnnotationConfigurationApplicationContext(Class<?>... annotatedClasses) {
        super(annotatedClasses);
    }

    public AnnotationConfigurationApplicationContext(String... basePackages) {
        super(basePackages);
    }
}
