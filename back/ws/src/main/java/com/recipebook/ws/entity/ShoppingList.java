package com.recipebook.ws.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "shopping_list")
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable( name = "shopping_list_ingredient",
            joinColumns = @JoinColumn( name = "id_shopping_list" ),
            inverseJoinColumns = @JoinColumn( name = "id_ingredient" ) )
    private Set<Ingredient> Ingredients = new HashSet<>();


}