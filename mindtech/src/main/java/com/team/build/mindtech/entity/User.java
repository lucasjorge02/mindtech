package com.team.build.mindtech.entity;

import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome", nullable = false, length = 60)
    private String name;

    @Column(name = "sobrenome", nullable = false, length = 60)
    private String surname;

    @Column(nullable = false, unique = true, length = 80)
    private String email;

    @Column(name = "senha", nullable = false, length = 45)
    private String password;

    public User() {
    }

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}