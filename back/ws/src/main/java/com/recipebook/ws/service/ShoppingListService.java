package com.recipebook.ws.service;

import com.recipebook.ws.entity.Recipe;
import com.recipebook.ws.entity.ShoppingList;
import com.recipebook.ws.repository.ShoppingListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShoppingListService {

    @Autowired
    private final ShoppingListRepository shoppingListRepository;

    public List<ShoppingList> retrieveAllShoppingList(){
        log.info("Retrieving all shopping list in DB");
        List<ShoppingList> shoppingLists = shoppingListRepository.findAll();
        log.info("{} elements retrieved", shoppingLists.size());
        return shoppingLists;
    }

    public ShoppingList retrieveShoppingList(int id){
        log.info("Retrieving one shopping list with {} in id", id);
        ShoppingList shoppingList = shoppingListRepository.findById(id);
        log.info("{} retrieved", shoppingList.getName());
        return shoppingList;
    }

    public List<ShoppingList> createShoppingList(List<ShoppingList> shoppingList) {
        log.info("create shopping list in DB");
        return shoppingListRepository.saveAll(shoppingList);
    }

    public void deleteShoppingListById(List<Integer> id) {
        shoppingListRepository.deleteAllById(id);
        log.info("Deleting shopping list list with {} in id", id);
    }

    public List<ShoppingList> updateShoppingList(List<ShoppingList> shoppingList) {
        log.info("update shopping list in DB");
        return shoppingListRepository.saveAll(shoppingList);
    }

}
