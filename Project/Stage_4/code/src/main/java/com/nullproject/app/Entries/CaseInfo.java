package com.nullproject.app.Entries;

import jakarta.persistence.*;

@Entity
@Table(name = "case_info")
public class CaseInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "responsible_person_name", nullable = false, length = 64)
    private String responsiblePersonName;

    @Column(name = "bodyID", nullable = false)
    private Integer bodyId;

    @Column(name = "address", nullable = false, length = 64)
    private String address;

    @Column(name = "procedureID", nullable = false)
    private Integer procedureId;

    // геттеры и сеттеры

}

