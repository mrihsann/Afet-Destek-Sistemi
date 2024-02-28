package com.boyslab.ads.service.helpers;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public final class CloudService {
    public String uploadFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("Dosya boş olamaz");
        }

        Storage storage = StorageOptions.getDefaultInstance().getService();
        BlobInfo blobInfo = storage.create(
                BlobInfo.newBuilder("adss-b5b09.appspot.com", Objects.requireNonNull(file.getOriginalFilename())).build(),
                file.getBytes(),
                Storage.BlobTargetOption.predefinedAcl(Storage.PredefinedAcl.PUBLIC_READ)
        );

        return blobInfo.getMediaLink();
    }

}
