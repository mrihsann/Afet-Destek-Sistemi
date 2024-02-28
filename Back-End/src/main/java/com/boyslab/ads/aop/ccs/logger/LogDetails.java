package com.boyslab.ads.aop.ccs.logger;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "log_details")
public class LogDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private int id;

    @Column
    @Enumerated(EnumType.STRING)
    private LogStatus logStatus;

    @Column
    private String parameters;

    @Column
    private String methodName;

    @Column
    private Date logDate;

    @Column
    private String returnValue;
}
