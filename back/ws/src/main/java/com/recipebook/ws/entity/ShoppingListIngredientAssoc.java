package com.recipebook.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shopping_list_ingredient")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "shoppingListIngredientPK"})
public class ShoppingListIngredientAssoc {

    @EmbeddedId
    private ShoppingListIngredientPK shoppingListIngredientPK;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "shoppingLists"})
    @JsonUnwrapped
    @ManyToOne
    @MapsId("idIngredient")
    @JoinColumn(name="id_ingredient")
    private Ingredient ingredient;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "ingredients"})
    @ManyToOne
    @MapsId("idShoppingList")
    @JoinColumn(name="id_shopping_list")
    private ShoppingList shoppingList;

    @Column(name = "quantity")
    private int quantity;

}