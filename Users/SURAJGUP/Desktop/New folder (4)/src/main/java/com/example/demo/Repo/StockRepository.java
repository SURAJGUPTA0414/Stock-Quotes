package com.example.demo.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
