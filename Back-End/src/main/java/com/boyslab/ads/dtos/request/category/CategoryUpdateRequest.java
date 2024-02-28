package com.boyslab.ads.dtos.request.category;

import com.boyslab.ads.aop.aspects.validation.category.CategoryNameMustBeUnique;
import com.boyslab.ads.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record CategoryUpdateRequest(

        @NotNull
        int id,
        @CategoryNameMustBeUnique
        @NotNull
        @NotEmpty
        @NotBlank
        String name,

        String description) {

    public static Category convertToEntity(CategoryUpdateRequest request){
        Category category = new Category();
        category.setId(request.id);
        category.setName(request.name);
        category.setDescription(request.description);

        return category;

    }

}
