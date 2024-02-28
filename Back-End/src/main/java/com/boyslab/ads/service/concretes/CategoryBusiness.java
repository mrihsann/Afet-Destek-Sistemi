package com.boyslab.ads.service.concretes;

import com.boyslab.ads.aop.aspects.PerformanceLogger;
import com.boyslab.ads.aop.aspects.logger.LoggerResult;
import com.boyslab.ads.aop.ccs.logger.LogType;
import com.boyslab.ads.core.exceptions.BusinessException;
import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.core.result.SuccessDataResult;
import com.boyslab.ads.core.result.SuccessResult;
import com.boyslab.ads.dataAccess.CategoryRepository;
import com.boyslab.ads.dtos.request.category.CategoryAddRequest;
import com.boyslab.ads.dtos.request.category.CategoryUpdateRequest;
import com.boyslab.ads.dtos.response.category.CategoryResponseDto;
import com.boyslab.ads.entities.Category;
import com.boyslab.ads.service.abstracts.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import static com.boyslab.ads.service.Messages.*;

@Service
@RequiredArgsConstructor
public  class CategoryBusiness implements CategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public DataResult<List<CategoryResponseDto>> GetAll() {
        List<Category> list = this.categoryRepository.findAll();
        //1. Yöntem
   /*     List<CategoryResponseDto> responseDtos = new ArrayList<>();

        for(Category category : list){
            CategoryResponseDto categoryResponseDto = CategoryResponseDto.convertToResponse(category);
            responseDtos.add(categoryResponseDto);
        }

*/

        //2. Yöntem
        List<CategoryResponseDto> responseDtos = list.stream().map(CategoryResponseDto::convertToResponse).toList();

        //3. Yöntem
 /*       List<CategoryResponseDto> responseDtos = list.stream().map(category->CategoryResponseDto.convertToResponse(category)).collect(Collectors.toList());*/
        return new SuccessDataResult<>(categoryOfListMessage,responseDtos);
    }

    @Override
    @LoggerResult(type = LogType.FILE)
    @PerformanceLogger
    public Result add(CategoryAddRequest categoryAddRequest) {
        Category category = CategoryAddRequest.convertToEntity(categoryAddRequest);
        this.categoryRepository.save(category);


        return new  SuccessResult(categoryAddMessage);
    }

    @LoggerResult(type = LogType.FILE)
    @Override
    public Result update(CategoryUpdateRequest categoryUpdateRequest) {
        Optional<Category> findCategory = this.categoryRepository.findById(categoryUpdateRequest.id());

       Category category= findCategory.orElseThrow(()-> new BusinessException(throwUpdateMessage));

       category.setName(categoryUpdateRequest.name());
       category.setDescription(categoryUpdateRequest.description());

       this.categoryRepository.save(category);

       return  new SuccessResult(categoryUpdateMessage);

    }

    @Override
    @PerformanceLogger
    public Result delete(int id) {
        Category findCategory = this.categoryRepository.findById(id).orElseThrow(()-> new BusinessException(throwDeleteMessage));
        this.categoryRepository.delete(findCategory);

        return new SuccessResult(categoryDeleteMessage);

    }

    @Override
    public DataResult<CategoryResponseDto> getById(int id) {
        Category findCategory = this.categoryRepository.findById(id).orElseThrow(()-> new BusinessException(throwFindByMessage));

        CategoryResponseDto responseDto = CategoryResponseDto.convertToResponse(findCategory);

        return new SuccessDataResult<>(categoryFindIdMessage,responseDto);

    }
}
