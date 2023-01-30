package com.recipebook.ws.resource;

import com.recipebook.ws.consts.ResourceUrlConst;
import com.recipebook.ws.entity.Recipe;
import com.recipebook.ws.service.RecipeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(ResourceUrlConst.RECIPE_URI)
@RestController
@RequiredArgsConstructor
@Slf4j
public class RecipeResource {

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
}
