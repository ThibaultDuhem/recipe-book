package com.recipebook.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "picture")
    private String picture;

    @Column(name = "average_price")
    private int averagePrice;

    @Column(name = "description")
    private String description;


    @JsonIgnore
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable( name = "recipe_ingredient",
            joinColumns = @JoinColumn( name = "id_ingredient" ),
            inverseJoinColumns = @JoinColumn( name = "id_recipe" ) )
    private Set<Recipe> recipes = new HashSet<>();

    @JsonIgnore
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable( name = "shopping_list_ingredient",
            joinColumns = @JoinColumn( name = "id_ingredient" ),
            inverseJoinColumns = @JoinColumn( name = "id_shopping_list" ) )
    private Set<ShoppingList> shoppingLists = new HashSet<>();

    @JsonIgnore
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable( name = "stock_ingredient",
            joinColumns = @JoinColumn( name = "id_ingredient" ),
            inverseJoinColumns = @JoinColumn( name = "id_stock" ) )
    private Set<Stock> stocks = new HashSet<>();


}

