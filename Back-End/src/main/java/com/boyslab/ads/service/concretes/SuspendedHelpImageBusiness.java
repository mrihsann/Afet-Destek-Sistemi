package com.boyslab.ads.service.concretes;

import com.boyslab.ads.core.exceptions.BusinessException;
import com.boyslab.ads.core.result.DataResult;
import com.boyslab.ads.core.result.Result;
import com.boyslab.ads.core.result.SuccessDataResult;
import com.boyslab.ads.core.result.SuccessResult;
import com.boyslab.ads.dataAccess.SuspendedHelpImageRepository;
import com.boyslab.ads.dtos.request.suspendedHelpImage.AddSuspendedHelpImageRequest;
import com.boyslab.ads.dtos.response.suspendedHelpImage.SuspendedHelpImageResponse;
import com.boyslab.ads.entities.SuspendedHelpImage;
import com.boyslab.ads.service.abstracts.SuspendedHelpImageService;
import com.boyslab.ads.service.helpers.CloudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.boyslab.ads.service.Messages.imageDeleted;
import static com.boyslab.ads.service.Messages.suspendedHelpImageNotFound;

@Service
@RequiredArgsConstructor
public  class SuspendedHelpImageBusiness implements SuspendedHelpImageService {

    private final SuspendedHelpImageRepository repository;
    private final CloudService cloudService;
    @Override
    public Result add(MultipartFile file, AddSuspendedHelpImageRequest request) throws IOException {

        String uploadUrl =cloudService.uploadFile(file);
        var image = AddSuspendedHelpImageRequest.convertToEntity(request);
        image.setImageUrl(uploadUrl);
        this.repository.save(image);

        return new SuccessResult();
    }

    @Override
    public DataResult<List<SuspendedHelpImageResponse>> getAllImagesBySuspendedId(int suspendedId) {

        var images = this.repository.findAllBySuspendedHelp_Id(suspendedId);

        var response = images.stream()
                .map(SuspendedHelpImageResponse::convertToResponse)
                .toList();

        return new SuccessDataResult<>(response);
    }

    @Override
    public Result delete(int imageId) {
        SuspendedHelpImage image = this.repository.findById(imageId).orElseThrow(()-> new BusinessException(suspendedHelpImageNotFound));

        this.repository.delete(image);
        return new SuccessResult(imageDeleted);
    }
}
