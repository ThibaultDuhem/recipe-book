package com.recipebook.ws.resource;

import com.recipebook.ws.consts.ResourceUrlConst;
import com.recipebook.ws.entity.Recipe;
import com.recipebook.ws.entity.ShoppingList;
import com.recipebook.ws.repository.ShoppingListRepository;
import com.recipebook.ws.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ResourceUrlConst.SHOPPING_LIST_URI)
@RestController
@RequiredArgsConstructor
@Slf4j
public class ShoppingListResource {
    private final ShoppingListRepository shoppingListRepository;

    private final ShoppingListService shoppingListService;

    @GetMapping
    public List<ShoppingList> retrieveAllShoppingList(){
        log.info("WS called");
        return shoppingListService.retrieveAllShoppingList();
    }

    @GetMapping("/{id}")
    public ShoppingList retrieveShoppingList(@PathVariable int id){
        return shoppingListService.retrieveShoppingList(id);
    }

    @PostMapping
    public List<ShoppingList> newShoppingList(@RequestBody List<ShoppingList> shoppingList){
        log.info("WS called");
        return shoppingListService.createShoppingList(shoppingList);
    }

    @DeleteMapping
    public void deleteShoppingList(@RequestBody List<Integer> id) {
        shoppingListService.deleteShoppingListById(id);
    }

    @PatchMapping
    public List<ShoppingList> updateShoppingList(@RequestBody List<ShoppingList> shoppingList) {
        return shoppingListService.updateShoppingList(shoppingList);
    }

}
