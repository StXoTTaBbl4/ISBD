package com.nullproject.app.Entries;

import jakarta.persistence.*;

@Entity
@Table(name = "worker")
public class Worker {
    public Worker() {
    }

    public Worker(Integer id, String name, String secondName, Boolean isIntern, Integer idOfFacility) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.isIntern = isIntern;
        this.idOfFacility = idOfFacility;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "name", nullable = false, length = 32)
    private String name;

    @Column(name = "second_name", nullable = false, length = 32)
    private String secondName;

    @Column(name = "is_intern", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isIntern;

    @Column(name = "id_of_facility", nullable = false)
    private Integer idOfFacility;

    // геттеры и сеттеры

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Boolean getIntern() {
        return isIntern;
    }

    public void setIntern(Boolean intern) {
        isIntern = intern;
    }

    public Integer getIdOfFacility() {
        return idOfFacility;
    }

    public void setIdOfFacility(Integer idOfFacility) {
        this.idOfFacility = idOfFacility;
    }
}

