package com.boyslab.ads.service.concretes;

import com.boyslab.ads.core.exceptions.BusinessException;
import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.core.result.SuccessDataResult;
import com.boyslab.ads.core.result.SuccessResult;
import com.boyslab.ads.dataAccess.ReportingDebrisRepository;
import com.boyslab.ads.dtos.request.reportingDebris.AddReportingDebrisDSto;
import com.boyslab.ads.dtos.request.reportingDebris.ReportingDebrisDto;
import com.boyslab.ads.dtos.response.reportingDebris.ReportingDebrisResponseDto;
import com.boyslab.ads.entities.ReportingDebris;
import com.boyslab.ads.service.Messages;
import com.boyslab.ads.service.abstracts.ReportingDebrisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.boyslab.ads.service.Messages.*;

@Service
@RequiredArgsConstructor
public  class ReportingDebrisBusiness implements ReportingDebrisService {
    private final ReportingDebrisRepository reportingDebrisRepository;


    @Override
    public DataResult<List<ReportingDebrisResponseDto>> GetAll() {

        var reportingDebrisResponseDtoLit = this.reportingDebrisRepository.findAll();
        List<ReportingDebrisResponseDto> responses = reportingDebrisResponseDtoLit
                .stream()
                .map(ReportingDebrisResponseDto::convertToDto)
                .toList();


        return new SuccessDataResult<>(reportingOfListMessage,responses);
    }

    @Override
    public Result add(AddReportingDebrisDSto reportingDebrisDto) {
        ReportingDebris reportingDebris = AddReportingDebrisDSto.convertToEntity(reportingDebrisDto);
        this.reportingDebrisRepository.save(reportingDebris);


        return new SuccessResult(requestAddMessage);
    }

    @Override
    public Result update(ReportingDebrisDto reportingDebrisDto) {
        Optional<ReportingDebris> findReportingDebris=this.reportingDebrisRepository.findById(reportingDebrisDto.id());

        ReportingDebris reportingDebris=findReportingDebris.orElseThrow(()->new BusinessException(throwReportingUpdateMessage));

        reportingDebris.setPhoneNumber(reportingDebrisDto.phoneNumber());
        reportingDebris.setCity(reportingDebrisDto.city());
        reportingDebris.setDistrict(reportingDebrisDto.district());
        reportingDebris.setNeighbourhood(reportingDebrisDto.neighbourhood());
        reportingDebris.setStreet(reportingDebrisDto.street());
        reportingDebris.setLocationDescription(reportingDebrisDto.locationDescription());
        reportingDebris.setImage(reportingDebrisDto.imageUrl());
        reportingDebris.setEkipVarMı(reportingDebrisDto.ekipVarMı());

        this.reportingDebrisRepository.save(reportingDebris);
        return  new SuccessResult(reportingUpdateMessage);
    }

    @Override
    public Result delete(int id) {
        ReportingDebris findReportingDebris =this.reportingDebrisRepository.findById(id).orElseThrow(()->new BusinessException(throwReportingDeleteMessage));
        return new SuccessResult(reportingDeleteMessage);
    }

    @Override
    public DataResult<ReportingDebrisResponseDto> getById(int id) {
        var report = this.reportingDebrisRepository.findById(id)
                .orElseThrow(()-> new BusinessException(reportingThrowFindByMessage));

        ReportingDebrisResponseDto dto = ReportingDebrisResponseDto.convertToDto(report);

        return new SuccessDataResult<>(dto);
    }

}
