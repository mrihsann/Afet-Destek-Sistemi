package com.boyslab.ads.dtos.response.category;

import com.boyslab.ads.entities.Category;

public record CategoryResponseDto(int id, String name, String description) {

    public static CategoryResponseDto convertToResponse(Category category){

        return new CategoryResponseDto(
                category.getId(),
                category.getName(),
                category.getDescription());
    }
}
