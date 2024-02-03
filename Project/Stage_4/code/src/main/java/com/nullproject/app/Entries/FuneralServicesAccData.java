package com.nullproject.app.Entries;

import jakarta.persistence.*;

@Entity(name = "funeral_services_acc_data")
@Table(name = "funeral_services_acc_data", schema = "s262512")
public class FuneralServicesAccData {
    public FuneralServicesAccData(int id, String login, String password, Integer person_id) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.person_id = person_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login", nullable = false, length = 64)
    private String login;

    @Column(name = "password", nullable = false, columnDefinition = "TEXT")
    private String password;

    @Column(name = "personid", nullable = false)
    private Integer person_id;

    public FuneralServicesAccData() {

    }

    // геттеры и сеттеры

    public Integer id() {
        return id;
    }

    public void setId(Integer id) {
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

    @Override
    public String toString() {
        return "FuneralServicesAccData{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", person_id=" + person_id +
                '}';
    }
}

