package com.recipebook.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

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

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "recipes"})
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable( name = "recipe_book_recipe",
            joinColumns = @JoinColumn( name = "id_recipe" ),
            inverseJoinColumns = @JoinColumn( name = "id_recipe_book" ) )
    private Set<RecipeBook> recipeBooks = new HashSet<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "recipes"})
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable( name = "utensil_recipe",
            joinColumns = @JoinColumn( name = "id_recipe" ),
            inverseJoinColumns = @JoinColumn( name = "id_utensil" ) )
    private Set<Utensil> utensils = new HashSet<>();

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "firstName","lastName","pseudo","password","birth","email"})
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_user")
    private User user;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "recipe"})
    @OneToMany(mappedBy = "recipe")
    private Set<RecipeIngredientAssoc> ingredients = new HashSet<>();

}
