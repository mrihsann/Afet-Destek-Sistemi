package com.boyslab.ads.controller;

import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.dtos.request.debrisHelp.DebrisHelpDto;
import com.boyslab.ads.dtos.response.debirsHelp.DebrisHelpResponceDto;
import com.boyslab.ads.service.abstracts.DebrisHelpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/debrishelp/")
@RequiredArgsConstructor
public final class DebrisHelpController extends BaseController {

    private final DebrisHelpService service;

    @GetMapping("getall")
    public ResponseEntity<DataResult<List<DebrisHelpResponceDto>>> getAll(){

        var response = service.GetAll();

        return  responseData(response);
    }

    @PostMapping("add")
    public ResponseEntity<Result> add(@RequestBody DebrisHelpDto dto){

        var response = service.add(dto);
        return responseNoData(response);

    }

    @PostMapping("delete/{id}")
    public ResponseEntity<Result> delete(@PathVariable("id") int id){

        var response = service.delete(id);
        return responseNoData(response);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<DataResult<DebrisHelpResponceDto>> getById(@PathVariable("id") int id){
        var response = service.GetById(id);
        return responseData(response);
    }

}
