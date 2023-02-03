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
    public Recipe newRecipe(@RequestBody Recipe recipe){
        log.info("WS called");
        return recipeService.createRecipe(recipe);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable("id") Long id) {
        recipeService.deleteRecipeById(id);
    }

    @PatchMapping("/{id}")
    public Recipe updateIngredient(@RequestBody Recipe recipe) {
        return recipeService.updateRecipe(recipe);
    }

}

