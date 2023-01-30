package com.recipebook.ws.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "recipe_book")
@Table(name = "recipe_book")

public class RecipeBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "name")
    private String name;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "modification_date")
    private LocalDate modificationDate;

    @Column(name = "author")
    private int author;

    @OneToMany//(fetch = FetchType.LAZY)
    @JoinTable( name = "recipe_book_recipe",
            joinColumns = @JoinColumn( name = "id_recipe_book" ),
            inverseJoinColumns = @JoinColumn( name = "id_recipe" ) )
    private List<Recipe> recipes = new ArrayList<>();

}