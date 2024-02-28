package com.boyslab.ads.service.abstracts;

import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.dtos.request.debrisHelp.DebrisHelpDto;
import com.boyslab.ads.dtos.response.debirsHelp.DebrisHelpResponceDto;


import java.util.List;

public interface DebrisHelpService  {

    DataResult<List<DebrisHelpResponceDto>> GetAll();


    Result add(DebrisHelpDto debrisHelpDto);

    Result delete(int debrisID);

    Result update(DebrisHelpDto debrisHelpDto);

    DataResult<DebrisHelpResponceDto > GetById(int debrisId);

}
