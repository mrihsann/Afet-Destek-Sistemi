package com.boyslab.ads.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "suspended_helps")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class SuspendedHelp {
    @Id
    @Column(name = "suspended_id")
    private Integer id;
    @Column(name = "phone_number")
    private String phoneNumber;

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

    @Column(name = "title")
    private String title; //admin panelinden girilecek

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "suspendedHelp", cascade = CascadeType.ALL)
    private List<SuspendedHelpImage> images;

}
