package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Stock;
import com.example.demo.Service.StockService;

import java.util.List;

@Controller
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public String getAllStocks(Model model) {
        List<Stock> stocks = stockService.getAllStocks();
        model.addAttribute("stocks", stocks);
        return "stock-list";
    }

    @GetMapping("/add")
    public String addStockForm(Model model) {
        model.addAttribute("stock", new Stock());
        return "add-stock";
    }

    @PostMapping("/add")
    public String saveStock(@ModelAttribute Stock stock) {
        stockService.saveStock(stock);
        return "redirect:/stock";
    }

    @GetMapping("/edit/{id}")
    public String editStockForm(@PathVariable Long id, Model model) {
        Stock stock = stockService.getStockById(id);
        model.addAttribute("stock", stock);
        return "edit-stock";
    }

    @PostMapping("/edit/{id}")
    public String updateStock(@PathVariable Long id, @ModelAttribute Stock stock) {
        stock.setId(id);
        stockService.saveStock(stock);
        return "redirect:/stock";
    }

    @GetMapping("/delete/{id}")
    public String deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return "redirect:/stock";
    }
}
