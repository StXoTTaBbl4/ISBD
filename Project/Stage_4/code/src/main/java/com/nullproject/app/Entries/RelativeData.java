package com.nullproject.app.Entries;

import jakarta.persistence.*;

@Entity
@Table(name = "relative_data")
public class RelativeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personID")
    private Long personId;

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Column(name = "second_name", nullable = false, length = 32)
    private String secondName;

    @Column(name = "phone_number", length = 12)
    private String phoneNumber;

    @Column(name = "passport_id", nullable = false, length = 10)
    private String passportId;

    @Column(name = "address", length = 64)
    private String address;

    @Column(name = "to_whom_ID", nullable = false)
    private Integer toWhomId;

    // геттеры и сеттеры

}

