package com.recipebook.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @JsonIgnore
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable( name = "recipe_book_recipe",
            joinColumns = @JoinColumn( name = "id_recipe" ),
            inverseJoinColumns = @JoinColumn( name = "id_recipe_book" ) )
    private Set<RecipeBook> recipeBooks = new HashSet<>();

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable( name = "recipe_ingredient",
            joinColumns = @JoinColumn( name = "id_recipe" ),
            inverseJoinColumns = @JoinColumn( name = "id_ingredient" ) )
    private Set<Ingredient> Ingredients = new HashSet<>();

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable( name = "utensil_recipe",
            joinColumns = @JoinColumn( name = "id_recipe" ),
            inverseJoinColumns = @JoinColumn( name = "id_utensil" ) )
    private Set<Utensil> Utensils = new HashSet<>();

}
