package com.recipebook.ws.resource;

import com.recipebook.ws.consts.ResourceUrlConst;
import com.recipebook.ws.entity.Ingredient;
import com.recipebook.ws.entity.RecipeBook;
import com.recipebook.ws.repository.RecipeBookRepository;
import com.recipebook.ws.service.RecipeBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ResourceUrlConst.RECIPE_BOOK_URI)
@RestController
@RequiredArgsConstructor
@Slf4j
public class RecipeBookResource {
    private final RecipeBookRepository recipeBookRepository;

    private final RecipeBookService recipeBookService;

    @GetMapping
    public List<RecipeBook> retrieveAllRecipeBooks(){
        log.info("WS called");
        return recipeBookService.retrieveAllRecipeBook();
    }
    @GetMapping("/{id}")
    public RecipeBook retrieveRecipeBook(@PathVariable int id){
        return recipeBookService.retrieveRecipeBook(id);
    }

    @PostMapping
    public RecipeBook newRecipeBook(@RequestBody RecipeBook recipeBook){
        log.info("WS called");
        return recipeBookService.createRecipeBook(recipeBook);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipeBook(@PathVariable int id) {
        recipeBookService.deleteRecipeBookById(id);
    }

    @PatchMapping("/{id}")
    public RecipeBook updateRecipeBook(@RequestBody RecipeBook recipeBook) {
        return recipeBookService.updateRecipeBook(recipeBook);
    }

}
