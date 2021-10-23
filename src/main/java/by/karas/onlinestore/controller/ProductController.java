package by.karas.onlinestore.controller;

import by.karas.onlinestore.domain.Product;
import by.karas.onlinestore.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/products")
    public String products(Map<String, Object> model){
        Iterable<Product> products;
        products = productRepository.findAll();
        model.put("products", products);
        return "products_page";
    }
}

