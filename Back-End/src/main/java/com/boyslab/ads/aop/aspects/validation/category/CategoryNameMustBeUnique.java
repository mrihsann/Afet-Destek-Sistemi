package com.boyslab.ads.aop.aspects.validation.category;

import com.boyslab.ads.aop.ccs.validation.category.CustomerNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = {CustomerNameValidator.class })
public @interface CategoryNameMustBeUnique {

    String message() default "Kategori adı benzersiz olmalı";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

