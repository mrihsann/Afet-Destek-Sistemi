package com.boyslab.ads.dtos.request.suspendedHelpImage;

import com.boyslab.ads.entities.SuspendedHelp;
import com.boyslab.ads.entities.SuspendedHelpImage;

public record AddSuspendedHelpImageRequest(
        int suspendedHelpId
) {
    public static SuspendedHelpImage convertToEntity(AddSuspendedHelpImageRequest request){
        SuspendedHelp suspendedHelp = new SuspendedHelp();
        suspendedHelp.setId(request.suspendedHelpId);
        SuspendedHelpImage image = new SuspendedHelpImage();
        image.setSuspendedHelp(suspendedHelp);
        return image;
    }

}
