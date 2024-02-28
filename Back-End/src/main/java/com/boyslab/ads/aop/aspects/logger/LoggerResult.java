package com.boyslab.ads.aop.aspects.logger;

import com.boyslab.ads.aop.ccs.logger.LogType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoggerResult {

    LogType type() default LogType.DATABASE;
}
