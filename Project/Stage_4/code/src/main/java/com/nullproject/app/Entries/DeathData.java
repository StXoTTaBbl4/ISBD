package com.nullproject.app.Entries;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "death_data")
public class DeathData {

    @Id
    @Column(name = "body_id", nullable = false)
    private Integer bodyId;

    @Column(name = "date_of_death", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfDeath;

    @Column(name = "description_document_id")
    private Integer descriptionDocumentId;

    // геттеры и сеттеры

}
