package com.boyslab.ads.controller;

import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.dtos.request.reportingDebris.AddReportingDebrisDSto;
import com.boyslab.ads.dtos.request.reportingDebris.ReportingDebrisDto;
import com.boyslab.ads.dtos.response.reportingDebris.ReportingDebrisResponseDto;
import com.boyslab.ads.service.abstracts.ReportingDebrisService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/debris/")
@RestController
@RequiredArgsConstructor
public final class ReportingDebrisController  extends BaseController{


    private  final ReportingDebrisService service;


    @PostMapping("add")
    public ResponseEntity<Result> add(@Valid @RequestBody AddReportingDebrisDSto dto){

    var result = this.service.add(dto);
    return responseNoData(result);
}


    @PostMapping("update")
    public ResponseEntity<Result> update(@Valid @RequestBody ReportingDebrisDto dto){

        var result = this.service.update(dto);
        return responseNoData(result);
    }

    @GetMapping("getall")
    public ResponseEntity<DataResult<List<ReportingDebrisResponseDto>>> getall(){
        var result = this.service.GetAll();

        return responseData(result);

    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") int id){
        var result = this.service.delete(id);
        return responseNoData(result);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<DataResult<ReportingDebrisResponseDto>> getById(@PathVariable("id") int id){
        var result = this.service.getById(id);
        return responseData(result);
    }



}
