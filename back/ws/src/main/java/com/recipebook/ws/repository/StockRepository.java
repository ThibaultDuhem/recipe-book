package com.recipebook.ws.repository;

import com.recipebook.ws.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    Stock findById(int id);
}