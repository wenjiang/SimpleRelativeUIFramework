package com.zwb.args.relatvieui.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 设置监听的注解
 * Created by pc on 2015/4/16.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Listener {
    int id() default -1;

    int listener() default -1;

    String type() default "";
}
