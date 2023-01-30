package com.recipebook.ws.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "recipe")
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "rating")
    private int rating;

    @Column(name = "preparation_time")
    private int preparationTime;

    @Column(name = "cooking_time")
    private int cookingTime;

    @Column(name = "difficulty")
    private int difficulty;

    @Column(name = "picture")
    private String picture;

    @Column(name = "comment")
    private String comment;

    @Column(name = "steps")
    private int steps;

}
