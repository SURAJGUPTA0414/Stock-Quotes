package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

	
	  
    @GetMapping("/home")  // Maps to the root URL
    public String homePage() {
        return "home";  // This should match the name of your HTML file
    }
    
	
	
}
