package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Quotes;

public interface QuotesRepository extends JpaRepository<Quotes, Long> {
}
