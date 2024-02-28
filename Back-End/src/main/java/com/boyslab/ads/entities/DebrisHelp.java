package com.boyslab.ads.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "debris_help")
public final class DebrisHelp {
    //todo: Reporting Debris id si bağlanacak.



    @Id
    @Column(name = "debris_id")
    private int debrisId;

    @ManyToOne
    @JoinColumn(name = "reporting_debris_id")
    private  ReportingDebris reportingDebris;

    @Column(name = "helper_name")
    private String name;

    @Column(name = "helper_surname")
    private String surname;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "helper_city")
    private String city;

    @Column(name = "helper_district")
    private String district;

    @Column(name = "numberOfTeam")
    private int numberOfTeam;

    @Column(name = "helper_equipment")
    private String equipment;

    @Column(name = "helper_decription")
    private String description;

}
