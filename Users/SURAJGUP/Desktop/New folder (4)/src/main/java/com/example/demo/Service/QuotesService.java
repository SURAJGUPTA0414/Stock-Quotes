package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Quotes;
import com.example.demo.Repo.QuotesRepository;

import java.util.List;

@Service
public class QuotesService {

    @Autowired
    private QuotesRepository quotesRepository;

    public List<Quotes> getAllQuotes() {
        return quotesRepository.findAll();
    }

    public Quotes getQuoteById(Long id) {
        return quotesRepository.findById(id).orElse(null);
    }

    public Quotes saveQuote(Quotes quote) {
        return quotesRepository.save(quote);
    }

    public void deleteQuote(Long id) {
        quotesRepository.deleteById(id);
    }
}
