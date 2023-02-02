package com.recipebook.ws.service;

import com.recipebook.ws.entity.RecipeBook;
import com.recipebook.ws.repository.RecipeBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RecipeBookService {

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
}
