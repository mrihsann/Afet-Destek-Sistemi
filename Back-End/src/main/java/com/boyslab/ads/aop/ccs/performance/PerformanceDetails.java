package com.boyslab.ads.aop.ccs.performance;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "performance_details")
@Data
public class PerformanceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String className;

    @Column
    private String methodName;

    @Column
    private Long proceedTime;

}
