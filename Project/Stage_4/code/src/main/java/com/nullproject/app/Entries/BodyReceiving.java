package com.nullproject.app.Entries;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "body_receiving")
public class BodyReceiving {

    public BodyReceiving() {
    }

    public BodyReceiving(Integer id, String facilityAddress, Date receivingDate, String receiverName, String receiverSecondName, Integer receiverId, String receiverPhoneNumber, String bodyTreatmentType, Integer graveyardOrderId) {
        this.id = id;
        this.facilityAddress = facilityAddress;
        this.receivingDate = receivingDate;
        this.receiverName = receiverName;
        this.receiverSecondName = receiverSecondName;
        this.receiverId = receiverId;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.bodyTreatmentType = bodyTreatmentType;
        this.graveyardOrderId = graveyardOrderId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFacilityAddress() {
        return facilityAddress;
    }

    public void setFacilityAddress(String facilityAddress) {
        this.facilityAddress = facilityAddress;
    }

    public Date getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverSecondName() {
        return receiverSecondName;
    }

    public void setReceiverSecondName(String receiverSecondName) {
        this.receiverSecondName = receiverSecondName;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public void setReceiverPhoneNumber(String receiverPhoneNumber) {
        this.receiverPhoneNumber = receiverPhoneNumber;
    }

    public String getBodyTreatmentType() {
        return bodyTreatmentType;
    }

    public void setBodyTreatmentType(String bodyTreatmentType) {
        this.bodyTreatmentType = bodyTreatmentType;
    }

    public Integer getGraveyardOrderId() {
        return graveyardOrderId;
    }

    public void setGraveyardOrderId(Integer graveyardOrderId) {
        this.graveyardOrderId = graveyardOrderId;
    }
}

