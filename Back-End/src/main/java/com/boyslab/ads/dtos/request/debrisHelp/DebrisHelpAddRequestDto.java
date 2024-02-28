package com.boyslab.ads.dtos.request.debrisHelp;
import com.boyslab.ads.entities.DebrisHelp;
import com.boyslab.ads.entities.ReportingDebris;

public  record DebrisHelpAddRequestDto(

        String name,

        String surname,

        String phoneNumber,

        String city,

        String district,

        int numberOfTeam,

        String equipment,

        String description,
        int reportingDebrisId
)
{
    public static DebrisHelp convertToEntity(DebrisHelpAddRequestDto dto){
        DebrisHelp debrisHelp=new DebrisHelp();
        ReportingDebris reportingDebris = new ReportingDebris();

        reportingDebris.setId(dto.reportingDebrisId);
        debrisHelp.setReportingDebris(reportingDebris);

        debrisHelp.setName(dto.name);

        debrisHelp.setSurname(dto.surname);

        debrisHelp.setPhoneNumber(dto.phoneNumber);

        debrisHelp.setCity(dto.city);

        debrisHelp.setDistrict(dto.district);

        debrisHelp.setNumberOfTeam(dto.numberOfTeam);

        debrisHelp.setEquipment(dto.equipment);

        debrisHelp.setDescription(dto.description);

        return debrisHelp;

    }

}
