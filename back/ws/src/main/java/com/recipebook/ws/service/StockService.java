package com.recipebook.ws.service;

import com.recipebook.ws.entity.Stock;
import com.recipebook.ws.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockService {

    @Autowired
    private final StockRepository stockRepository;

    public List<Stock> retrieveAllStock(){
        log.info("Retrieving all stock list in DB");
        List<Stock> stocks = stockRepository.findAll();
        log.info("{} elements retrieved", stocks.size());
        return stocks;
    }

    public Stock retrieveStock(int id){
        log.info("Retrieving one stock with {} in id", id);
        Stock stock = stockRepository.findById(id);
        log.info("{} retrieved", stock.getName());
        return stock;
    }

    public List<Stock> createStocks(List<Stock> stocks) {
        log.info("create stocks in DB");
        return stockRepository.saveAll(stocks);
    }

    public void deleteStocksById(List<Integer> ids) {
        stockRepository.deleteAllById(ids);
        log.info("Deleting one stock list with {} in id", ids);
    }

    public List<Stock> updateStocks(List<Stock> stocks) {
        log.info("update stocks in DB");
        return stockRepository.saveAll(stocks);
    }

}
