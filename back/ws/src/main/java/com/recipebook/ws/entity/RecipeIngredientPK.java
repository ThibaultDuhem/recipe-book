package com.recipebook.ws.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Embeddable
public class RecipeIngredientPK {
    @Column(name = "id_ingredient", nullable = false)
    private int idIngredient;

    @Column(name = "id_recipe", nullable = false)
    private int idRecipe;

}