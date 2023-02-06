package com.recipebook.ws.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "user", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "password")
    private String password;

    @Column(name = "birth")
    private LocalDate birth;

    @Column(name = "email")
    private String email;



}