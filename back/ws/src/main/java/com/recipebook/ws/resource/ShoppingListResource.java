package com.recipebook.ws.resource;

import com.recipebook.ws.consts.ResourceUrlConst;
import com.recipebook.ws.entity.ShoppingList;
import com.recipebook.ws.repository.ShoppingListRepository;
import com.recipebook.ws.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
