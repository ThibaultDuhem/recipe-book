package com.recipebook.ws.repository;

import com.recipebook.ws.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    Recipe findById(int id);
}