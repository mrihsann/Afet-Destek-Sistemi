package com.boyslab.ads.dtos.request.request;

import com.boyslab.ads.aop.aspects.validation.request.MernisValidator;
import com.boyslab.ads.aop.aspects.validation.request.TcController;
import com.boyslab.ads.entities.Category;
import com.boyslab.ads.entities.Request;
import com.boyslab.ads.entities.enums.Status;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


@MernisValidator
public record RequestDto(
        @TcController
        @NotNull(message = "Tc alanı boş olamaz.")
        String tc,

        @NotNull(message = "İsim alanı boş olamaz.")
        String name,

        @NotNull(message = "Soyisim alanı boş olamaz.")
        String surname,

        @NotNull(message = "Doğum yılı boş olamaz.")
        @Min(value = 0,message = "Doğum yılı negatif olamaz")
        int birthDay,

        @NotNull(message = "Açıklama alanı boş bırakılamaz")
        String description,

        @NotNull(message = "Telefon numarası alanı boş bırakılamaz")
        String phone,

        @NotNull(message = "Şehir alanı boş bırakılamaz.")
        String city,

        @NotNull(message = "İlçe alanı boş bırakılamaz.")
        String district,

        @NotNull(message = "Mahalle alanı boş bırakılamaz.")
        String neighbourhood,
        @NotNull(message = "Cadde alanı boş bırakılamaz")
        String street,

        String locationDescription,

        @NotNull(message = "Kategori alanı boş bırakılamaz.")
        int categoryId
        ) {
    public static Request convertToEntity(RequestDto dto){
        Category category = new Category();
        category.setId(dto.categoryId);
        Request request = new Request();
        request.setName(dto.name);
        request.setDescription(dto.description);
        request.setCity(dto.city);
        request.setDistrict(dto.district);
        request.setPhone(dto.phone);
        request.setBirthDay(dto.birthDay);
        request.setSurname(dto.surname);
        request.setNeighbourhood(dto.neighbourhood);
        request.setStreet(dto.street);
        request.setStatus(Status.IN_PROGGRESS);
        request.setCategory(category);
        request.setLocationDescription(dto.locationDescription);
        request.setTc(dto.tc);

        return request;

    }

}
