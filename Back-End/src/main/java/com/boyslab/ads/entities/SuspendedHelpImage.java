package com.boyslab.ads.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "suspended_help_images")
@Entity
public final class SuspendedHelpImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suspended_help_iamge_id")
    private Integer id;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "suspended_id")
    private SuspendedHelp suspendedHelp;

}
