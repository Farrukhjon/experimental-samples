package org.farrukh.examples.java.reflection.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface MyAnnotation {

    String value() default "";

    String message() default "value must not be null";
}
