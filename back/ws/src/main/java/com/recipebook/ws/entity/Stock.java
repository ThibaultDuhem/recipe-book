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
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_user")
    private User user;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "stocks"})
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable( name = "stock_ingredient",
            joinColumns = @JoinColumn( name = "id_stock" ),
            inverseJoinColumns = @JoinColumn( name = "id_ingredient" ) )
    private Set<Ingredient> Ingredients = new HashSet<>();


}