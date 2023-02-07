package com.recipebook.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "firstName","lastName","pseudo","password","birth","email"})
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_user")
    private User user;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "recipeBooks"})
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable( name = "recipe_book_recipe",
            joinColumns = @JoinColumn( name = "id_recipe_book" ),
            inverseJoinColumns = @JoinColumn( name = "id_recipe" ) )
    private Set<Recipe> recipes = new HashSet<>();



}