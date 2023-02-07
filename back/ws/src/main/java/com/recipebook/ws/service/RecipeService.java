package com.recipebook.ws.service;

import com.recipebook.ws.entity.Recipe;
import com.recipebook.ws.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeService {

    @Autowired
    private final RecipeRepository recipeRepository;

    public List<Recipe> retrieveAllRecipe(){
        log.info("Retrieving all recipes in DB");
        List<Recipe> recipes = recipeRepository.findAll();
        log.info("{} elements retrieved", recipes.size());
        return recipes;
    }

    public Recipe retrieveRecipe(int id){
        log.info("Retrieving one recipe with {} in id", id);
        Recipe recipe = recipeRepository.findById(id);
        log.info("{} retrieved", recipe.getName());
        return recipe;
    }

    public List<Recipe> createRecipes(List<Recipe> recipes) {
        log.info("create recipe in DB");
        return recipeRepository.saveAll(recipes);
    }

    public void deleteRecipesById(List<Integer> ids) {
        recipeRepository.deleteAllById(ids);
        log.info("Deleting one recipe list with {} in id", ids);
    }

    public List<Recipe> updateRecipes(List<Recipe> recipes) {
        log.info("update recipe in DB");
        return recipeRepository.saveAll(recipes);
    }

}
