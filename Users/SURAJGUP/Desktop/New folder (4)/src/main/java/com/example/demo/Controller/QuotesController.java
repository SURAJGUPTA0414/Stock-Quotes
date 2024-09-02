package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Quotes;
import com.example.demo.Service.QuotesService;

import java.util.List;

@Controller
@RequestMapping("/quotes")
public class QuotesController {

    @Autowired
    private QuotesService quotesService;

    @GetMapping
    public String getAllQuotes(Model model) {
        List<Quotes> quotes = quotesService.getAllQuotes();
        model.addAttribute("quotes", quotes);
        return "quotes-list";
    }

    @GetMapping("/add")
    public String addQuoteForm(Model model) {
        model.addAttribute("quote", new Quotes());
        return "add-quote";
    }

    @PostMapping("/add")
    public String saveQuote(@ModelAttribute Quotes quote) {
        quotesService.saveQuote(quote);
        return "redirect:/quotes";
    }

    @GetMapping("/edit/{id}")
    public String editQuoteForm(@PathVariable Long id, Model model) {
        Quotes quote = quotesService.getQuoteById(id);
        model.addAttribute("quote", quote);
        return "edit-quote";
    }

    @PostMapping("/edit/{id}")
    public String updateQuote(@PathVariable Long id, @ModelAttribute Quotes quote) {
        quote.setId(id);
        quotesService.saveQuote(quote);
        return "redirect:/quotes";
    }

    @GetMapping("/delete/{id}")
    public String deleteQuote(@PathVariable Long id) {
        quotesService.deleteQuote(id);
        return "redirect:/quotes";
    }
}
