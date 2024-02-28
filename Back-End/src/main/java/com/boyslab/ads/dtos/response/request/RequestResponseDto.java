package com.boyslab.ads.dtos.response.request;
import com.boyslab.ads.entities.Request;
import com.boyslab.ads.entities.enums.Status;

public record RequestResponseDto(
        String tc,
        String name,
        String surname,
        int birthDay,
        String description,
        String phone,
        String city,
        String district,
        String neighbourhood,
        String street,
        String locationDescription,
        Status status,
        String categoryName
) {
    public static RequestResponseDto convertToDto(Request request){
        return new RequestResponseDto(
                request.getTc(),
                request.getName(),
                request.getSurname(),
                request.getBirthDay(),
                request.getDescription(),
                request.getPhone(),
                request.getCity(),
                request.getDistrict(),
                request.getNeighbourhood(),
                request.getStreet(),
                request.getLocationDescription(),
                request.getStatus(),
                request.getCategory().getName()
        );
    }

}

