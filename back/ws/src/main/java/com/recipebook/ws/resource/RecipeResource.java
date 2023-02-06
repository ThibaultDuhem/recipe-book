package com.recipebook.ws.resource;

import com.recipebook.ws.consts.ResourceUrlConst;
import com.recipebook.ws.entity.Recipe;
import com.recipebook.ws.entity.RecipeBook;
import com.recipebook.ws.repository.RecipeBookRepository;
import com.recipebook.ws.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(ResourceUrlConst.RECIPE_URI)
@RestController
@RequiredArgsConstructor
@Slf4j
public class RecipeResource {
    private final RecipeBookRepository recipeBookRepository;

    private final RecipeService recipeService;

    @GetMapping
    public List<Recipe> retrieveAllRecipes(){
        log.info("WS called");
        return recipeService.retrieveAllRecipe();
    }

    @GetMapping("/{id}")
    public Recipe retrieveRecipe(@PathVariable int id){
        return recipeService.retrieveRecipe(id);
    }

    @PostMapping
    public List<Recipe> newRecipe(@RequestBody List<Recipe> recipe){
        log.info("WS called");
        return recipeService.createRecipe(recipe);
    }

    @DeleteMapping
    public void deleteRecipe(@RequestBody List<Long> id) {
        recipeService.deleteRecipeById(id);
    }

    @PatchMapping
    public List<Recipe> updateIngredient(@RequestBody List<Recipe> recipe) {
        return recipeService.updateRecipe(recipe);
    }

}

