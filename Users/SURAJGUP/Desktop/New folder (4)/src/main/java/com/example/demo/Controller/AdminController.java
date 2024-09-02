package com.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Product;

import com.example.demo.Service.ProductService;


import java.util.List;

@Controller
@RequestMapping("/products")
public class AdminController {

    @Autowired
    private ProductService productService;
  
  
    @GetMapping
    public String viewProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
       // // Add a new Product object for the form
        model.addAttribute("product", new Product());
        return "products";
    }

    
    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/admin/products";
    }
    
   
    
    @GetMapping("/edit-product/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "edit-product"; // Ensure this template exists
    }

 
    @PostMapping("/edit-product/{id}")
    public String editProduct(@PathVariable Long id, @ModelAttribute Product product) {
        product.setId(id);
        productService.saveProduct(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/delete-product/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "redirect:/admin/products";
    }
    
    
    
}
  


/* @GetMapping("/add-product")
 public String addProductForm(Model model) {
     model.addAttribute("product", new Product());
    // return "add-product";
     return "products";
 }
 
 
 /* @GetMapping("/add-product")
  public String showAddProductForm(Model model) {
      model.addAttribute("product", new Product());
      return "add-product";
  }
*/


 
