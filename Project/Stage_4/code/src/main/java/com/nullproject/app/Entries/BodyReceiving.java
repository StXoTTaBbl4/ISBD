package com.nullproject.app.Entries;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "body_reciving")
public class BodyReceiving {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "facility_address", nullable = false, length = 64)
    private String facilityAddress;

    @Column(name = "receiving_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivingDate;

    @Column(name = "receiver_name", length = 32)
    private String receiverName;

    @Column(name = "receiver_second_name", nullable = false, length = 32)
    private String receiverSecondName;

    @Column(name = "receiver_ID", nullable = false)
    private Integer receiverId;

    @Column(name = "receiver_phone_number", length = 12)
    private String receiverPhoneNumber;

    @Column(name = "body_treatment_type", columnDefinition = "TEXT")
    private String bodyTreatmentType;

    @Column(name = "graveyard_order_ID", nullable = false)
    private Integer graveyardOrderId;

    // геттеры и сеттеры

}

