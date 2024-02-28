package com.boyslab.ads.service.concretes;

import com.boyslab.ads.aop.aspects.PerformanceLogger;
import com.boyslab.ads.core.exceptions.BusinessException;
import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.core.result.SuccessDataResult;
import com.boyslab.ads.core.result.SuccessResult;
import com.boyslab.ads.dataAccess.DebrisHelpRepository;
import com.boyslab.ads.dtos.request.debrisHelp.DebrisHelpDto;
import com.boyslab.ads.dtos.response.debirsHelp.DebrisHelpResponceDto;
import com.boyslab.ads.entities.DebrisHelp;
import com.boyslab.ads.service.abstracts.DebrisHelpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.boyslab.ads.service.Messages.*;

@Service
@RequiredArgsConstructor
public  class DebrisHelpBusiness implements DebrisHelpService {

    private final DebrisHelpRepository debrisHelpRepository;

    @Override
    public DataResult<List<DebrisHelpResponceDto>> GetAll() {

        var debrisHelpResponceDto =this.debrisHelpRepository.findAll();
        List<DebrisHelpResponceDto> responces= debrisHelpResponceDto
                .stream()
                .map(DebrisHelpResponceDto::convertToDto)
                .toList();


        return new SuccessDataResult<>(debrisHelperListMessage,responces);
    }

    @Override
    @PerformanceLogger
    public Result add(DebrisHelpDto debrisHelpDto) {

        DebrisHelp debrisHelp = DebrisHelpDto.convertToEntity(debrisHelpDto);
        this.debrisHelpRepository.save(debrisHelp);
        return new SuccessResult(debrisHelperAddMesage);
    }

    @Override
    public Result delete(int debrisId) {
        DebrisHelp findDebrisHelp =this.debrisHelpRepository.findById(debrisId).orElseThrow(()->new BusinessException(debrisHelperDeleteMessage));
        return new SuccessResult(debrisHelperDeleteMessage);
    }

    @Override
    public Result update(DebrisHelpDto debrisHelpDto) {
        Optional <DebrisHelp> findDebrisHelp=this.debrisHelpRepository.findById(debrisHelpDto.debrisID());
        findDebrisHelp.orElseThrow(()-> new BusinessException(debrisHelperFindMessage));

        DebrisHelp debrisHelp = DebrisHelpDto.convertToEntity(debrisHelpDto);

        this.debrisHelpRepository.save(debrisHelp);

        return  new SuccessResult(debrisHelperUpdateMessage);
    }


    @Override
    public DataResult<DebrisHelpResponceDto> GetById(int debrisID) {
        var report= this.debrisHelpRepository.findById(debrisID)
                .orElseThrow(()->new BusinessException(debrisThrowFindByMessage));
        DebrisHelpResponceDto dto=DebrisHelpResponceDto.convertToDto(report);

        return new SuccessDataResult<>(dto);
    }
}
