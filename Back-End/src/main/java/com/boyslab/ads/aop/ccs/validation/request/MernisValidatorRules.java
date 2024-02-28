package com.boyslab.ads.aop.ccs.validation.request;

import com.boyslab.ads.aop.aspects.validation.request.MernisValidator;
import com.boyslab.ads.core.exceptions.BusinessException;
import com.boyslab.ads.dtos.request.request.RequestDto;
import com.boyslab.ads.service.mernis.HSCKPSPublicSoap;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MernisValidatorRules implements ConstraintValidator<MernisValidator, RequestDto> {

    private HSCKPSPublicSoap mernis;

    public MernisValidatorRules(HSCKPSPublicSoap mernis) {
        this.mernis = mernis;
    }

    @Override
    public boolean isValid(RequestDto value, ConstraintValidatorContext context) {


        try {
            return  mernis.TCKimlikNoDogrula(
                    Long.valueOf(value.tc()),
                    value.name(),
                    value.surname(),
                    value.birthDay()
            );
        } catch (Exception e) {
            throw new BusinessException(e.getMessage());
        }

    }
}
