package org.farrukh.examples.spring.core.container

import org.farrukh.examples.spring.core.container.configuration.applicationContext.annotation.AnnotationConfigurationApplicationContext
import org.farrukh.examples.spring.core.container.configuration.applicationContext.annotation.component.UserBuilder

/**
 * Created by Farrukhjon SATTOROV.
 */
class AnnotationConfigurationApplicationContextTest extends BaseTest {

    def 'exercise app context via annotation'() {
        given:
        def sut = new AnnotationConfigurationApplicationContext()

        when:
        sut.register(UserBuilder.class)
        sut.refresh()

        and:
        def resultBean = sut.getBean(UserBuilder.class)
        def user = resultBean.build()

        then:
        user.name == 'Ali'
    }
}
