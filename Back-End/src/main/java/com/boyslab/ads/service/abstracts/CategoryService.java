package com.boyslab.ads.service.abstracts;

import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.dtos.request.category.CategoryAddRequest;
import com.boyslab.ads.dtos.request.category.CategoryUpdateRequest;
import com.boyslab.ads.dtos.response.category.CategoryResponseDto;


import java.util.List;

public  interface CategoryService {
    DataResult<List<CategoryResponseDto>> GetAll();
    Result add(CategoryAddRequest categoryAddRequest);

    Result update(CategoryUpdateRequest categoryUpdateRequest);

    Result delete(int id);

    DataResult<CategoryResponseDto> getById(int id);


}
