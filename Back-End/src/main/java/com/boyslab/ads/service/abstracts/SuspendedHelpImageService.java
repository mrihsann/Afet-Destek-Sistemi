package com.boyslab.ads.service.abstracts;

import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.dtos.request.suspendedHelpImage.AddSuspendedHelpImageRequest;
import com.boyslab.ads.dtos.response.suspendedHelpImage.SuspendedHelpImageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SuspendedHelpImageService {
    Result add(MultipartFile file,AddSuspendedHelpImageRequest request) throws IOException;

    DataResult<List<SuspendedHelpImageResponse>> getAllImagesBySuspendedId(int suspendedId);

    Result delete(int imageId);
}
