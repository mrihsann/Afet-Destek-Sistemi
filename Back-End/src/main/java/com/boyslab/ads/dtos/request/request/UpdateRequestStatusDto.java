package com.boyslab.ads.dtos.request.request;

import com.boyslab.ads.entities.enums.Status;

public record UpdateRequestStatusDto(String tc, Status status) {
}
