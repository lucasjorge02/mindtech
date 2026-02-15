package com.team.build.mindtech.model.entity;

import com.team.build.mindtech.model.request.CreateUserRequest;
import jakarta.persistence.*;

@Entity
@Table(name="usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, name = "nome")
    private String name;

    @Column(nullable = false, name = "sobrenome")
    private String surname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, name = "senha")
    private String password;

    public User() {
    }

    public User(    String name, String surname, String email, String password) {
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
