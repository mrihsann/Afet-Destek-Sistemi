package com.boyslab.ads.dtos.request.reportingDebris;

import com.boyslab.ads.entities.ReportingDebris;
import jakarta.validation.constraints.NotNull;

public record AddReportingDebrisDSto(
        @NotNull(message = "Telefon numarası alanı boş olamaz")
        String phoneNumber,

        @NotNull(message = "Lütfen resim yükleyiniz.")
        String imageUrl,

        @NotNull(message = "Şehir alanı boş bırakılamaz.")
        String city,
        @NotNull(message = "İlçe alanı boş bıraklılamaz.")
        String district,

        @NotNull(message = "Mahalle alanı boş bırakılamaz.")
        String neighbourhood,

        @NotNull(message = "Cadde Alanı boş bırakılamazmaz")
        String street,


        String locationDescription,

        @NotNull(message = "Ekip alanı boş bırakılamaz.")
        Boolean ekipVarMı
) {
    public static ReportingDebris convertToEntity(AddReportingDebrisDSto dto){

        ReportingDebris reportingDebris=new ReportingDebris();
        reportingDebris.setPhoneNumber(dto.phoneNumber);
        reportingDebris.setImage(dto.imageUrl);
        reportingDebris.setCity(dto.city);
        reportingDebris.setDistrict(dto.district);
        reportingDebris.setNeighbourhood(dto.neighbourhood);
        reportingDebris.setStreet(dto.street);
        reportingDebris.setLocationDescription(dto.locationDescription);
        reportingDebris.setEkipVarMı(dto.ekipVarMı);


        return reportingDebris;
    }
}