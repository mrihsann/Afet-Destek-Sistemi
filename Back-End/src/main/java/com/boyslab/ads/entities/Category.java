package com.boyslab.ads.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "description")
    private  String description;

    @OneToMany(mappedBy = "category")
    private List<Request> requests;

    @OneToMany(mappedBy = "category")
    private List<SuspendedHelp> suspendedHelps;



}
