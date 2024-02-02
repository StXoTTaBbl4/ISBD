package com.nullproject.app.Entries;

import jakarta.persistence.*;

@Entity
@Table(name = "funeral_services_acc_data")
public class FuneralServicesAccData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "login", nullable = false, length = 64)
    private String login;

    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;

    @Column(name = "personid", nullable = false)
    private Integer person_id;

    // геттеры и сеттеры

    public Long id() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String login() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String password() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer person_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }
}

