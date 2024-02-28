package com.boyslab.ads.dtos.response.debirsHelp;

import com.boyslab.ads.dtos.response.reportingDebris.ReportingDebrisResponseDto;
import com.boyslab.ads.entities.DebrisHelp;

public record DebrisHelpResponceDto(
        int debrisID,

        String name,

        String surname,

        String city,

        String district,

        int numberOfTeam,

        String equipment,

        String description
) {

    public static DebrisHelpResponceDto convertToDto(DebrisHelp debrisHelp){
        return new DebrisHelpResponceDto(
                debrisHelp.getDebrisId(),
                debrisHelp.getName(),
                debrisHelp.getSurname(),
                debrisHelp.getCity(),
                debrisHelp.getDistrict(),
                debrisHelp.getNumberOfTeam(),
                debrisHelp.getEquipment(),
                debrisHelp.getDescription()
        );

    }
}
