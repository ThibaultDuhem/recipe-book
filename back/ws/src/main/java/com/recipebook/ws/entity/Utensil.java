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
@Table(name = "utensil")
public class Utensil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "picture")
    private String picture;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "utensils"})
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable( name = "utensil_recipe",
            joinColumns = @JoinColumn( name = "id_utensil" ),
            inverseJoinColumns = @JoinColumn( name = "id_recipe" ) )
    private Set<Recipe> recipes = new HashSet<>();

}