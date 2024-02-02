package com.nullproject.app.Entries;

import jakarta.persistence.*;

@Entity
@Table(name = "personal_data")
public class PersonalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Column(name = "second_name", nullable = false, length = 32)
    private String secondName;

    @Column(name = "phone_number", length = 12)
    private String phoneNumber;

    @Column(name = "passport_id", nullable = false, length = 10)
    private String passportId;

    // геттеры и сеттеры

}

