package com.nullproject.app.Entries;

import jakarta.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "facility")
public class Facility {
    public Facility() {
    }

    public Facility(Integer id, String address, Integer registrationId, Time workingHoursFrom, Time workingHoursUntil) {
        this.id = id;
        this.address = address;
        this.registrationId = registrationId;
        this.workingHoursFrom = workingHoursFrom;
        this.workingHoursUntil = workingHoursUntil;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "address", nullable = false, length = 64)
    private String address;

    @Column(name = "registration_ID", nullable = false)
    private Integer registrationId;

    @Column(name = "working_hours_from", nullable = false)
    private Time workingHoursFrom;

    @Column(name = "working_hours_until", nullable = false)
    private Time workingHoursUntil;

    // геттеры и сеттеры


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(Integer registrationId) {
        this.registrationId = registrationId;
    }

    public Time getWorkingHoursFrom() {
        return workingHoursFrom;
    }

    public void setWorkingHoursFrom(Time workingHoursFrom) {
        this.workingHoursFrom = workingHoursFrom;
    }

    public Time getWorkingHoursUntil() {
        return workingHoursUntil;
    }

    public void setWorkingHoursUntil(Time workingHoursUntil) {
        this.workingHoursUntil = workingHoursUntil;
    }
}

