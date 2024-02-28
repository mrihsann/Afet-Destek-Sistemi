package com.boyslab.ads.entities;

import com.boyslab.ads.entities.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_requests")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class Request {

    @Id
    @Column(name = "tc_number")
    private String tc;

    @Column(name = "name")
    private String name;


    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_day")
    private  int birthDay;

    @Column(name = "description")
    private String description;

    @Column(name = "phone_number")
    private String phone;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "neighbourhood")
    private String neighbourhood;

    @Column(name = "street")
    private String street;

    @Column(name = "location_description")
    private String locationDescription;


    @Column(name = "status")
    private Status status;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
