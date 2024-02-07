package com.nullproject.app.Entries;

import jakarta.persistence.*;

@Entity
@Table(name = "procedures")
public class Procedure {
    public Procedure() {
    }

    public Procedure(Integer procedureId, Integer bodyId, String note, Integer pathologist1Id, Integer pathologist2Id, Integer internId) {
        this.procedureId = procedureId;
        this.bodyId = bodyId;
        this.note = note;
        this.pathologist1Id = pathologist1Id;
        this.pathologist2Id = pathologist2Id;
        this.internId = internId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "procedure_id")
    private Integer procedureId;

    @Column(name = "body_id", nullable = false)
    private Integer bodyId;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "pathologist_1_id", nullable = false)
    private Integer pathologist1Id;

    @Column(name = "pathologist_2_id", nullable = false)
    private Integer pathologist2Id;

    @Column(name = "intern_id")
    private Integer internId = null;

    // геттеры и сеттеры


    public Integer getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(Integer procedureId) {
        this.procedureId = procedureId;
    }

    public Integer getBodyId() {
        return bodyId;
    }

    public void setBodyId(Integer bodyId) {
        this.bodyId = bodyId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getPathologist1Id() {
        return pathologist1Id;
    }

    public void setPathologist1Id(Integer pathologist1Id) {
        this.pathologist1Id = pathologist1Id;
    }

    public Integer getPathologist2Id() {
        return pathologist2Id;
    }

    public void setPathologist2Id(Integer pathologist2Id) {
        this.pathologist2Id = pathologist2Id;
    }

    public Integer getInternId() {
        return internId;
    }

    public void setInternId(Integer internId) {
        this.internId = internId;
    }
}
