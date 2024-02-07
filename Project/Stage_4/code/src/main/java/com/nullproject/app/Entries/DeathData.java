package com.nullproject.app.Entries;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "death_data")
public class DeathData {
    public DeathData() {
    }

    public DeathData(Integer bodyId, Date dateOfDeath, Integer descriptionDocumentId) {
        this.bodyId = bodyId;
        this.dateOfDeath = dateOfDeath;
        this.descriptionDocumentId = descriptionDocumentId;
    }

    @Id
    @Column(name = "body_id", nullable = false)
    private Integer bodyId;

    @Column(name = "date_of_death", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfDeath;

    @Column(name = "description_document_id")
    private Integer descriptionDocumentId;

    // геттеры и сеттеры

    public Integer getBodyId() {
        return bodyId;
    }

    public void setBodyId(Integer bodyId) {
        this.bodyId = bodyId;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Integer getDescriptionDocumentId() {
        return descriptionDocumentId;
    }

    public void setDescriptionDocumentId(Integer descriptionDocumentId) {
        this.descriptionDocumentId = descriptionDocumentId;
    }
}
