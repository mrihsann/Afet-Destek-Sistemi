package com.boyslab.ads.controller;

import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.dtos.request.request.RequestDto;
import com.boyslab.ads.dtos.request.request.UpdateRequestStatusDto;
import com.boyslab.ads.dtos.response.request.RequestDetailDto;
import com.boyslab.ads.dtos.response.request.RequestResponseDto;
import com.boyslab.ads.entities.enums.Status;
import com.boyslab.ads.service.abstracts.RequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/requests/")
@RestController
@RequiredArgsConstructor
public final class RequestController extends BaseController{

    private final RequestService requestService;

    @GetMapping("getall")
    public ResponseEntity<DataResult<List<RequestResponseDto>>> getAll(){

        var result = this.requestService.GetAll();
        return responseData(result);
    }


    @PostMapping("add")
    public ResponseEntity<Result> add(@Valid @RequestBody RequestDto dto) throws Exception {
        var result = this.requestService.add(dto);
        return responseNoData(result);
    }

    @GetMapping("getdetails")
    public ResponseEntity<Result> getDetails(){
        var result = this.requestService.getAllDetails();
        return responseData(result);
    }

    @PostMapping("update")
    public ResponseEntity<Result> update(@Valid @RequestBody RequestDto dto){
        var result = this.requestService.update(dto);
        return responseNoData(result);
    }
    @DeleteMapping("delete/{tc}")
    public ResponseEntity<Result> delete(@PathVariable("tc") String tc){

        var result = this.requestService.delete(tc);
        return responseNoData(result);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<DataResult<RequestResponseDto>> getById(@PathVariable("tc") String tc){
        var result = this.requestService.getByTc(tc);
        return responseData(result);
    }
    @PutMapping("updatestatus")
    public ResponseEntity<Result> updateStatus(@Valid @RequestBody UpdateRequestStatusDto dto){
        var result = this.requestService.updateStatus(dto);
        return responseNoData(result);
    }

    @GetMapping("getallbystatus")
    public ResponseEntity<DataResult<List<RequestResponseDto>>> getAllByStatus(@RequestParam Status status){
        var result = this.requestService.getAllByStatus(status);
        return  responseData(result);
    }

    @GetMapping("getdetails/{id}")
    public ResponseEntity<DataResult<RequestDetailDto>> getDetailsByCategoryId(@PathVariable("id") int id){

        var result = this.requestService.getAllDetailsByCategoryId(id);
        return responseData(result);
    }

}
