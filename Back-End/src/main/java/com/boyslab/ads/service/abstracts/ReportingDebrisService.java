package com.boyslab.ads.service.abstracts;

import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.dtos.request.reportingDebris.AddReportingDebrisDSto;
import com.boyslab.ads.dtos.request.reportingDebris.ReportingDebrisDto;
import com.boyslab.ads.dtos.response.reportingDebris.ReportingDebrisResponseDto;
import com.boyslab.ads.entities.ReportingDebris;

import java.util.List;

public interface ReportingDebrisService {

    DataResult<List<ReportingDebrisResponseDto>> GetAll();

    Result add(AddReportingDebrisDSto reportingDebrisDto);

    Result update(ReportingDebrisDto reportingDebrisDto);

    Result delete(int id);

    DataResult<ReportingDebrisResponseDto> getById(int id);

}
