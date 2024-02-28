package com.boyslab.ads.controller;

import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.dtos.request.suspendedHelpImage.AddSuspendedHelpImageRequest;
import com.boyslab.ads.service.abstracts.SuspendedHelpImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/suspended-image/")
@RequiredArgsConstructor
public final class SuspendedHelpImageController extends BaseController {

    private final SuspendedHelpImageService service;


/*    @PostMapping("add")
    public ResponseEntity<Result> add(@RequestParam("file") MultipartFile file , @ModelAttribute AddSuspendedHelpImageRequest request) throws IOException {
        var response = this.service.add(file,request);
        return responseNoData(response);
    }*/


    @PostMapping("add")
    public ResponseEntity<Result> add(@RequestParam("file") MultipartFile file) throws IOException {
        var response = this.service.add(file,new AddSuspendedHelpImageRequest(1));
        return responseNoData(response);
    }
}
