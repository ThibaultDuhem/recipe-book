package com.recipebook.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recipe_ingredient")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "recipeIngredientPK"})
public class RecipeIngredientAssoc {

    @EmbeddedId
    private RecipeIngredientPK recipeIngredientPK;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "recipes"})
    @JsonUnwrapped
    @ManyToOne
    @MapsId("idIngredient")
    @JoinColumn(name="id_ingredient")
    private Ingredient ingredient;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "ingredients"})
    @ManyToOne
    @MapsId("idRecipe")
    @JoinColumn(name="id_recipe")
    private Recipe recipe;

    @Column(name = "quantity")
    private int quantity;

}