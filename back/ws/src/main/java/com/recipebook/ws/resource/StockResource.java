package com.recipebook.ws.resource;

import com.recipebook.ws.consts.ResourceUrlConst;
import com.recipebook.ws.entity.ShoppingList;
import com.recipebook.ws.entity.Stock;
import com.recipebook.ws.repository.StockRepository;
import com.recipebook.ws.service.StockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(ResourceUrlConst.STOCK_URI)
@RestController
@RequiredArgsConstructor
@Slf4j
public class StockResource {
    private final StockRepository stockRepository;

    private final StockService stockService;

    @GetMapping
    public List<Stock> retrieveAllStock(){
        log.info("WS called");
        return stockService.retrieveAllStock();
    }

    @GetMapping("/{id}")
    public Stock retrieveStock(@PathVariable int id){
        return stockService.retrieveStock(id);
    }

    @PostMapping
    public List<Stock> newStock(@RequestBody List<Stock> stock){
        log.info("WS called");
        return stockService.createStock(stock);
    }

    @DeleteMapping
    public void deleteStock(@RequestBody List<Integer> id) {
        stockService.deleteStockById(id);
    }

    @PatchMapping
    public List<Stock> updateStock(@RequestBody List<Stock> stock) {
        return stockService.updateStock(stock);
    }

}
