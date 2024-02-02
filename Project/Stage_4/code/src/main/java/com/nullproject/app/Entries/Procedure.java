package com.nullproject.app.Entries;

import jakarta.persistence.*;

@Entity
@Table(name = "procedures")
public class Procedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "procedure_id")
    private Long procedureId;

    @Column(name = "body_id", nullable = false)
    private Integer bodyId;

    @Column(name = "note", columnDefinition = "TEXT")
    private String note;

    @Column(name = "pathologist_1_id", nullable = false)
    private Integer pathologist1Id;

    @Column(name = "pathologist_2_id", nullable = false)
    private Integer pathologist2Id;

    @Column(name = "intern_id")
    private Integer internId;

    // геттеры и сеттеры

}
