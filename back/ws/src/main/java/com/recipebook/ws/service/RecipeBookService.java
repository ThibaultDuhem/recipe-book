package com.recipebook.ws.service;

import com.recipebook.ws.entity.Ingredient;
import com.recipebook.ws.entity.RecipeBook;
import com.recipebook.ws.repository.RecipeBookRepository;
import com.recipebook.ws.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeBookService {
    private final RecipeRepository recipeRepository;

    @Autowired
    private final RecipeBookRepository recipeBookRepository;

    public List<RecipeBook> retrieveAllRecipeBook(){
        log.info("Retrieving all recipeBooks in DB");
        List<RecipeBook> recipeBooks = recipeBookRepository.findAll();
        log.info("{} elements retrieved", recipeBooks.size());
        return recipeBooks;
    }

    public RecipeBook retrieveRecipeBook(int id){
        log.info("Retrieving one recipeBook with {} in id", id);
        RecipeBook recipeBook = recipeBookRepository.findById(id);
        log.info("{} retrieved", recipeBook.getName());
        return recipeBook;
    }

    public List<RecipeBook> createRecipeBook(List<RecipeBook> recipeBook) {
        log.info("create recipe book in DB");
        return recipeBookRepository.saveAll(recipeBook);
    }

    public void deleteRecipeBookById(List<Integer> id) {
        recipeBookRepository.deleteAllById(id);
        log.info("Deleting recipe book list with {} in id", id);
    }

    public List<RecipeBook> updateRecipeBook(List<RecipeBook> recipeBook) {
        log.info("update recipe book in DB");
        return recipeBookRepository.saveAll(recipeBook);
    }

}
