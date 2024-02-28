package com.boyslab.ads.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reporting_debris")

public final class ReportingDebris {

    @Id
    @Column(name = "reporting_debris_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "image_url")
    private String image;

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

    @Column(name = "ekipVarmı")
    private Boolean ekipVarMı;


    @OneToMany(mappedBy = "reportingDebris")
    private List<DebrisHelp> debrisHelps;




}
