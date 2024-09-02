package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Stock;
import com.example.demo.Repo.StockRepository;

import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
