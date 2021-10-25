package by.karas.onlinestore.controller;

import by.karas.onlinestore.domain.Product;
import by.karas.onlinestore.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String home(@RequestParam (value = "login", defaultValue = "visitor") String login, Model /*Map<String, Object>*/ model){
        model.addAttribute("login", login);
        System.out.println("login = " + login);
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "home_page";
    }

    @PostMapping("/login")
    public String login(@RequestParam ("login") String login, Model model){
        model.addAttribute("login", login);
        Iterable<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "home_page";
    }



    @PostMapping("/products")
    public String products(@RequestParam ("name") String name,
                           @RequestParam ("price") Double price,
                           Model model){
//                           Map<String, Object> model){
//        Product newProduct = new Product(name, price);
//        productRepository.save(newProduct);
        Iterable<Product> products = productRepository.findAll();
//        List<Product> productList = new ArrayList<>();
//        productList.add(newProduct);
        //model.put("products", products);
        model.addAttribute("products", products);
        return "products_page";
    }
}

