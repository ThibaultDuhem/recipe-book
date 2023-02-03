package com.recipebook.ws.service;

import com.recipebook.ws.entity.Ingredient;
import com.recipebook.ws.entity.User;
import com.recipebook.ws.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IngredientService {

    @Autowired
    private final IngredientRepository ingredientRepository;

    public List<Ingredient> retrieveAllIngredient(){
        log.info("Retrieving all ingredients in DB");
        List<Ingredient> ingredients = ingredientRepository.findAll();
        log.info("{} elements retrieved", ingredients.size());
        return ingredients;
    }

    public Ingredient retrieveIngredient(int id){
        log.info("Retrieving one ingredient with {} in id", id);
        Ingredient ingredient = ingredientRepository.findById(id);
        log.info("{} retrieved", ingredient.getName());
        return ingredient;
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        log.info("create one ingredient in DB");
        return ingredientRepository.save(ingredient);
    }

    public void deleteIngredientById(int id) {
        ingredientRepository.deleteById(id);
        log.info("Deleting one ingredient list with {} in id", id);
    }

    public Ingredient updateIngredient(Ingredient ingredient) {
        log.info("update one ingredient in DB");
        return ingredientRepository.save(ingredient);
    }

}
