package com.boyslab.ads.service.concretes;

import com.boyslab.ads.aop.aspects.PerformanceLogger;
import com.boyslab.ads.aop.aspects.logger.LoggerResult;
import com.boyslab.ads.aop.ccs.logger.LogType;
import com.boyslab.ads.core.exceptions.BusinessException;
import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.core.result.SuccessDataResult;
import com.boyslab.ads.core.result.SuccessResult;
import com.boyslab.ads.dataAccess.RequestRepository;
import com.boyslab.ads.dtos.request.category.CategoryAddRequest;
import com.boyslab.ads.dtos.request.request.RequestDto;
import com.boyslab.ads.dtos.request.request.UpdateRequestStatusDto;
import com.boyslab.ads.dtos.response.category.CategoryResponseDto;
import com.boyslab.ads.dtos.response.request.RequestDetailDto;
import com.boyslab.ads.dtos.response.request.RequestResponseDto;
import com.boyslab.ads.entities.Category;
import com.boyslab.ads.entities.Request;
import com.boyslab.ads.entities.enums.Status;
import com.boyslab.ads.service.Messages;
import com.boyslab.ads.service.abstracts.RequestService;
import com.boyslab.ads.service.mernis.HSCKPSPublicSoap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.boyslab.ads.service.Messages.*;



@Service
@RequiredArgsConstructor
public  class RequestBusiness implements RequestService {

    private final RequestRepository requestRepository;

    @Override
    public DataResult<List<RequestResponseDto>> GetAll() {

        List<Request> data = this.requestRepository.findAll();
        var responses = data
                .stream()
                .map(RequestResponseDto::convertToDto)
                .toList();

        return new SuccessDataResult<>(requestOfListMessage,responses);
    }

    @Override
    @LoggerResult(type = LogType.DATABASE)
    @PerformanceLogger
    public Result add(RequestDto requestDto) throws Exception {

        Request request = RequestDto.convertToEntity(requestDto);

        this.requestRepository.save(request);

        return new SuccessResult(requestAddMessage);
    }

    @Override
    public Result update(RequestDto requestDto) {
        Optional <Request> findRequest = this.requestRepository.findById(requestDto.tc());
     findRequest.orElseThrow(()->new BusinessException(throwRequestUpdateMessage));


        Request request = RequestDto.convertToEntity(requestDto);

        this.requestRepository.save(request);
        return  new SuccessResult(requestUpdateMessage);
    }

    @Override
    public Result delete(String tc) {

        var request = this.requestRepository.findById(tc).orElseThrow(()-> new BusinessException(requestThrowFindByMessage));

        this.requestRepository.delete(request);


        return new SuccessResult(requestDeleteMessage);
    }

    @Override
    public DataResult<List<RequestDetailDto>> getAllDetailsByCategoryId(int categoryId) {
        var details = this.requestRepository.getDetailsByCategoryId(categoryId);

        return new SuccessDataResult<>(details);

    }

    @Override
    public Result updateStatus(UpdateRequestStatusDto dto) {

        var request = this.requestRepository.findById(dto.tc()).orElseThrow(()->new BusinessException(throwRequestUpdateMessage));

        request.setStatus(dto.status());

        this.requestRepository.save(request);

        return new SuccessResult(requestUpdateMessage);
    }

    @Override
    public DataResult<List<RequestResponseDto>> getAllByStatus(Status status) {

        List<Request> result = this.requestRepository.findAllByStatus(status);

         List<RequestResponseDto> responseDtos = result.stream().map(RequestResponseDto::convertToDto).toList();

        return new SuccessDataResult<>(responseDtos);
    }

    @Override
    public DataResult<List<RequestDetailDto>> getAllDetails() {
        List<RequestDetailDto> detailDtos = this.requestRepository.getDetails();


        return new SuccessDataResult<>(detailDtos);
    }

    @Override
    public DataResult<RequestResponseDto> getByTc(String tc) {
        var request = this.requestRepository.findById(tc).orElseThrow(()-> new BusinessException(requestThrowFindByMessage));
        RequestResponseDto response = RequestResponseDto.convertToDto(request);
        return new SuccessDataResult<>(requestFindTcMessage,response);
    }



}
