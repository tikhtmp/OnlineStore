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
 //   public ProductController(ProductRepository products){
//        this.products = products;
//    }

//    @ModelAttribute("products")
//    public List<Product> getAllProducts() {
//        return this.products.findProducts();
//    }

    //ProductService productService = new ProductService();
//    private static List<Product> productList = new ArrayList<>();
//
//    static {
//        productList.add(new Product(1, "Car", 1500.00));
//        productList.add(new Product(2, "Book", 12.25));
//        productList.add(new Product(3, "Suit", 115.48));
//    }

//    public ProductController(ProductRepository products) {
//        this.productRepository = products;
//    }

    @GetMapping("/products")
    public String products(Map<String, Object> model){
        Iterable<Product> products;
        products = productRepository.findAll();
        model.put("products", products);
       // model.addAttribute("product", new Product());
        //model.addAttribute("products", manageProducts(null));
        //model.addAttribute("products", productRepository);
        //model.addAttribute("products", products);
        return "products_page";
    }

//    @PostMapping("/createProduct")
//    public String createProduct(@ModelAttribute Product product){
//        manageProducts(product);
//        return "redirect:/products";
//    }
//
//    private static List<Product> manageProducts(Product product){
//        if(product !=null) productList.add(product);
//        return productList;
//    }

}

