package com.boyslab.ads.service.abstracts;

import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.dtos.request.request.RequestDto;
import com.boyslab.ads.dtos.request.request.UpdateRequestStatusDto;
import com.boyslab.ads.dtos.response.request.RequestDetailDto;
import com.boyslab.ads.dtos.response.request.RequestResponseDto;
import com.boyslab.ads.entities.enums.Status;


import java.util.List;

public interface RequestService {
   DataResult<List<RequestResponseDto>> GetAll();

   Result add(RequestDto requestDto) throws Exception;

   Result update (RequestDto requestDto);

   Result delete(String  tc);


   DataResult<List<RequestDetailDto>> getAllDetailsByCategoryId(int categoryId);

   Result updateStatus(UpdateRequestStatusDto dto);

   DataResult<List<RequestResponseDto>> getAllByStatus(Status status);

   DataResult<List<RequestDetailDto>> getAllDetails();

   DataResult<RequestResponseDto> getByTc(String tc);


}
