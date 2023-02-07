package com.recipebook.ws.resource;

import com.recipebook.ws.consts.ResourceUrlConst;
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
    public List<RecipeBook> createRecipeBooks(@RequestBody List<RecipeBook> recipeBooks){
        log.info("WS called");
        return recipeBookService.createRecipeBooks(recipeBooks);
    }

    @DeleteMapping
    public void deleteRecipeBooksById(@RequestBody List<Integer> ids) {
        recipeBookService.deleteRecipeBooksById(ids);
    }

    @PatchMapping
    public List<RecipeBook> updateRecipeBooks(@RequestBody List<RecipeBook> recipeBooks) {
        return recipeBookService.updateRecipeBooks(recipeBooks);
    }

}
