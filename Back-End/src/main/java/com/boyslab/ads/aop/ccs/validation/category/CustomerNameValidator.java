package com.boyslab.ads.aop.ccs.validation.category;

import com.boyslab.ads.aop.aspects.validation.category.CategoryNameMustBeUnique;
import com.boyslab.ads.dataAccess.CategoryRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerNameValidator implements ConstraintValidator<CategoryNameMustBeUnique,String> {

    private final CategoryRepository categoryRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        long count = this.categoryRepository.countByName(value);
        return count <= 0;
    }
}
