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

    public RecipeBook createRecipeBook(RecipeBook recipeBook) {
        log.info("create one recipe book in DB");
        return recipeBookRepository.save(recipeBook);
    }

    public void deleteRecipeBookById(int id) {
        recipeBookRepository.deleteById(id);
        log.info("Deleting one recipe book list with {} in id", id);
    }

    public RecipeBook updateRecipeBook(RecipeBook recipeBook) {
        log.info("update one recipe book in DB");
        return recipeBookRepository.save(recipeBook);
    }

}
