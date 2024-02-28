package com.boyslab.ads.service;

import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.SuccessResult;
import com.boyslab.ads.dataAccess.CategoryRepository;
import com.boyslab.ads.dtos.request.category.CategoryAddRequest;
import com.boyslab.ads.dtos.response.category.CategoryResponseDto;
import com.boyslab.ads.entities.Category;
import com.boyslab.ads.service.abstracts.CategoryService;
import com.boyslab.ads.service.concretes.CategoryBusiness;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class CategoryServiceTest {

    private CategoryRepository categoryRepository;
    private CategoryService categoryService;

    private CategoryResponseDto categoryResponseDto;
    @BeforeEach
    public void setUp(){
        categoryRepository =  mock(CategoryRepository.class);
        categoryService = mock(CategoryBusiness.class);
        categoryResponseDto = mock(CategoryResponseDto.class);
    }

}
