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
    public Stock newStock(@RequestBody Stock stock){
        log.info("WS called");
        return stockService.createStock(stock);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable("id") int id) {
        stockService.deleteStockById(id);
    }

    @PatchMapping("/{id}")
    public Stock updateStock(@RequestBody Stock stock) {
        return stockService.updateStock(stock);
    }

}
