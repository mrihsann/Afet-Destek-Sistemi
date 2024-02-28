package com.boyslab.ads.dtos.response.reportingDebris;

import com.boyslab.ads.dtos.request.reportingDebris.ReportingDebrisDto;
import com.boyslab.ads.entities.ReportingDebris;

public record ReportingDebrisResponseDto(
        Integer id,
        String phoneNumber,
        String imageUrl,
        String city,
        String district,
        String neighbourhood,
        String street,
        String locationDescription,
        Boolean ekipVarMı
) {
    public static ReportingDebrisResponseDto convertToDto(ReportingDebris reportingDebris){
        return new ReportingDebrisResponseDto(
                reportingDebris.getId(),
                reportingDebris.getPhoneNumber(),
                reportingDebris.getImage(),
                reportingDebris.getCity(),
                reportingDebris.getDistrict(),
                reportingDebris.getNeighbourhood(),
                reportingDebris.getStreet(),
                reportingDebris.getLocationDescription(),
                reportingDebris.getEkipVarMı()
        );
    }
}
