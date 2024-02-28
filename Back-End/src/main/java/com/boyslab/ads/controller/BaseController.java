package com.boyslab.ads.controller;

import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import org.springframework.http.ResponseEntity;

public class BaseController {

    public  ResponseEntity<Result> responseNoData(Result result){
        if (result.isSuccess()){
            return ResponseEntity.ok().body(result);
        }
        else {
            return ResponseEntity.badRequest().body(result);
        }

    }

    public  ResponseEntity responseData(DataResult dataResult){
        if (dataResult.isSuccess()){
            return ResponseEntity.ok().body(dataResult);
        }
        else return ResponseEntity.badRequest().body(dataResult);
    }


}
