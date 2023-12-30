package bahlawan.com.salesmanagementsystem.services;

import bahlawan.com.salesmanagementsystem.dtos.ProductRequest;
import bahlawan.com.salesmanagementsystem.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product create(ProductRequest request);

    Product update(int productId, ProductRequest request);
}
