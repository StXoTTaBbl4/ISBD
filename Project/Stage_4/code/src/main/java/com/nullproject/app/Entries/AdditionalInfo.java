package com.nullproject.app.Entries;

import jakarta.persistence.*;

@Entity
@Table(name = "additional_info")
public class AdditionalInfo {

    @Id
    @Column(name = "bodyID", nullable = false)
    private Integer bodyId;

    @Column(name = "work_name", columnDefinition = "TEXT")
    private String workName;

    @Column(name = "address", length = 64)
    private String address;

    @Column(name = "contact_info", columnDefinition = "TEXT")
    private String contactInfo;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    // геттеры и сеттеры

}

