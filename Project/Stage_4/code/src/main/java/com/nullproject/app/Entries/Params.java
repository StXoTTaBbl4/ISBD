package com.nullproject.app.Entries;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "params")
public class Params {
    public Params() {
    }

    public Params(Integer bodyId, Character sex, BigDecimal height, BigDecimal weight) {
        this.bodyId = bodyId;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }

    @Id
    @Column(name = "body_id", nullable = false)
    private Integer bodyId;

    @Column(name = "sex", length = 1)
    private Character sex;

    @Column(name = "height")
    private BigDecimal height;

    @Column(name = "weight")
    private BigDecimal weight;

    // геттеры и сеттеры

    public Integer getBodyId() {
        return bodyId;
    }

    public void setBodyId(Integer bodyId) {
        this.bodyId = bodyId;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
