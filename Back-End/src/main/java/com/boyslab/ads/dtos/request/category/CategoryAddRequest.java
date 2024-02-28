package com.boyslab.ads.dtos.request.category;

import com.boyslab.ads.aop.aspects.validation.category.CategoryNameMustBeUnique;
import com.boyslab.ads.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record CategoryAddRequest(
        @NotNull
        @NotEmpty
        @NotBlank
        @CategoryNameMustBeUnique
        String name,
        @Length(min = 5, message = "Açıklama alanı minimum 5 karakterli olmalıdır.")
        String description) {
    public static Category convertToEntity(CategoryAddRequest categoryAddRequest){

        Category category = new Category();
        category.setName(categoryAddRequest.name);
        category.setDescription(categoryAddRequest.description);
        return category;
    }

}
