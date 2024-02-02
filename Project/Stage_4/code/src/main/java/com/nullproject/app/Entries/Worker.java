package com.nullproject.app.Entries;

import jakarta.persistence.*;

@Entity
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Column(name = "second_name", nullable = false, length = 32)
    private String secondName;

    @Column(name = "is_intern", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isIntern;

    @Column(name = "id_of_facility", nullable = false)
    private Integer idOfFacility;

    // геттеры и сеттеры

}

