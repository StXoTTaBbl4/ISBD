package com.nullproject.app.Entries;

import jakarta.persistence.*;

@Entity
@Table(name = "relative_data")
public class RelativeData {
    public RelativeData() {
    }

    public RelativeData(Integer personId, String name, String secondName, String phoneNumber, String passportId, String address, Integer toWhomId) {
        this.personId = personId;
        this.name = name;
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
        this.passportId = passportId;
        this.address = address;
        this.toWhomId = toWhomId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "personID")
    private Integer personId;

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

}

