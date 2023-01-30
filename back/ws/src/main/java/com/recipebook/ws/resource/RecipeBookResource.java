package com.recipebook.ws.resource;

import com.recipebook.ws.consts.ResourceUrlConst;
import com.recipebook.ws.entity.RecipeBook;
import com.recipebook.ws.service.RecipeBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(ResourceUrlConst.RECIPE_BOOK_URI)
@RestController
@RequiredArgsConstructor
@Slf4j
public class RecipeBookResource {

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
}
