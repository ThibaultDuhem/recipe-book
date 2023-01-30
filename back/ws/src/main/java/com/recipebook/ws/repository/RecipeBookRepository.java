package com.recipebook.ws.repository;

import com.recipebook.ws.entity.RecipeBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeBookRepository extends JpaRepository<RecipeBook, Integer> {

    RecipeBook findById(int id);
}