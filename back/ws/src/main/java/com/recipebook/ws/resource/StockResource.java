package com.recipebook.ws.resource;

import com.recipebook.ws.consts.ResourceUrlConst;
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
    public List<Stock> createStocks(@RequestBody List<Stock> stocks){
        log.info("WS called");
        return stockService.createStocks(stocks);
    }

    @DeleteMapping
    public void deleteStocksById(@RequestBody List<Integer> ids) {
        stockService.deleteStocksById(ids);
    }

    @PatchMapping
    public List<Stock> updateStocks(@RequestBody List<Stock> stocks) {
        return stockService.updateStocks(stocks);
    }

}
