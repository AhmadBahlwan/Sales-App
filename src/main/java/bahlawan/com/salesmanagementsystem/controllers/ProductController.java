package bahlawan.com.salesmanagementsystem.controllers;

import bahlawan.com.salesmanagementsystem.dtos.ProductRequest;
import bahlawan.com.salesmanagementsystem.models.Product;
import bahlawan.com.salesmanagementsystem.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product create(@RequestBody ProductRequest request){
        return productService.create(request);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody ProductRequest request){
        return productService.update(id,request);
    }
}
