package com.recipebook.ws.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Embeddable
public class StockIngredientPK {
    @Column(name = "id_ingredient", nullable = false)
    private int idIngredient;

    @Column(name = "id_stock", nullable = false)
    private int idStock;

}