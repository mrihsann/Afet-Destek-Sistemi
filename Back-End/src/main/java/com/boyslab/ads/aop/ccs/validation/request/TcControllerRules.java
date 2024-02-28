package com.boyslab.ads.aop.ccs.validation.request;

import com.boyslab.ads.aop.aspects.validation.request.TcController;
import com.boyslab.ads.dataAccess.RequestRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class TcControllerRules implements ConstraintValidator<TcController, String> {

private final RequestRepository repository;
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        int count = this.repository.countByTc(value);

        return count <= 0;
    }
}
