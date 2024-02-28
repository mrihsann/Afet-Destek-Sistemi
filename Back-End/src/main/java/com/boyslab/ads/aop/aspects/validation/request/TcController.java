package com.boyslab.ads.aop.aspects.validation.request;

import com.boyslab.ads.aop.ccs.validation.request.MernisValidatorRules;
import com.boyslab.ads.aop.ccs.validation.request.TcControllerRules;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static com.boyslab.ads.service.Messages.personIsMustBeUnique;
import static com.boyslab.ads.service.Messages.personNotFoundMessage;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = {TcControllerRules.class })
public @interface TcController {

    String message() default personIsMustBeUnique;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
