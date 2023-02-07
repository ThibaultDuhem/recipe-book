package com.recipebook.ws.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "stock_ingredient")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "stockIngredientPK"})
public class StockIngredientAssoc {

    @EmbeddedId
    private StockIngredientPK stockIngredientPK;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "stocks"})
    @JsonUnwrapped
    @ManyToOne
    @MapsId("idIngredient")
    @JoinColumn(name="id_ingredient")
    private Ingredient ingredient;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "ingredients"})
    @ManyToOne
    @MapsId("idStock")
    @JoinColumn(name="id_stock")
    private Stock stock;

    @Column(name = "quantity")
    private int quantity;

}