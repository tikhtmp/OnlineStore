package by.karas.onlinestore.controller;

import by.karas.onlinestore.domain.Product;
import by.karas.onlinestore.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    public String index(){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home(/*@RequestParam ("login") String login,*/ Map<String, Object> model){
        //model.put("login", login);
        Iterable<Product> products;
        products = productRepository.findAll();
        model.put("products", products);
        Product product = new Product();
        model.put("product", product);
        return "home_page";
    }

    @PostMapping("/products")
    public String products(@RequestParam ("name") String name,
                           @RequestParam ("price") Double price,
                           Map<String, Object> model){
        //Product newProduct = new Product(null, name, price);
        Product newProduct = new Product(name, price);
        productRepository.save(newProduct);
        Iterable<Product> products;
        products = productRepository.findAll();
//        List<Product> productList = new ArrayList<>();
//        productList.add(newProduct);
        //model.put("products", products);
        model.put("products", products);
        return "products_page";
    }
}

