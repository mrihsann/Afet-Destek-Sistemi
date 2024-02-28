package com.boyslab.ads.dtos.response.suspendedHelpImage;

import com.boyslab.ads.entities.SuspendedHelpImage;

public record SuspendedHelpImageResponse(
        int id,
        String imageUrl,
        String title
) {

    public static SuspendedHelpImageResponse convertToResponse(SuspendedHelpImage image){
        return new SuspendedHelpImageResponse(
                image.getId(),
                image.getImageUrl(),
                image.getSuspendedHelp().getTitle()
        );
    }

}
