package com.recipebook.ws.repository;

import com.recipebook.ws.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

    Recipe findById(int id);

}