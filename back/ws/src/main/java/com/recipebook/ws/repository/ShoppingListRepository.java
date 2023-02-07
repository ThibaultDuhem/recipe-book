package com.recipebook.ws.repository;

import com.recipebook.ws.entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Integer> {
    ShoppingList findById(int id);
}