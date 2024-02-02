package com.nullproject.app.Entries;

import jakarta.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "facility")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "address", nullable = false, length = 64)
    private String address;

    @Column(name = "registration_ID", nullable = false)
    private Integer registrationId;

    @Column(name = "working_hours_from", nullable = false)
    private Time workingHoursFrom;

    @Column(name = "working_hours_until", nullable = false)
    private Time workingHoursUntil;

    // геттеры и сеттеры

}

