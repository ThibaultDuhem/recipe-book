package com.recipebook.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "firstName","lastName","pseudo","password","birth","email"})
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_user")
    private User user;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "shoppingList"})
    @OneToMany(mappedBy = "shoppingList")
    private Set<ShoppingListIngredientAssoc> ingredients = new HashSet<>();


}