package com.recipebook.ws.resource;

import com.recipebook.ws.consts.ResourceUrlConst;
import com.recipebook.ws.entity.Ingredient;
import com.recipebook.ws.entity.User;
import com.recipebook.ws.service.IngredientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ResourceUrlConst.INGREDIENT_URI)
@RestController
@RequiredArgsConstructor
@Slf4j
public class IngredientResource {

    private final IngredientService ingredientService;

    @GetMapping
    public List<Ingredient> retrieveAllIngredient(){
        log.info("WS called");
        return ingredientService.retrieveAllIngredient();
    }

    @GetMapping("/{id}")
    public Ingredient retrieveIngredient(@PathVariable int id){
        return ingredientService.retrieveIngredient(id);
    }

    @PostMapping
    public List<Ingredient> newIngredient(@RequestBody List<Ingredient> ingredient){
        log.info("WS called");
        return ingredientService.createIngredient(ingredient);
    }

    @DeleteMapping
    public void deleteIngredient(@RequestBody List<Integer> id) {
        ingredientService.deleteIngredientById(id);
    }

    @PatchMapping
    public List<Ingredient> updateIngredient(@RequestBody List<Ingredient> ingredient) {
        return ingredientService.updateIngredient(ingredient);
    }

}
