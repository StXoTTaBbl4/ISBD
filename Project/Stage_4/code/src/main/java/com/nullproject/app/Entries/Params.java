package com.nullproject.app.Entries;

import jakarta.persistence.*;

@Entity
@Table(name = "params")
public class Params {

    @Id
    @Column(name = "body_id", nullable = false)
    private Integer bodyId;

    @Column(name = "sex", length = 1)
    private String sex;

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    // геттеры и сеттеры

}
