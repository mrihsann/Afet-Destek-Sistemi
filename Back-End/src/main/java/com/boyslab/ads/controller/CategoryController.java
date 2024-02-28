package com.boyslab.ads.controller;

import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.dtos.request.category.CategoryAddRequest;
import com.boyslab.ads.dtos.request.category.CategoryUpdateRequest;
import com.boyslab.ads.dtos.response.category.CategoryResponseDto;
import com.boyslab.ads.service.abstracts.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public final class CategoryController extends BaseController{

    private  final CategoryService categoryService;

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<CategoryResponseDto>>> getAll(){

        var data = this.categoryService.GetAll();
        return responseData(data);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<DataResult<CategoryResponseDto>> getById(@PathVariable("id") int id){
        var data = this.categoryService.getById(id);
        return responseData(data);
    }

    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody CategoryAddRequest categoryAddRequest){
        var data = this.categoryService.add(categoryAddRequest);
        return responseNoData(data);
    }

    @PutMapping("/update")
    public ResponseEntity<Result> update(@Valid  @RequestBody CategoryUpdateRequest categoryUpdateRequest){
        var data = this.categoryService.update(categoryUpdateRequest);
        return responseNoData(data);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int id){
        var data = this.categoryService.delete(id);
        return responseNoData(data);
    }


}
