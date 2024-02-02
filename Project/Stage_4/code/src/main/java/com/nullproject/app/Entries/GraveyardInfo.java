package com.nullproject.app.Entries;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "graveyard_info")
public class GraveyardInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "address", nullable = false, length = 64)
    private String address;

    @Column(name = "funeral_date")
    @Temporal(TemporalType.DATE)
    private Date funeralDate;

    @Column(name = "plot_number")
    private Integer plotNumber;

    @Column(name = "body_id", nullable = false)
    private Integer bodyId;

    // геттеры и сеттеры

}

